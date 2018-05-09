package com.example.alan.leolam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActividadMinian extends AppCompatActivity {
    Button btnMenu, btnLista, btnUbicacion,btnCrearMinian;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_minian);

        btnMenu = (Button)findViewById(R.id.BotonMapa);
        btnLista = (Button)findViewById(R.id.BotonListaMinián);
        btnUbicacion = (Button)findViewById(R.id.BotonUbicación);
        btnCrearMinian = (Button)findViewById(R.id.CrearMinian);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getApplicationContext(),ActividadMapa.class);
                startActivity(intent);
            }
        });
        btnUbicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getApplicationContext(),ActividadMapaMiUbicacion.class);
                startActivity(intent);
            }
        });
        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getApplicationContext(),ActividadListaMinian.class);
                startActivity(intent);
            }
        });
        btnCrearMinian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getApplicationContext(),ActividadCrearMinian.class);
                startActivity(intent);
            }
        });
    }

}
