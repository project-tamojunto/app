package com.ambev.tamojunto.webservice;
import com.ambev.beerpoint.model.Network;
import com.ambev.beerpoint.model.Networking;
import com.ambev.beerpoint.model.Person;
import com.ambev.beerpoint.utils.Constants;
import com.google.gson.JsonElement;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by matheuscatossi on 01/07/17.
 */

public interface APIInterface {

    @POST(Constants.SET_NETWORK)
    Call<Response> setNetworking(@Body Network network);

    @GET(Constants.GET_NETWORKING)
    Call<Networking> getNetworking(@Query("id") String id);

    @POST(Constants.SET_USER)
    Call<com.ambev.beerpoint.model.Response> setUser(@Header("Content-Type") String content_type, @Body JsonElement person);

    @POST(Constants.CONNECT)
    Call<com.ambev.beerpoint.model.Response> connect(@Header("Content-Type") String content_type, @Body JsonElement network);

    @GET(Constants.ROOMS)
    Call<List<Person>> getRooms(@Query("code") String code);





}