package com.aula.geral

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteHelper(context:Context) : SQLiteOpenHelper(context, DATABASE_NAME, null,  DATABASE_VERSION) {
    override fun onCreate(p0: SQLiteDatabase?) {
        val ctabelalogin = ("CREATE TABLE LOGIN ( "
                +"CODLOGIN TEXT PRIMARY KEY, USERNAME TEXT, PASSWORD TEXT)"
                )

        p0?.execSQL(ctabelalogin)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE IF EXISTS LOGIN")
        onCreate(p0)
    }

    fun insereuser(log: Login): Long
    {
        val db = this.writableDatabase
        val values = ContentValues()

        values.put("CODLOGIN", log.codlogin)
        values.put("USERNAME", log.username)
        values.put("PASSWORD", log.password)

        val status = db.insert("LOGIN", null, values)
        return status
    }

    companion object
    {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "login.db"
        private const val CODLOGIN = "CODLOGIN"
        private const val USERNAME = "USERNAME"
        private const val PASSWORD = "PASSWORD"
    }



    fun UpdateUser(log: Login) : Int {
        val db = this.writableDatabase

        val contentvalues = ContentValues()

        contentvalues.put("CODMATRICULA", log.codlogin)
        contentvalues.put("NOME", log.username)
        contentvalues.put("TURMA", log.password)

        val success = db.update("LOGIN", contentvalues, "CODLOGIN="+log.codlogin, null)

        db.close()
        return success
    }

    fun autentica(username : String, password: String) : Boolean
    {

        val credenciais = arrayOf(username, password)
        var autenticado : Boolean = false




        val loginlist : ArrayList<Login> = ArrayList()
        val query = "SELECT * FROM LOGIN WHERE USERNAME = ? AND PASSWORD = ?"
        val db = this.readableDatabase

        val cursor : Cursor?


        cursor = db.rawQuery(query,credenciais)

        if(cursor.count > 0) {
            autenticado = true
        }

        return autenticado

    }

}