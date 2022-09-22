package kg.Robotics.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


public class Diagnosys  implements SenderRequest{
    private static final Logger log= LoggerFactory.getLogger(Diagnosys.class);
    String ip="https://api.infermedica.com/v3/diagnosis";
    String id="bb05e0eb";
    String key="f1e2990c29393ce9bde814c518e53f24";


     @Override
    public Object sendRequest(Object requestDyagnosys) {
        RequestDyagnosys request=(RequestDyagnosys)requestDyagnosys;
        log.info("sendRequest age"+request.getAge().getValue());
        ResponseDyagnosys responceXML=   WebClient.create()
                .post()
                .uri(ip)
                .header("App-Id",id)
                .header("App-Key",key)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(requestDyagnosys),RequestDyagnosys.class)
                .retrieve()
                .bodyToMono(ResponseDyagnosys.class)
                .block();

   //   ResponseDyagnosys requestResponseDyagnosys=new RequestResponseDyagnosys(request ,responceXML);
        return responceXML;
    }

    public Diagnosys() {
    }
}
