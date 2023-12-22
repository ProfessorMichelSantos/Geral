package com.aula.geral

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

private lateinit var sqLitehelper: SQLiteHelper
private lateinit var txtuser: EditText
private lateinit var txtpassword: EditText
private lateinit var botao: Button
private lateinit var botaocadastro: Button



class Efetuarlogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_efetuarlogin)

        sqLitehelper = SQLiteHelper(this)

        txtuser = findViewById(R.id.username)
        txtpassword = findViewById(R.id.password)
        botao = findViewById(R.id.botaologin)
        botaocadastro = findViewById(R.id.botao2)


        botao.setOnClickListener {
            sqLitehelper = SQLiteHelper(this)

            if (sqLitehelper.autentica(txtuser.text.toString(), txtpassword.text.toString()))
            {
                val intent = Intent(this, MainActivity::class.java)

                startActivity(intent)

             }
        }

        botaocadastro.setOnClickListener{
            adicionarlogin()
        }

    }

    private fun adicionarlogin() {
        txtuser = findViewById(R.id.username)
        txtpassword = findViewById(R.id.password)

        var username = txtuser.text.toString()
        var passworduser = txtpassword.text.toString()


        val log = Login(username = username, password = passworduser)

        val status = sqLitehelper.insereuser(log)

        if (status > -1) {
            Toast.makeText(this, "Adicionado com sucesso", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Não Salvo", Toast.LENGTH_SHORT).show()
        }
    }
}