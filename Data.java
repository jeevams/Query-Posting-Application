package com.example.programmingknowledge.madapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Data
  extends SQLiteOpenHelper
{
  public static final String COL_1 = "ID";
  public static final String COL_2 = "PASSWORD";
  public static final String COL_3 = "SEATNO";
  public static final String DATABASE_NAME = "Student1.db";
  public static final String TABLE_NAME = "student_table";
  
  public Data(Context paramContext)
  {
    super(paramContext, "Student1.db", null, 1);
  }
  
  public boolean checkemail(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    Cursor cursor=localSQLiteDatabase.rawQuery("Select * from student_table where ID=?", new String[] { paramString });
    if(cursor.getCount()>0)
        retrun false;
    else
       return true;  
  }
  
  public boolean checkmaila(String paramString1, String paramString2)
  {
   SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
   Cursor cursor=localSQLiteDatabase.rawQuery("Select * from student_table where ID=? and PASSWORD=?", new String[] { paramString1, paramString2 });
    if(cursor.getCount()>0)
        retrun true;
    else
       return false; 
  }
  
  public boolean checkseat(String paramString)
  {
     SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
     Cursor cursor=localSQLiteDatabase.rawQuery("Select * from student_table where SEATNO=? ", new String[] { paramString });
     if(cursor.getCount()>0)
        retrun true;
      else
       return false; 
  }
  
  public int deletData(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    int result =localSQLiteDatabase.delete("student_table", "SEATNO = ?", new String[] { paramString });
    
    return result;
  }
  
  public boolean insertData(String paramString1, String paramString2, String paramString3)
  {
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("ID", paramString1);
    localContentValues.put("PASSWORD", paramString2);
    localContentValues.put("SEATNO", paramString3);
    long result=localSQLiteDatabase.insert("student_table", null, localContentValues);
    if(result==-1)
        return false;
     else
      return true;
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("create table student_table (ID TEXT PRIMARY KEY ,PASSWORD TEXT,SEATNO TEXT)");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS student_table");
    onCreate(paramSQLiteDatabase);
  }
} 



