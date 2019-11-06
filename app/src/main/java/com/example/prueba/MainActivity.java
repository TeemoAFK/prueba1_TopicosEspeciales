package com.example.prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private EditText et1,et2;
    private String usu,contra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.usuario);
        et2=(EditText)findViewById(R.id.contraseña);
    }


    public void cerrarAPP(View view){
        finish();
    }

    public void login(View view){
        File file = new File("Usuario.txt");

        FileReader fileR = null;
        BufferedReader file2 = null;

        try {
            fileR = new FileReader(file);
            file2 = new BufferedReader(fileR);


        } catch (FileNotFoundException e) {
            System.out.println("No hay usuario registrado");
        }

        try {
            while(file2.readLine() != null)
            {
                String lines = file2.readLine();
                String usu=lines;
                String contra=lines;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(et1.equals(usu)&&et2.equals(contra)){
            System.out.println("BIENVENIDO");
            Intent i = new Intent(this, ingreso_agenda.class);
            startActivity(i);}
    }

    public void registro(View view){
        Intent i = new Intent(this, Registro.class);
        startActivity(i);
    }


}
