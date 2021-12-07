package com.ranzan.mojopizzaclone.Location;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {
    @GET("advancedmaps/v1/30072769dcb1994942a02091b4d4b06e/rev_geocode")
    Call<ResponseDTO> getmodels(@Query("lat") double lat,
                                      @Query("lng")double lang);
}
