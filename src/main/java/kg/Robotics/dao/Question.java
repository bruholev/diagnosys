package kg.Robotics.dao;

import lombok.*;

import javax.persistence.*;
import java.util.List;


public class Question {
    private String type;
    private String text;

    private List<Item> items;

    private Extra extras;

    private String interviewToken;

    public Question() {
    }

    public Question(String type, String text,Extra extras, String interviewToken) {
        this.type = type;
        this.text = text;
        this.extras = extras;
        this.interviewToken = interviewToken;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Extra getExtras() {
        return extras;
    }

    public void setExtras(Extra extras) {
        this.extras = extras;
    }

    public String getInterviewToken() {
        return interviewToken;
    }

    public void setInterviewToken(String interviewToken) {
        this.interviewToken = interviewToken;
    }
}
