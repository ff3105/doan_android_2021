package com.example.doan_android_2021.data.remote;

import com.example.doan_android_2021.data.remote.services.BrandService;
import com.example.doan_android_2021.data.remote.services.CartService;
import com.example.doan_android_2021.data.remote.services.CategoryService;
import com.example.doan_android_2021.data.remote.services.OrderService;
import com.example.doan_android_2021.data.remote.services.ProductService;
import com.example.doan_android_2021.data.remote.services.UserService;
import com.example.doan_android_2021.utlis.RetrofitClient;

public class ApiClient {
    public static final String BASE_URL = "http://192.168.1.6:8000/api/";
    public static final String DOMAIN = "http://192.168.1.6:8000/";

    public static ProductService getProductService() {
        return RetrofitClient.getRetrofit(BASE_URL).create(ProductService.class);
    }

    public static BrandService getBrandService() {
        return RetrofitClient.getRetrofit(BASE_URL).create(BrandService.class);
    }

    public static CategoryService getCategoryService() {
        return RetrofitClient.getRetrofit(BASE_URL).create(CategoryService.class);
    }

    public static UserService getUserService() {
        return RetrofitClient.getRetrofit(BASE_URL).create(UserService.class);
    }

    public static CartService getCartService() {
        return RetrofitClient.getRetrofit(BASE_URL).create(CartService.class);
    }

    public static OrderService getOrderService() {
        return RetrofitClient.getRetrofit(BASE_URL).create(OrderService.class);
    }
}
