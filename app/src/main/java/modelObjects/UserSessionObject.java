package modelObjects;

/**
 * Created by vraman on 7/17/15.
 */
public class UserSessionObject {

    private String userName;
    private String userEmail;

    public UserSessionObject(String userName, String userEmail){
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserName() {
        return userName;
    }
}
