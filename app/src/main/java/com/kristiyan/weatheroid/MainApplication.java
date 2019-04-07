package com.kristiyan.weatheroid;

import android.app.Application;

import com.kristiyan.weatheroid.dagger.AppComponent;
import com.kristiyan.weatheroid.dagger.AppModule;
import com.kristiyan.weatheroid.dagger.DaggerAppComponent;
import com.kristiyan.weatheroid.dagger.RoomModule;
import com.kristiyan.weatheroid.local.LocationDao;
import com.kristiyan.weatheroid.model.location.LocationLocal;
import com.facebook.stetho.Stetho;

import javax.inject.Inject;


public class MainApplication extends Application {

    private AppComponent appComponent;

    @Inject
    LocationDao locationDao;

    @Override
    public void onCreate() {
        super.onCreate();

        Stetho.initializeWithDefaults(this);

        this.appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .roomModule(new RoomModule(this))
                .build();

        appComponent.inject(this);

        new Thread(new Runnable() {
            @Override
            public void run() {
                locationDao.deleteAll();
                locationDao.insert(new LocationLocal("Sofia", "Bulgaria"));
                locationDao.insert(new LocationLocal("Plovdiv", "Bulgaria"));
            }
        }).start();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public MainApplication getApplication() {
        return this;
    }

}