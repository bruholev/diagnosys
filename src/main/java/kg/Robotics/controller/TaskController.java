package kg.Robotics.controller;

import kg.Robotics.dao.*;
import kg.Robotics.repository.EvidenceRepository;
import kg.Robotics.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;


@Controller
public class TaskController {
    private static final Logger log= LoggerFactory.getLogger(TaskController.class);
    ExecutorService service= Executors.newCachedThreadPool();
    @Autowired
    EvidenceRepository evidenceRepository;

    @Autowired
    TaskService taskService;


    @GetMapping("/")
    public String begin(){        return "index";}

    @GetMapping("/parse")
    public String beginDiagnosys(@RequestParam (value = "age",required = false) String age,
                                 @RequestParam (value = "sex",required = false) String sex,
                                 @RequestParam (value = "id",required = false) String id,
                                 @RequestParam (value = "choice_id",required = false) String choice_id,
                                 Model model){
        RequestDyagnosys requestDyagnosys= new RequestDyagnosys();
        List<Symptom> list=new ArrayList<>();
        requestDyagnosys.setAge(new Age(age));
        requestDyagnosys.setSex(sex);
        list.add(new Symptom( id,choice_id,"initial"));
        requestDyagnosys.setEvidence(list);
        return "dyagnosys";
    }

    @GetMapping("/diagnosys")
    public String sendRequest(@RequestParam(value = "checkbox",required = false) String checkbox,
                              @RequestParam(value = "token",required = false)String token,
                              @RequestParam(value = "initial",required = false)String initial,
                              @RequestParam(value = "sex",required = false)String sex,
                              @RequestParam(value = "age",required = false)String age,
                              @RequestParam(value = "symptom",required = false)List<String >symptom,
                              Model model) throws ExecutionException, InterruptedException, TimeoutException {
        Callable<String> callableTask = () -> {
            String page="diagnosys";
            String  tokenInit="";
            RequestParse requestParse=new RequestParse();
            List<Symptom> list=new ArrayList<>();
            List<Evidence> listEv=new ArrayList<>();
            List<Condition> conditionList= new ArrayList<>();
            RequestDyagnosys requestDyagnosys= new RequestDyagnosys();

            if(initial.equals("initial")){
                tokenInit="tokenDiagnosys"+ new Date();
                requestParse.setAge(new Age(age));
                requestParse.setText(symptom.get(0));
                ResponseParse requestResponseParse=( ResponseParse) taskService
                        .request (new Parse(),requestParse);

                List <Mention> listSymptom =requestResponseParse.getMentions();
                listSymptom.stream().forEach(e-> list.add(new Symptom(e.getId(),"present",initial)));

                requestDyagnosys.setAge(new Age(age));
                requestDyagnosys.setSex(sex);
                requestDyagnosys.setEvidence(list);
                evidenceRepository.save(new Evidence(listSymptom.get(0).getId(),
                        "present", tokenInit,sex,age));
            }
            else {

                symptom.stream().forEach(e->evidenceRepository.save(new Evidence(e,
                        e.equals(checkbox)?"present":"absent",token,sex,age)));
                listEv= evidenceRepository.findAllByToken(token);

                for (Evidence evidence:listEv) {
                    list.add(new Symptom(evidence.getIdText(),   evidence.getChoiceId()));
                    requestDyagnosys.setAge(new Age(evidence.getAge()));
                    requestDyagnosys.setSex(evidence.getSex());
                }


                requestDyagnosys.setEvidence(list);
            }
            log.info("requestDyagnosys getSex "+requestDyagnosys.getSex());
            log.info("requestDyagnosys getSex "+requestDyagnosys.getAge().getValue());
            requestDyagnosys.getEvidence().stream().forEach(e->log.info("requestDyagnosys getEvidence "+e.getId()+
                    " getChoice_id "+ e.getChoice_id()+" getSource "+e.getSource()));
            ResponseDyagnosys  responseDyagnosys= (ResponseDyagnosys) taskService.request (new Diagnosys(),requestDyagnosys);
            if(responseDyagnosys.getQuestion()!=null) {
                Question question = responseDyagnosys.getQuestion();
                List<Item> listItem = new ArrayList<>();
                model.addAttribute("text", question.getText());
                if (question.getType().equals("single")) {
                    model.addAttribute("name", question.getItems().get(0).getName());
                    model.addAttribute("id", question.getItems().get(0).getId());
                    page = "diagnosys";
                } else {
                    listItem = question.getItems().stream().collect(Collectors.toList());
                    model.addAttribute("list", listItem);
                    page = "diagnosysMulti";
                }
                model.addAttribute("tokenId", initial.equals("initial")?tokenInit:token);
                model.addAttribute("sexMem", requestDyagnosys.getSex());
                model.addAttribute("ageMem", requestDyagnosys.getAge().getValue());
            }else if(responseDyagnosys.getQuestion()==null){
                conditionList= responseDyagnosys.getConditions().stream().collect(Collectors.toList());
                model.addAttribute("list", conditionList);
                page="results";
            }
            return page ;   };
        String pageString= service.submit(callableTask).get(10000, TimeUnit.MILLISECONDS);
        return pageString;
    }





}