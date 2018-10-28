package mvpexample.koteswara.com.mvpandroidexample.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mvpexample.koteswara.com.mvpandroidexample.R;
import mvpexample.koteswara.com.mvpandroidexample.model.LoginModel;
import mvpexample.koteswara.com.mvpandroidexample.presenter.LoginPresenter;
import mvpexample.koteswara.com.mvpandroidexample.view.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView {

    EditText username,password;
    Button submit;

    LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=(EditText)findViewById(R.id.et_username);
        password=(EditText)findViewById(R.id.et_password);
        submit=(Button)findViewById(R.id.submit);

        loginPresenter=new LoginModel(this);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  s_username=username.getText().toString().trim();
                String s_password=password.getText().toString().trim();
                loginPresenter.performLogin(s_username,s_password);
            }
        });

    }

    @Override
    public void loginvalidation() {

        Toast.makeText(this,"1",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this,"2",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailure() {
        Toast.makeText(this,"3",Toast.LENGTH_SHORT).show();
    }
}
