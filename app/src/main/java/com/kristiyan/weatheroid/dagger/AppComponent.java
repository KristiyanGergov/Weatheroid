package com.kristiyan.weatheroid.dagger;


import android.content.Context;

import com.kristiyan.weatheroid.MainApplication;
import com.kristiyan.weatheroid.MainFragment;
import com.kristiyan.weatheroid.viewmodel.LocationViewModel;
import com.kristiyan.weatheroid.viewmodel.WeatherViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = AppModule.class)
@Singleton
public abstract class AppComponent {

    public static AppComponent from(Context context) {
        return ((MainApplication) context.getApplicationContext()).getAppComponent();
    }

    public abstract void inject(MainFragment mainFragment);

    public abstract void inject(WeatherViewModel weatherViewModel);

    public abstract void inject(LocationViewModel locationViewModel);

    public abstract void inject(MainApplication mainApplication);

}
