package com.example.doan_android_2021.screens.dashboard.home;

import android.util.Log;

import com.example.doan_android_2021.data.remote.ApiClient;
import com.example.doan_android_2021.data.remote.services.ProductService;
import com.example.doan_android_2021.models.Product;
import com.example.doan_android_2021.models.ProductDatum;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class HomePresent implements HomeContact.HomePresent {
    private final HomeContact.HomeView homeView;
    private final ProductService productService;
    public Product product;
    public boolean isLoading;

    public HomePresent(HomeContact.HomeView homeView) {
        this.homeView = homeView;
        productService = ApiClient.getProductService();
    }

    void init() {
        isLoading = false;
        getProducts();
    }

    @Override
    public void getProducts() {
        productService.getProducts().enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                homeView.showProgress();
                product = response.body();
                homeView.onLoadProductsSuccess(product.getData());
                homeView.hideProgress();
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadMore() {
        if (product.getMeta().getCurrentPage() > product.getMeta().getLastPage()) {
            return;
        }
        productService.loadMore(product.getMeta().getCurrentPage() + 1).enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                product = response.body();
                homeView.onLoadMore(product);
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {

            }
        });
        isLoading = false;
    }
}
