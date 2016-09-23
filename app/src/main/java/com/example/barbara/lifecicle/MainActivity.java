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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificar("onCreate");

        txt = (TextView)findViewById(R.id.txtHora);

        Calendar data = Calendar.getInstance();
        hora = data.get(Calendar.HOUR_OF_DAY);
        min = data.get(Calendar.MINUTE);
        seg = data.get(Calendar.SECOND);

        txt.setText("Hora: " + hora + ":" + min + ":" + seg);

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
