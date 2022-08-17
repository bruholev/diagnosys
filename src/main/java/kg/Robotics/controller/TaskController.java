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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class TaskController {
    private static final Logger log= LoggerFactory.getLogger(TaskController.class);

@Autowired
    EvidenceRepository evidenceRepository;

    @Autowired
    TaskService taskService;
    //  отправляем запрос
  /*  @GetMapping("/{id}")
    public String shoot(@PathVariable("id") String id, Model model) {
        String action="";
        InterfaceAct interfaceAct=id.equals("shoot")?new Shoot():
                id.equals("shootAllOne")?new ShootAllOne():
                id.equals("monitorsilence")?new Monitorsilence():
                id.equals("monitorShoot")? new MonitorShoot(): (InterfaceAct) new Object();
        action=taskService.ServiceActions(interfaceAct);
       model.addAttribute("record",action);
        return "Shoot";
    }*/

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
    public String sendRequest(@RequestParam(value = "yes",required = false)String yes,
                              @RequestParam(value = "token",required = false)String token,
                              @RequestParam(value = "initial",required = false)String initial,
                              @RequestParam(value = "sex",required = false)String sex,
                              @RequestParam(value = "age",required = false)String age,
                              @RequestParam(value = "symptom",required = false)String symptom,Model model){
        String page="diagnosys";
        List<Symptom> list=new ArrayList<>();
        List<Evidence> listEv=new ArrayList<>();
        RequestDyagnosys requestDyagnosys= new RequestDyagnosys();

        if(initial.equals("initial")){
            requestDyagnosys.setAge(new Age(age));
            requestDyagnosys.setSex(sex);
            list.add(new Symptom(symptom,"present",initial));
            requestDyagnosys.setEvidence(list);
        }
      else if(!token.equals("")){
            listEv=evidenceRepository.findAllByToken(token);
            age=listEv.get(0).getAge();
            sex=listEv.get(0).getSex();
            listEv.stream().forEach(e->list.add(new Symptom(e.getIdText(),e.getChoiceId())));
            log.info("token "+token);
            log.info("initial "+initial);
            log.info("sex "+sex);
            log.info("age "+age);
            log.info("symptom "+symptom);
            requestDyagnosys.setAge(new Age(age));
            requestDyagnosys.setSex(sex);
            requestDyagnosys.setEvidence(list);
        }
         RequestResponseDyagnosys  responseDyagnosys= (RequestResponseDyagnosys) taskService.requestDiagnosys(new Diagnosys(),requestDyagnosys);
         Question question=responseDyagnosys.getResponseDyagnosys().getQuestion();
        model.addAttribute("text",question.getText());
        log.info("type"+question.getType());
        if(question.getType().equals("single")){
            model.addAttribute("name",question.getItems().get(0).getName());
        }
        else{

            model.addAttribute("list",question.getItems().stream().collect(Collectors.toList()));
            page="diagnosysMulti";
        }
        log.info("tokenIn"+responseDyagnosys.getResponseDyagnosys().getInterview_token());


model.addAttribute("tokenId",responseDyagnosys.getResponseDyagnosys().getInterview_token());
    for(Symptom symptoml:list){
        evidenceRepository.save(new Evidence(symptoml.getId(),symptoml.getChoice_id()
                ,responseDyagnosys.getResponseDyagnosys().getInterview_token()
                ,sex,age));
    }
    evidenceRepository.findAll().stream().forEach(e->log.info("list evid"+e.getIdText()));
        return page;
    }





}