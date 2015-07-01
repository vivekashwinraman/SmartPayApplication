package modelObjects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by vraman on 7/1/15.
 */
public class SettingsObject implements Parcelable, Comparable<SettingsObject> {

    private String settingName;
    private String status;

    public SettingsObject() {

    }

    public SettingsObject(String settingName, String status) {
        this.settingName = settingName;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSettingName() {
        return settingName;
    }

    public void setSettingName(String settingName) {
        this.settingName = settingName;
    }


    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // TODO Auto-generated method stub

    }

    @Override
    public int compareTo(SettingsObject compareSettingsObject) {
        //ascending order
        return this.getSettingName().compareToIgnoreCase(((SettingsObject) compareSettingsObject).getSettingName());
    }
}
