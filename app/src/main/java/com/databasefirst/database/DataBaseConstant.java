package com.databasefirst.database;



public class DataBaseConstant {

    private DataBaseConstant()
    {

    }
    //Database Name
    final public static String DATABASE_NAME = "userManager";

    //Table Name
    final public static String TABLE_NAME = "contactDetails";

    //Table Columns Name
    final public static String KEY_NAME = "name";
    final public static String KEY_NUMBER = "number";

    //Creating Table
    final public static String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_NAME + "(" +KEY_NAME +" TEXT," + KEY_NUMBER +" INTEGER)";

    //Deleting Table
    final public static String DELETE_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME;


    //Getting all contacts from Table
    final public static String SELECT_CONTACTS = "SELECT * FROM " + TABLE_NAME;
}
