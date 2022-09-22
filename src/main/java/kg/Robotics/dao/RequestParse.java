package kg.Robotics.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;



public class RequestParse {
    private Age age;
    private String text;

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public RequestParse() {    }

    public RequestParse(Age age, String text) {
        this.age = age;
        this.text = text;
    }
}
