package kg.Robotics.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class Parse implements SenderRequest {

    private static final Logger log= LoggerFactory.getLogger(Parse.class);
    String ip="https://api.infermedica.com/v3/parse";
    String id="bb05e0eb";
    String key="f1e2990c29393ce9bde814c518e53f24";


    @Override
    public Object sendRequest(Object requestParse) {
        RequestParse request=(RequestParse) requestParse;
        log.info("sendRequest age"+request.getAge().getValue());
        log.info("sendRequest age"+request.getText());
        ResponseParse responceXML=   WebClient.create()
                .post()
                .uri(ip)
                .header("App-Id",id)
                .header("App-Key",key)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .bodyValue("{\n" +
                        "    \"age\": {\n" +
                        "        \"value\": " +request.getAge().getValue()+
                        "    },\n" +
                        "    \"text\": \""+request.getText()+"\"\n" +
                        "}")
                .retrieve()
                .bodyToMono(ResponseParse.class)
                .block();
         log.info("response "+ responceXML.getMentions().get(0).getName());
    //    RequestResponseParse requestResponseParse=new RequestResponseParse(request,responceXML);
        return responceXML;
    }

    public Parse() {
    }
}

