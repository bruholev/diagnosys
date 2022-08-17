package kg.Robotics.dao;

import java.util.List;

public class RequestDyagnosys {
    private String sex;
    private Age age;
    private List<Symptom> evidence;

    public RequestDyagnosys() {
    }

    public RequestDyagnosys(String sex, Age age) {
        this.sex = sex;
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public List<Symptom> getEvidence() {
        return evidence;
    }

    public void setEvidence(List<Symptom> evidence) {
        this.evidence = evidence;
    }
}
