package kg.Robotics.dao;

import diagnosys.service.DiagnosysService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


public class Diagnosys implements SenderRequest{
    private static final Logger log= LoggerFactory.getLogger(DiagnosysService.class);
    String ip="https://api.infermedica.com/v3/diagnosis";
    String id="bb05e0eb";
    String key="f1e2990c29393ce9bde814c518e53f24";


    @Override
    public Object sendRequest(RequestDyagnosys requestDyagnosys) {

      /*  ResponseDyagnosys responceXML=   WebClient.create()
                .post()
               .uri(ip)
                .header("App-Id",id)
               .header("App-Key",key)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)


               .body(Mono.just("{\n" +
                        "        \"sex\": \"female\",\n" +
                        "        \"age\": {\n" +
                        "          \"value\": 25\n" +
                        "        },\n" +
                        "        \"evidence\": [\n" +
                        "          {\"id\": \"s_47\", \"choice_id\": \"present\", " +
                        "\"source\": \"initial\"},\n" +
                        "          {\"id\": \"s_22\", \"choice_id\": \"present\", " +
                        "\"source\": \"initial\"},\n" +
                        "          {\"id\": \"p_81\", \"choice_id\": \"absent\"}\n" +
                        "        ]\n" +
                        "  }"),String.class)
           .retrieve()
             .bodyToMono(ResponseDyagnosys.class)
            .block();*/
        log.info("sendRequest age"+requestDyagnosys.getAge());
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

        RequestResponseDyagnosys requestResponseDyagnosys=new RequestResponseDyagnosys(requestDyagnosys,responceXML);
        return requestResponseDyagnosys;
    }

    public Diagnosys() {
    }
}
