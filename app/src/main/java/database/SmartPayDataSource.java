package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import databaseObjects.SmartPinDataObject;

/**
 * Created by vraman on 7/19/15.
 */
public class SmartPayDataSource {
    // Database fields
    private SQLiteDatabase database;
    private SmartPayDatabaseHelper dbHelper;
    private String[] allColumns = {SmartPayDatabaseHelper.COLUMN_ID,
            SmartPayDatabaseHelper.COLUMN_USEREMAIL, SmartPayDatabaseHelper.COLUMN_SMARTPIN};

    public SmartPayDataSource(Context context) {
        dbHelper = new SmartPayDatabaseHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public SmartPinDataObject createSmartPin(String userEmail, int smartPin) {
        ContentValues values = new ContentValues();
        values.put(SmartPayDatabaseHelper.COLUMN_USEREMAIL, userEmail);
        values.put(SmartPayDatabaseHelper.COLUMN_SMARTPIN, smartPin);
        long insertId = database.insert(SmartPayDatabaseHelper.TABLE_SMART_PIN, null,
                values);
        Cursor cursor = database.query(SmartPayDatabaseHelper.TABLE_SMART_PIN,
                allColumns, SmartPayDatabaseHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        SmartPinDataObject smartPinDataObject = cursorToSmartPinDataObject(cursor);
        cursor.close();
        return smartPinDataObject;
    }

    public SmartPinDataObject getSmartPinDataObjectById(int id) {
        Cursor cursor = database.rawQuery("select * from  " + SmartPayDatabaseHelper.TABLE_SMART_PIN + " where id=" + id + "", null);
        return cursorToSmartPinDataObject(cursor);
    }

    public boolean updateSmartPinDataObject(SmartPinDataObject smartPinDataObject) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SmartPayDatabaseHelper.COLUMN_USEREMAIL, smartPinDataObject.getUserEmail());
        contentValues.put(SmartPayDatabaseHelper.COLUMN_SMARTPIN, smartPinDataObject.getSmartPin());
        database.update(SmartPayDatabaseHelper.TABLE_SMART_PIN, contentValues, "id = ? ", new String[]{Long.toString(smartPinDataObject.getId())});
        return true;
    }

    public void deleteSmartPin(SmartPinDataObject smartPinDataObject) {
        long id = smartPinDataObject.getId();
        System.out.println("Comment deleted with id: " + id);
        database.delete(SmartPayDatabaseHelper.TABLE_SMART_PIN, SmartPayDatabaseHelper.COLUMN_ID
                + " = " + id, null);
    }


    private SmartPinDataObject cursorToSmartPinDataObject(Cursor cursor) {
        SmartPinDataObject smartPinDataObject = new SmartPinDataObject();
        smartPinDataObject.setId(cursor.getLong(0));
        smartPinDataObject.setUserEmail(cursor.getString(1));
        smartPinDataObject.setSmartPin(cursor.getInt(2));
        return smartPinDataObject;
    }
}
