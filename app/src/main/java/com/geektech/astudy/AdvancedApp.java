package com.geektech.astudy;

import android.app.Application;

import com.geektech.astudy.injection.component.AppComponent;
import com.geektech.astudy.injection.component.DaggerAppComponent;
import com.geektech.astudy.injection.module.AppModule;

import io.realm.Realm;

// Created by askar on 11/6/18.
public class AdvancedApp extends Application {

    private AppComponent appComponent;
    private static AdvancedApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        Realm.init(this);

        initDagger();
    }

    private void initDagger(){
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(instance))
                .build();
    }

    public AppComponent component(){
        return appComponent;
    }
}
