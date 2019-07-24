package com.example.android.sqliteex;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class myAda {
    myDbHelper myHelper;
    public  myAda(Context context) {
        myHelper = new myDbHelper(context);
    }

    public int delete(String data) {
        SQLiteDatabase db = myHelper.getWritableDatabase();
        String[] whereArgs = {data};
        int count = db.delete(myDbHelper.TABLE_NAME,myDbHelper.NAME+"= ?",whereArgs);
        return  count;

    }

    public int updateName(String t1, String t2) {
        SQLiteDatabase db = myHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.NAME,t2);
        String[] whereArgs = {t1};
        int count = db.update(myDbHelper.TABLE_NAME,contentValues,myDbHelper.NAME+"= ?",whereArgs);
        return  count;
    }

    public String getData() {
        SQLiteDatabase db = myHelper.getWritableDatabase();
        String[] columns = {myDbHelper.UID,myDbHelper.NAME,myDbHelper.pass};
        Cursor cursor = db.query(myDbHelper.TABLE_NAME,columns,null,null,null,null,null);
        StringBuffer buffer = new StringBuffer();
        while(cursor.moveToNext()){
            int cid = cursor.getInt(cursor.getColumnIndex(myDbHelper.pass));
            buffer.append(cid+" "+name+" "+pass+"\n");
        }
        return  buffer.toString();
    }

    public long insertData(String t1, String t2) {
        SQLiteDatabase dbb  = myHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.NAME,name);
        contentValues.put(myDbHelper.Pass,pass);
        long id = dbb.insert(myDbHelper.TABLE_NAME,null,contentValues);
        return  id;
    }
    static class myDbHelper extends SQLiteOpenHelper{

    }
}
