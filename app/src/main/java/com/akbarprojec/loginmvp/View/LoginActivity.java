package com.akbarprojec.loginmvp.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import es.dmoral.toasty.Toasty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.akbarprojec.loginmvp.Model.User;
import com.akbarprojec.loginmvp.Presenter.LoginPresenter;
import com.akbarprojec.loginmvp.R;
import com.akbarprojec.loginmvp.View.AIview.ILoginView;
import com.akbarprojec.loginmvp.databinding.ActivityLoginBinding;

import java.util.List;

public class LoginActivity extends AppCompatActivity implements ILoginView {
    ActivityLoginBinding loginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        final LoginPresenter loginPresenter = new LoginPresenter(this);

        loginBinding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = loginBinding.edtUser.getText().toString();
                String pass = loginBinding.edtPassword.getText().toString();
                loginPresenter.onLogin(email, pass);
            }
        });
    }

    @Override
    public void onLoginError(String pesan) {
        Toasty.error(this, pesan, Toasty.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginSucses(String pesan, List<User> users) {
        User user = users.get(0);
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra("user", user);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}
