package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by vraman on 7/19/15.
 */
public class SmartPayDatabaseHelper extends SQLiteOpenHelper {

    public static final String TABLE_SMART_PIN = "smartpin";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USEREMAIL = "useremail";
    public static final String COLUMN_SMARTPIN = "securepin";
    private static final String DATABASE_NAME = "smartpay.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_SMART_PIN + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_USEREMAIL
            + " text not null, " + COLUMN_SMARTPIN
            + " integer not null," + ");";

    public SmartPayDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        Log.w(SmartPayDatabaseHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_SMART_PIN);
        onCreate(database);
    }
}
