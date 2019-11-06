package com.example.prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ingreso_agenda extends AppCompatActivity {
    private EditText et1,et2;
        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_agenda);
    }

    public void actividadNEW(View view){
        Intent i = new Intent(this,nueva_actividad.class);
        startActivity(i);
    }

    public void recuperar(View view) {
        String nomarchivo=et1.getText().toString();
        nomarchivo=nomarchivo.replace('/','-');
        boolean enco=false;
        String[] archivos = fileList();
        for (int f = 0; f < archivos.length; f++)
            if (nomarchivo.equals(archivos[f]))
                enco= true;
        if (enco==true) {
            try {
                InputStreamReader archivo = new InputStreamReader(
                        openFileInput(nomarchivo));
                BufferedReader br = new BufferedReader(archivo);
                String linea = br.readLine();
                String todo = "";
                while (linea != null) {
                    todo = todo + linea + "\n";
                    linea = br.readLine();
                }
                br.close();
                archivo.close();
                et2.setText(todo);
            } catch (IOException e) {
            }
        } else
        {
            Toast.makeText(this,"No hay datos para esta fecha", Toast.LENGTH_LONG).show();
            et2.setText("");
        }
    }

    public void close(View view){
            finish();
    }
}

