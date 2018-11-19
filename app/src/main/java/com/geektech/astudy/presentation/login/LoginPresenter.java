package com.geektech.astudy.presentation.login;

import android.util.Log;

import com.geektech.astudy.domain.login.LoginUseCases;
import com.geektech.astudy.model.LoginEntity;

import javax.inject.Inject;

/**
 * Created by askar on 11/19/18
 * with Android Studio
 */
public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View mView;
    private LoginUseCases mLoginUseCases;

    @Inject
    public LoginPresenter(
            LoginContract.View view,
            LoginUseCases loginUseCases
    ){
        this.mView = view;
        this.mLoginUseCases = loginUseCases;
    }

    @Override
    public void onLoginClick(String name, String password) {
        if (mView != null && mLoginUseCases != null) {
            LoginEntity loginEntity = new LoginEntity(name, password, "");
            mLoginUseCases.checkLogin(loginEntity, new LoginUseCases.UCCheckLoginCallback(){
                @Override
                public void onSuccess(Boolean result) {
                    if (result){
                        mView.onLoginSuccess();
                        mView.finishView();
                    } else {
                        mView.onLoginFailure("Name or password is incorrect!");
                    }
                }

                @Override
                public void onFail(String message) {
                    Log.d("ololo", message);
                }
            });
        }
    }
}

