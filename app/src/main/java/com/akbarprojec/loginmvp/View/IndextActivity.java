package com.akbarprojec.loginmvp.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.akbarprojec.loginmvp.R;

public class IndextActivity extends AppCompatActivity {
Button notifBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indext);

        notifBtn = findViewById(R.id.btNotifikasi);

        notifBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NotifikasiActivity.class);
                startActivity(intent);
            }
        });
    }
}
