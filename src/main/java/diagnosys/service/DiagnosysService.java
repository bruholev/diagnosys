package diagnosys.service;

import kg.Robotics.dao.RequestDyagnosys;
import kg.Robotics.dao.SenderRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DiagnosysService {
    private static final Logger log= LoggerFactory.getLogger(DiagnosysService.class);

    public Object  requestDiagnosys(SenderRequest senderRequest, RequestDyagnosys requestDyagnosys){
        log.info("DiagnosysService "+senderRequest.sendRequest(requestDyagnosys));
        return senderRequest.sendRequest(requestDyagnosys);
    }
}
