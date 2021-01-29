package com.example.doan_android_2021.data.remote.services;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BrandService {
    @GET("brand/{id}")
    Call<Void> getBrand(@Path("id") int id);

    @GET("brand")
    Call<BrandResponse> getBrands();
}
