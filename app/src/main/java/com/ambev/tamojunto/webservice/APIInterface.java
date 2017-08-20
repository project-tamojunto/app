package com.ambev.tamojunto.webservice;


import com.ambev.tamojunto.model.Service;
import com.ambev.tamojunto.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by matheuscatossi on 01/07/17.
 */

public interface APIInterface {


    @GET(Constants.GET_SERVICO_BY_ID)
    Call<Service> getServicoById(@Query("idServico") String idServico);

    @GET(Constants.GET_SERVICOS)
    Call<ArrayList<Service>> getServicos();

}