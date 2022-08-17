package kg.Robotics;
import kg.Robotics.dao.Dron;
import kg.Robotics.dao.Monitorsilence;
import kg.Robotics.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


import java.awt.event.WindowEvent;


@SpringBootApplication
public class Application /*extends SpringBootServletInitializer*/ {


	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

/*@Override
	public SpringApplicationBuilder configure(SpringApplicationBuilder builder){
		return builder.sources(Application.class);
}*/


}


