package kg.Robotics.service;


import kg.Robotics.dao.RequestDyagnosys;
import kg.Robotics.dao.SenderRequest;
import kg.Robotics.dao.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private static final Logger log= LoggerFactory.getLogger(TaskService.class);

    public String ServiceActions(InterfaceAct interfaceAct){return new Dron().action(interfaceAct);  }


    public Object  requestDiagnosys(SenderRequest senderRequest,RequestDyagnosys requestDyagnosys){

        return senderRequest.sendRequest(requestDyagnosys);
    }

}