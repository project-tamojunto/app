package com.ambev.tamojunto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.ambev.tamojunto.adapter.DataCustomAdapter;
import com.ambev.tamojunto.model.Data;
import com.ambev.tamojunto.model.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InfoServiceActivity extends AppCompatActivity {

    private String id;
    private RecyclerView recyclerViewData;
    private ArrayList<Data> doctorList;
    private DataCustomAdapter dataCustomAdapter;

    private TextView nome, preco, descricao, servicos_adicionais, categoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_service);

        Intent myIntent = getIntent();
        id = myIntent.getStringExtra("id");

//        Toast.makeText(InfoServiceActivity.this, "" + id, Toast.LENGTH_SHORT).show();

        nome = findViewById(R.id.nome);
        preco = findViewById(R.id.preco);
        descricao = findViewById(R.id.descricao);
        servicos_adicionais = findViewById(R.id.servicos_adicionais);
        categoria = findViewById(R.id.categoria);

        nome.setText("Rapel Legalzao");
        preco.setText("R$1.000,00");
        descricao.setText("Rapel supimpa dos brothers");
        servicos_adicionais.setText("Gravacao");
        categoria.setText("Rapel");

        recyclerViewData = findViewById(R.id.recycler_view_data);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 3);
        recyclerViewData.setLayoutManager(mLayoutManager);

        List<Data> l = new ArrayList<Data>();
        l.add(new Data("22/04/17", "18:00", "22:00", 5));
        l.add(new Data("22/04/17", "18:00", "22:00", 5));
        l.add(new Data("22/04/17", "18:00", "22:00", 5));
        l.add(new Data("22/04/17", "18:00", "22:00", 5));
        l.add(new Data("22/04/17", "18:00", "22:00", 5));

        dataCustomAdapter = new DataCustomAdapter(getBaseContext(), l);

        recyclerViewData.setAdapter(dataCustomAdapter);


    }
}
