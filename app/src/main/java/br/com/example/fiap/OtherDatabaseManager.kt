package br.com.example.fiap

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class OtherDatabaseManager(context: Context) : SQLiteOpenHelper(context, "fiap", null, 1) {

    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("CREATE TABLE IF NOT EXISTS projects(\n"+
                "\tid INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\tproject_name TEXT NOT NULL,\n" +
                "\tproject_description TEXT NOT NULL\n" +
                "\t)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

        p0?.execSQL("CREATE TABLE projects(\n" +
                "\tid INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\tproject_name TEXT NOT NULL,\n" +
                "\tproject_description TEXT NOT NULL\n" +
                "\t)")
    }

    fun insereProjeto(project_name: String, project_description: String){
        var db = this.writableDatabase

        var cv = ContentValues()

        cv.put("project_name", project_name)
        cv.put("project_description", project_description)

        db.insert("projects", "id", cv)
    }

    fun listaProjetos(): Cursor? {
        val db = this.readableDatabase

        return db.rawQuery("SELECT * FROM projects", null)
    }
}