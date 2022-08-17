package kg.Robotics.dao;


import java.util.List;


public class ResponseDyagnosys {

    private Question question;
    private List<Condition> conditions;
    private  Extra extras;
    private String has_emergency_evidence;
    private String should_stop;
    private String interview_token;

    public ResponseDyagnosys() {
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public Extra getExtras() {
        return extras;
    }

    public void setExtras(Extra extras) {
        this.extras = extras;
    }

    public String getHas_emergency_evidence() {
        return has_emergency_evidence;
    }

    public void setHas_emergency_evidence(String has_emergency_evidence) {
        this.has_emergency_evidence = has_emergency_evidence;
    }

    public String getShould_stop() {
        return should_stop;
    }

    public void setShould_stop(String should_stop) {
        this.should_stop = should_stop;
    }

    public String getInterview_token() {
        return interview_token;
    }

    public void setInterview_token(String interview_token) {
        this.interview_token = interview_token;
    }
}
