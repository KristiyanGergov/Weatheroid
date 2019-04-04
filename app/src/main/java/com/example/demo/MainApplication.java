package com.example.demo;

import android.app.Application;

import com.example.demo.dagger.AppComponent;
import com.example.demo.local.LocationDao;

import javax.inject.Inject;

/**
 * Created by florentchampigny on 18/05/2017.
 */

public class MainApplication extends Application {

    private AppComponent appComponent;

    @Inject
    LocationDao locationDao;

    //    @Override
//    public void onCreate() {
//        super.onCreate();
//
//        Stetho.initializeWithDefaults(this);
//
//        this.appComponent = DaggerAppComponent.builder()
//                .appModule(new AppModule(this))
//                .roomModule(new RoomModule(this))
//                .build();
//
//        appComponent.inject(this);
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                //called first time created
//                locationDao.deleteAll();
//                locationDao.insert(new UserLocal("kevin", "kévin", ""));
//                locationDao.insert(new UserLocal("florent37", "flo", ""));
//            }
//        }).start();
////    }
//
    public AppComponent getAppComponent() {
        return appComponent;
    }

    public MainApplication getApplication() {
        return this;
    }

}