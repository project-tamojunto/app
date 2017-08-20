package com.ambev.tamojunto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PaymentActivity extends AppCompatActivity {

    private String id;
    private TextView preco, instrutor;
    private Button pagar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent myIntent = getIntent();
        id = myIntent.getStringExtra("id");

        preco = findViewById(R.id.preco);
        preco.setText("R$1.000,00");

        instrutor = findViewById(R.id.instrutor);
        instrutor.setText("Matheus Catossi");

        pagar = (Button) findViewById(R.id.pagar);

        pagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PaymentActivity.this, MySchedulesActivity.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}
