import java.util.Calendar;

public class SportEvent {
    private String eventCode, commment;
    private Calendar time;

    public SportEvent(String eventCode, String comment, Calendar date) {
        this.eventCode = eventCode;
        this.commment = comment;
        this.time = time;
    }

    public String getEventCode() {
        return eventCode;
    }

    public String getCommment() {
        return commment;
    }

    public Calendar getTime() {
        return time;
    }
}