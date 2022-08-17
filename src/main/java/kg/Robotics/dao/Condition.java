package kg.Robotics.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class Condition {
    private String id;
    private String name;
    private String common_name;
    private String probability;

    public Condition() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommon_name() {
        return common_name;
    }

    public void setCommon_name(String common_name) {
        this.common_name = common_name;
    }

    public String getProbability() {
        return probability;
    }

    public void setProbability(String probability) {
        this.probability = probability;
    }
}
