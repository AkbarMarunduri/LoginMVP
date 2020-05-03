package com.akbarprojec.loginmvp.View;

import androidx.appcompat.app.AppCompatActivity;
import es.dmoral.toasty.Toasty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.akbarprojec.loginmvp.Presenter.LoginPresenter;
import com.akbarprojec.loginmvp.R;
import com.akbarprojec.loginmvp.View.AIview.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {
EditText edtMail,edtPassw;
Button btnLoggin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtMail = findViewById(R.id.edt_email);
        edtPassw = findViewById(R.id.edt_password);
        btnLoggin = findViewById(R.id.btn_login);

        final LoginPresenter loginPresenter=new LoginPresenter(this);

        btnLoggin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=edtMail.getText().toString();
                String pass=edtPassw.getText().toString();
                loginPresenter.onLogin(email,pass);
            }
        });
    }

    @Override
    public void onLoginError(String pesan) {
        Toasty.error(this,pesan,Toasty.LENGTH_SHORT).show();

    }

    @Override
    public void onLoginSucses(String pesan) {
        Toasty.success(this,pesan,Toasty.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this, IndextActivity.class));
    }
}
