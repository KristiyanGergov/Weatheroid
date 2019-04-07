package com.kristiyan.weatheroid.dagger;

import android.app.Application;
import android.content.Context;

import com.kristiyan.weatheroid.network.LocationAPI;
import com.kristiyan.weatheroid.network.WeatherAPI;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@Module(includes = RoomModule.class)
public class AppModule {

    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    public Context providesAppContext() {
        return application;
    }

    @Provides
    @Singleton
    public WeatherAPI providesWeatherAPI() {
        return providesAPI(WeatherAPI.URL, WeatherAPI.class);
    }

    @Provides
    @Singleton
    public LocationAPI providesCountriesAPI() {
        return providesAPI(LocationAPI.URL, LocationAPI.class);
    }

    private <T> T providesAPI(String baseUrl, Class<T> c) {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
                .create(c);
    }

}