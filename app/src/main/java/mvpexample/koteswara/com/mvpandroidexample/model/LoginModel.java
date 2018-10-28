package mvpexample.koteswara.com.mvpandroidexample.model;

import android.text.TextUtils;

import mvpexample.koteswara.com.mvpandroidexample.presenter.LoginPresenter;
import mvpexample.koteswara.com.mvpandroidexample.view.LoginView;

public class LoginModel implements LoginPresenter {
    LoginView mloginView;

    public LoginModel(LoginView loginView) {
        mloginView=loginView;
    }

    @Override
    public void performLogin(String username, String password) {

        if (TextUtils.isEmpty(username)||TextUtils.isEmpty(password)){
            mloginView.loginvalidation();
        }else if(username.equals("admin")&&password.equals("admin")){
            mloginView.loginSuccess();

        }else {
            mloginView.loginFailure();
        }
    }
}
