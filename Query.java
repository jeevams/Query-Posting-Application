package com.example.programmingknowledge.madapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Query
  extends SQLiteOpenHelper
{
  public static final String COL_1 = "ID";
  public static final String COL_2 = "QUESTION";
  public static final String DATABASE_NAME = "Query.db";
  public static final String TABLE_NAME = "query_table";
  
  public Query(Context paramContext)
  {
    super(paramContext, "Query.db", null, 1);
  }
  
  
  public int deletData(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    int result =localSQLiteDatabase.delete("query_table", "ID = ?", new String[] { paramString });
    
    return result;
  }
  
  public Cursor getall()
  {
    return getReadableDatabase().rawQuery("select * from query_table", null);
  }
  
  public boolean insertData(String paramString1, String paramString2)
  {
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("ID", paramString1);
    localContentValues.put("QUESTION", paramString2);
    long result=localSQLiteDatabase.insert("query_table", null, localContentValues);
    if(result==-1)
        return false;
     else
      return true
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("create table query_table (ID TEXT PRIMARY KEY,QUESTION TEXT )");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS query_table");
    onCreate(paramSQLiteDatabase);
  }
}



