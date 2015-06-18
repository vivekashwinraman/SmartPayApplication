package modelObjects;

import android.os.Parcel;
import android.os.Parcelable;
/**
 * Created by vraman on 5/29/15.
 */
public class AccountObject implements Parcelable, Comparable<AccountObject>{

    private String accountName;
    private String accountType;

    public AccountObject() {

    }

    public AccountObject(String accountName, String accountType) {
        this.accountName = accountName;
        this.accountType = accountType;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
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
    public int compareTo(AccountObject compareAccountObject) {
        //ascending order
        return this.getAccountType().compareToIgnoreCase(((AccountObject) compareAccountObject).getAccountType());
    }
}
