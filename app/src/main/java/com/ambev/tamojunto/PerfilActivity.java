package com.ambev.tamojunto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class PerfilActivity extends AppCompatActivity {

    private SeekBar seekBar1;
    private TextView textView1;

    private SeekBar seekBar2;
    private TextView textView2;

    private SeekBar seekBar3;
    private TextView textView3;

    private Button entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initializeVariables();

        entrar = (Button) findViewById(R.id.entrar);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(PerfilActivity.this, MainActivity.class);
                startActivity(intent);
            }

        });


        textView1.setText("Resultado: " + seekBar1.getProgress() + "/" + seekBar1.getMax());

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView1.setText("Resultado: " + progress + "/" + seekBar.getMax());
            }
        });

        textView2.setText("Resultado: " + seekBar2.getProgress() + "/" + seekBar2.getMax());

        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView2.setText("Resultado: " + progress + "/" + seekBar.getMax());
            }
        });

        textView3.setText("Resultado: " + seekBar3.getProgress() + "/" + seekBar3.getMax());

        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView3.setText("Resultado: " + progress + "/" + seekBar.getMax());
            }
        });
    }

    private void initializeVariables() {
        seekBar1 = (SeekBar) findViewById(R.id.seekBar1);
        textView1 = (TextView) findViewById(R.id.textView1);

        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        textView2 = (TextView) findViewById(R.id.textView2);

        seekBar3 = (SeekBar) findViewById(R.id.seekBar3);
        textView3 = (TextView) findViewById(R.id.textView3);
    }
}
