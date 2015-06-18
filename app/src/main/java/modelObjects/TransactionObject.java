package modelObjects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by vraman on 6/2/15.
 */
public class TransactionObject implements Parcelable, Comparable<TransactionObject> {

    private String transactionName;
    private String transactionAmount;
    private String accountName;
    private String transactionDate;

    public TransactionObject(){

    }
    public TransactionObject(String transactionName, String transactionAmount, String accountName, String transactionDate){
        this.transactionName = transactionName;
        this.transactionAmount = transactionAmount;
        this.accountName = accountName;
        this.transactionDate = transactionDate;

    }
    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
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
    public int compareTo(TransactionObject compareTransactionObject) {
        //ascending order
        return this.getTransactionName().compareToIgnoreCase(((TransactionObject) compareTransactionObject).getTransactionName());
    }
}
