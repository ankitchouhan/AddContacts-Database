package com.databasefirst.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.databasefirst.beans.ContactBean;
import com.databasefirst.beans.UserDetails;

import java.util.ArrayList;
import java.util.List;

public class DBHolder extends SQLiteOpenHelper{


    public DBHolder(Context context) {
        super(context, DataBaseConstant.DATABASE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Log.d("ankit","table");
        db.execSQL(DataBaseConstant.CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop table if existed.
        db.execSQL(DataBaseConstant.DELETE_TABLE);
        onCreate(db);
    }

    public boolean addContact(ContactBean contact)
    {
        SQLiteDatabase db  = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DataBaseConstant.KEY_NAME,contact.getContactName());
        values.put(DataBaseConstant.KEY_NUMBER,contact.getContactNumber());

        //Inserting row
        db.insert(DataBaseConstant.TABLE_NAME,null,values);
        //db.close(); //closing database connection.
        return true;
    }

    public List<ContactBean> getAllContacts()
    {
        List<ContactBean> contactBeanList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(DataBaseConstant.SELECT_CONTACTS,null);
        if (cursor.moveToFirst())
        {
            do{
                ContactBean contactBean = new ContactBean();
                contactBean.setContactName(cursor.getString(0));
                contactBean.setContactNumber(cursor.getString(1));
                contactBeanList.add(contactBean);
            }
            while (cursor.moveToNext());
        }
        return contactBeanList;
    }
  /*  public int getTotalRows()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(DataBaseConstant.SELECT_CONTACTS,null);
        return cursor.getCount();
    }
*/

}
