package com.example.barbara.lifecicle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    int hora, min, seg;
    String txtHora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificar("onCreate");

        //Es null solo al iniciar la activity.
        if(savedInstanceState == null){
            Calendar data = Calendar.getInstance();
            hora = data.get(Calendar.HOUR_OF_DAY);
            min = data.get(Calendar.MINUTE);
            seg = data.get(Calendar.SECOND);

            txtHora = "Hora: " + hora + ":" + min + ":" + seg;
        }else{
            //Sino coge los datos guardados con el metodo override "onSaveInstanceState"
            //el string "hora" tiene que ser el mismo que el string de outSate.putString("hora", this.txtHora)
            //this.txtHora es la variable
            this.txtHora = savedInstanceState.getString("hora");
        }

        txt = (TextView)findViewById(R.id.txtHora);
        txt.setText(this.txtHora);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("hora", this.txtHora);
    }

    @Override
    protected void onStop() {
        super.onStop();
        notificar("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        notificar("onDestroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        notificar("onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        notificar("onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        notificar("onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        notificar("onRestart");
    }

    public void notificar (String mensaje){
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
        Log.i("tag", mensaje);
    }
}
