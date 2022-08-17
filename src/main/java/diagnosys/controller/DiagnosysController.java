package diagnosys.controller;

import diagnosys.service.DiagnosysService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DiagnosysController {
private static final Logger log= LoggerFactory.getLogger(DiagnosysController.class);
    @Autowired
    DiagnosysService service;

    @GetMapping("/diagnosys")
    public String sendRequest(){
        //log.info("Contrller"+ service.requestDiagnosys(new Diagnosys()));
        return "Shoot";
    }

}
