package kg.Robotics.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Extra {

    private Long id;
    private String idName;
    private String disable_groups;

    public Extra() {
    }

    public String getDisable_groups() {
        return disable_groups;
    }

    public void setDisable_groups(String disable_groups) {
        this.disable_groups = disable_groups;
    }
}
