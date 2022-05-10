package com.example.salvador_pessoas

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class bancoHelper(var context:Context): SQLiteOpenHelper(context, "pessoa.sqlite", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {

        var sql = "create table pessoa(" +
                  "  id integer primary key autoincrement, " +
                  "  name text, " +
                  "  idade integer)"

        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, anterior: Int, atual: Int) {
        if(atual != anterior){
            db?.execSQL("drop table pessoa")
            this.onCreate(db)
        }
    }

}