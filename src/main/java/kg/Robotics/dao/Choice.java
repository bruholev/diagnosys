package kg.Robotics.dao;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Map;


public class Choice {


    private String id ;

    private String label;

    public Choice() {    }

    public Choice(String id , String label) {
        this.id  = id ;
        this.label = label;
    }
}
