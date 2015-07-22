package database;

/**
 * Created by vraman on 7/19/15.
 */
public class SmartPinDataObject {

    private long id;
    private String userEmail;
    private int smartPin;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSmartPin() {
        return smartPin;
    }

    public void setSmartPin(int smartPin) {
        this.smartPin = smartPin;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }


}