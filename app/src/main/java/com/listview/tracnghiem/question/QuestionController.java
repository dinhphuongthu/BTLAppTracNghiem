package com.listview.tracnghiem.question;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class QuestionController {
    private DBHelper dbHelper;

    public QuestionController(Context context){
      dbHelper = new DBHelper(context);
    }

    //Truy van co so du lieu

    public ArrayList<Question> getQuestion(int num_exam , String subject){
       ArrayList<Question> lstData = new ArrayList<Question>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();//read database
        Cursor cursor = db.rawQuery("SELECT * FROM tblDethi WHERE num_exam = '"+num_exam + "' AND subject= '"+subject+"'",null);
       //duyệt từng hàng trong CSDL gán vào item rồi add vào listData
        cursor.moveToFirst();
        do {
            Question item;
            item = new Question(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getInt(7),cursor.getString(8),cursor.getString(9),"");
            lstData.add(item);
        }while(cursor.moveToNext());
        return lstData;
    }
}
