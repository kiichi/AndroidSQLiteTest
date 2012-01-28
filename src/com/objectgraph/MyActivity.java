package com.objectgraph;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MyActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);



        SQLiteDatabase db = openOrCreateDatabase("mydb",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS mydata (first_name,last_name,age)");
        db.execSQL("INSERT INTO mydata (first_name,last_name,age) VALUES('Jon','Doe',20)");
        db.execSQL("INSERT INTO mydata (first_name,last_name,age) VALUES('Mary','Ann',15)");
        db.execSQL("INSERT INTO mydata (first_name,last_name,age) VALUES('Ken','Smith',43)");

        Cursor cursor = db.rawQuery("SELECT * FROM mydata ORDER BY age",null);
        
        if (cursor.moveToFirst()){
            do {
               Log.v("mylog", cursor.getString(0) + "," + cursor.getString(1) + "," + cursor.getString(2));
            }
            while(cursor.moveToNext());
        }
        cursor.close();
        db.close();


    }
}
