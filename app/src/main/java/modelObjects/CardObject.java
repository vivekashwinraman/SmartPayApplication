package modelObjects;

import android.os.Parcel;
import android.os.Parcelable;
/**
 * Created by vraman on 5/29/15.
 */
public class CardObject implements Parcelable, Comparable<CardObject> {

    private String cardName;
    private String cardType;

    public CardObject() {

    }

    public CardObject(String cardName, String cardType) {
        this.cardName = cardName;
        this.cardType = cardType;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
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
    public int compareTo(CardObject compareCardObject) {
        //ascending order
        return this.getCardType().compareToIgnoreCase(compareCardObject.getCardType());
    }
}
