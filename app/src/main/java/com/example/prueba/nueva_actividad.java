package com.example.prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class nueva_actividad extends AppCompatActivity {
    private EditText et1,et2;
    private CheckBox check1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_actividad);

        et1=(EditText)findViewById(R.id.fecha);
        et2=(EditText)findViewById(R.id.texto);
    }

    public void grabar(View view) {
        String nomarchivo=et1.getText().toString();
        nomarchivo=nomarchivo.replace('/','-');
        try {
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(
                    nomarchivo, Activity.MODE_PRIVATE));
            archivo.write(et2.getText().toString());
            archivo.flush();
            archivo.close();
        } catch (IOException e) {
        }
        Toast t = Toast.makeText(this, "Los datos han sido guardados",
                Toast.LENGTH_SHORT);
        t.show();
        et1.setText("");
        et2.setText("");
    }

    public void cancelar(View view){
        finish();
    }

    public void cumplido(View view){
        if (check1.equals(true)){
            System.out.println("Actividad Cumplida");
        }else{
         System.out.println("La actividad seleccionada aun no se ha cumplido");
        }

    }
}