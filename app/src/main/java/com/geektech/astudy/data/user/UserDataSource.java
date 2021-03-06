package com.geektech.astudy.data.user;

import com.geektech.astudy.model.LoginEntity;
import com.geektech.core.callback.BaseCallback;

// Created by askar on 11/2/18.
public interface UserDataSource {

    void checkLogin(LoginEntity loginData, DSCheckLoginCallback callback);

    LoginEntity getLoginData();

    abstract class DSCheckLoginCallback implements BaseCallback<Boolean>{
        @Override
        public void onFail(String message) {

        }
    }
}
