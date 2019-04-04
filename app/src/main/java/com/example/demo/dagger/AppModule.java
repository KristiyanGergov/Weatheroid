package com.example.demo.dagger;

import android.app.Application;
import android.content.Context;

import com.example.demo.network.LocationAPI;
import com.example.demo.network.WeatherAPI;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
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
        return new Retrofit.Builder()
                .baseUrl(WeatherAPI.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeatherAPI.class);
    }


    @Provides
    @Singleton
    public LocationAPI providesCountriesAPI() {
        return new Retrofit.Builder()
                .baseUrl(LocationAPI.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(LocationAPI.class);
    }


}
