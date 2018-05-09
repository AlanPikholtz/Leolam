package com.example.alan.leolam;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ActividadListaMinian extends AppCompatActivity {

    ListView mListView;
    int[] imagen = {
            R.drawable.sinagoga,
            R.drawable.sinagoga,
            R.drawable.sinagoga
    };

    String[] Nombres = {
            "Centro Hebreo Iona",
            "Dor Jadash",
            "Templo Camargo"
    };
    String[] CantidadMinian = {
            "Cantidad Minian: 5",
            "Cantidad Minian: 8",
            "Cantidad Minian: 3"
    };
    String[] Direcciones = {
            "Acevedo 270",
            "Murillo 665",
            "Camargo 870"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_lista_minian);

        mListView = (ListView)findViewById(R.id.ListaMinián);

        Adaptador adaptador = new Adaptador();
        mListView.setAdapter(adaptador);

    }

    class Adaptador extends BaseAdapter{

        @Override
        public int getCount() {
            return imagen.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View vista = getLayoutInflater().inflate(R.layout.lista_personalisada, null);

            ImageView mImageView = (ImageView)vista.findViewById(R.id.imageView2);
            TextView mTextViewN = (TextView)vista.findViewById(R.id.tvNombre);
            TextView mTextViewC = (TextView)vista.findViewById(R.id.tvCantidadMinian);
            TextView mTextViewD = (TextView)vista.findViewById(R.id.tvDireccion);

            mImageView.setImageResource(imagen[position]);
            mTextViewN.setText(Nombres[position]);
            mTextViewD.setText(Direcciones[position]);
            mTextViewC.setText(CantidadMinian[position]);

            return vista;
        }
    }

}
