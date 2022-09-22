package kg.Robotics.dao;

import javax.persistence.*;

@Entity
@Table(name="table_evidence")
public class Evidence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idText;
    private String choiceId;
    private String token;
    private String sex;
    private String age;

    public Evidence(String idText, String token, String sex, String age) {
        this.idText = idText;
        this.token = token;
        this.sex = sex;
        this.age = age;
    }

    public Evidence(String idText, String choiceId, String token, String sex, String age) {
        this.idText = idText;
        this.choiceId = choiceId;
        this.token = token;
        this.sex = sex;
        this.age = age;
    }

    public Evidence() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdText() {
        return idText;
    }

    public void setIdText(String idText) {
        this.idText = idText;
    }

    public String getChoiceId() {
        return choiceId;
    }

    public void setChoiceId(String choiceId) {
        this.choiceId = choiceId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
