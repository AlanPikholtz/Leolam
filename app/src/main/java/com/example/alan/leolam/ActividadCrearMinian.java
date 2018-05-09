package com.example.alan.leolam;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TimeFormatException;
import android.view.View;
import android.webkit.WebView;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.Calendar;

import javax.net.ssl.HttpsURLConnection;

public class ActividadCrearMinian extends AppCompatActivity {
    TextView tv;
    Calendar HorarioActual;
    int hora,minuto;
    String formato;
    private TextView mMostrarFecha;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    TimePickerDialog.OnTimeSetListener mTimeSetListener;
    private static final String CERO = "0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_crear_minian);

        mMostrarFecha = (TextView)findViewById(R.id.tvFecha);
        mMostrarFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal =Calendar.getInstance();
                int año = cal.get(Calendar.YEAR);
                int mes = cal.get(Calendar.MONTH);
                int dia = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        ActividadCrearMinian.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        año,mes,dia);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month=month+1;
                String fecha = dayOfMonth + "/" + month + "/" + year;
                mMostrarFecha.setText(fecha);
            }
        };

        tv = (TextView)findViewById(R.id.tvHorario);

                HorarioActual = Calendar.getInstance();
                hora = HorarioActual.get(Calendar.HOUR_OF_DAY);
                minuto = HorarioActual.get(Calendar.MINUTE);




                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TimePickerDialog timepickerdialog = new TimePickerDialog(ActividadCrearMinian.this, new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                String horaformada =  (hourOfDay < 10)? String.valueOf(CERO + hourOfDay) : String.valueOf(hourOfDay);

                                String minutoformado = (minute < 10)? String.valueOf(CERO + minute):String.valueOf(minute);
                                FormatoDeHora(hourOfDay);
                                tv.setText(horaformada+" : "+minutoformado+" "+formato);
                            }
                        }, hora,minuto,true);
                        timepickerdialog.show();
                    }
                });

            }






public void FormatoDeHora(int hora){
        if (hora == 0){
            hora+=12;
            formato = "AM";
        }else if(hora == 12){
            formato="PM";
        }else if(hora>12){
            hora-=12;
            formato="PM";
        }else{
            formato="AM";
        }
}

}
