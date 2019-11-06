package com.example.prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Registro extends AppCompatActivity {

    EditText et1,et2,et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        et1=(EditText)findViewById(R.id.user_new);
        et2=(EditText)findViewById(R.id.pass_new);
        et3=(EditText)findViewById(R.id.re_pass_new);
    }

    public void cerrar (View view){
        finish();
    }

    public void registro(View view) {
        String clave1=et2.getText().toString();
        String clave2=et3.getText().toString();
        if(clave1.equals(clave2)){
            FileWriter writeusu= null;
            try{
                writeusu = new FileWriter("usuarios.txt",true);
                BufferedWriter bfwriter = new BufferedWriter(writeusu);
                writeusu.write(et1.getText().toString());
                writeusu.write(et2.getText().toString());
                bfwriter.close();
                System.out.println("Usuario registrado");
            }catch(IOException e){
                e.printStackTrace();
            }
        }else{
            System.out.println("No coinciden las claves ingresadas");
        }
    }

}
