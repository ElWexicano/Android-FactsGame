package ie.iamshanedoyle.factsgame.models;

/**
 * Created by shane on 06/01/2014.
 */
public class Score {
    private String user;
    private int value;

    public Score(String user, int value) {
        this.user = user;
        this.value = value;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
