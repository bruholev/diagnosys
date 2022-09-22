package kg.Robotics.dao;

import java.util.List;

public class ResponseParse {
    private List<Mention> mentions;
    private String obvious;

    public ResponseParse() {
    }

    public List<Mention> getMentions() {
        return mentions;
    }

    public void setMentions(List<Mention> mentions) {
        this.mentions = mentions;
    }

    public String getObvious() {
        return obvious;
    }

    public void setObvious(String obvious) {
        this.obvious = obvious;
    }
}
