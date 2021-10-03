package com.ranzan.mojopizzaclone.Location;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {
    @GET("advancedmaps/v1/9031b028a3859cfb5e8f1bc628287100/rev_geocode")
    Call<ResponseDTO> getmodels(@Query("lat") double lat,
                                      @Query("lng")double lang);

}
