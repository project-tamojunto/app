package com.ambev.tamojunto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.ambev.tamojunto.adapter.DataCustomAdapter;
import com.ambev.tamojunto.model.Data;
import com.ambev.tamojunto.model.ListaAgenda;
import com.ambev.tamojunto.model.Service;
import com.ambev.tamojunto.webservice.APIClient;
import com.ambev.tamojunto.webservice.APIInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InfoServiceActivity extends AppCompatActivity {

    private String id;
    private RecyclerView recyclerViewData;
    private ArrayList<Data> doctorList;
    private DataCustomAdapter dataCustomAdapter;

    private TextView nome, preco, descricao, servicos_adicionais, categoria;

    private Call<Service> callService;
    private APIInterface apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_service);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent myIntent = getIntent();
        id = myIntent.getStringExtra("id");

        nome = (TextView) findViewById(R.id.nome);
        preco = (TextView) findViewById(R.id.preco);
        descricao = (TextView) findViewById(R.id.descricao);
        servicos_adicionais = (TextView) findViewById(R.id.servicos_adicionais);
        categoria = (TextView) findViewById(R.id.categoria);

        nome.setText("Rapel Legalzao");
        preco.setText("R$1.000,00");
        descricao.setText("Rapel supimpa dos brothers");
        servicos_adicionais.setText("Gravacao");
        categoria.setText("Rapel");

        recyclerViewData = findViewById(R.id.recycler_view_data);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 3);
        recyclerViewData.setLayoutManager(mLayoutManager);

        apiService = APIClient.getService().create(APIInterface.class);
        callService = apiService.getServicoById( "" + id);

        callService.enqueue(new Callback<Service>() {
            @Override
            public void onResponse(Call<Service> call, Response<Service> response) {

                Service service = response.body();

                List<ListaAgenda> l = new ArrayList<ListaAgenda>();

                for (ListaAgenda list : service.getListaAgenda()) {
                    l.add(new ListaAgenda(list.getId(),list.getData(), list.getHorarioIni(), list.getHorarioFim(), list.getQtdVagas(), list.getQtdOcupadas()));
                }

                dataCustomAdapter = new DataCustomAdapter(getBaseContext(), l);

                recyclerViewData.setAdapter(dataCustomAdapter);
            }

            @Override
            public void onFailure(Call<Service> call, Throwable t) {
                Log.e("Networking", t.toString());

                }
            }

        );





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
