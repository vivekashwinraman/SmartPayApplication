package managers;

import android.content.Context;
import android.content.SharedPreferences;

import modelObjects.UserSessionObject;

/**
 * Created by vraman on 7/17/15.
 */
public class SessionManager {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    private static final String SHARED_PREFERENCE_FILE = "SmartPayPreferences";
    private static final int PRIVATE_MODE = 0;
    private static final String KEY_USERNAME = "userName";
    private static final String KEY_USEREMAIL = "userEmail";
    private static final String KEY_IS_LOGGED = "isLogged";

    public SessionManager(Context context) {
        this.context = context;
        this.sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_FILE, PRIVATE_MODE);
        this.editor = this.sharedPreferences.edit();
    }

    public void createUserLoginSession(String userName, String userEmail) {
        editor.putBoolean(KEY_IS_LOGGED, true);
        editor.putString(KEY_USERNAME, userName);
        editor.putString(KEY_USEREMAIL, userEmail);
        editor.commit();
    }

    public void logOutUser() {
        editor.clear();
        editor.commit();
    }

    public UserSessionObject getUserSessionObject() {

        return new UserSessionObject(this.sharedPreferences.getString(KEY_USERNAME, null), this.sharedPreferences.getString(KEY_USEREMAIL, null));
    }

    public boolean isLoggedIn() {
        return this.sharedPreferences.getBoolean(KEY_IS_LOGGED, false);
    }
}
