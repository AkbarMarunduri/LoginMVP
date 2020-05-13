package com.akbarprojec.loginmvp.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import es.dmoral.toasty.Toasty;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.akbarprojec.loginmvp.R;
import com.akbarprojec.loginmvp.View.AllfragmrntView.fragmentMenu;
import com.akbarprojec.loginmvp.View.AllfragmrntView.fragmentNotifikasi;
import com.akbarprojec.loginmvp.View.AllfragmrntView.fragmentOrder;
import com.akbarprojec.loginmvp.View.AllfragmrntView.fragmentProfile;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bnv;
    Fragment fragment;
    String user, level;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //menerima data yang dikirim dari login
        bnv = findViewById(R.id.bottomNavigationView);
        bnv.setOnNavigationItemSelectedListener(listener);

        //mengambil nilai dari halaman login
        Bundle bundle = getIntent().getExtras();
        user = bundle.getString("user");
        level = bundle.getString("level");

        //sekarang bagaimana mengirim data ke fraagment
        loadFragment(new fragmentProfile(), "PROFILE");

    }

    //memuat default fragment kedalam container fragment / frame layout
    private boolean loadFragment(Fragment fragment, String TAG) {
        if (fragment != null) {
            //mengirim data ke Activity profile jika nilai TAG=PROFILE
            if(TAG=="PROFILE"){
                Bundle data = new Bundle();
                data.putString(fragmentProfile.KEY_USER,user);
                data.putString(fragmentProfile.KEY_LEVEL,level);
                fragment = new fragmentProfile();
                fragment.setArguments(data);
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.containerFragment, fragment).commit();
        }
        return true;
    }

    //menampilkan fragmen sesuai perintah bottom navigator view
    private BottomNavigationView.OnNavigationItemSelectedListener listener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    String TAG = "";
                    switch (item.getItemId()) {
                        case R.id.mainmenu:
                            fragment = new fragmentMenu();
                            TAG = "MENU";
                            break;
                        case R.id.notification:
                            fragment = new fragmentNotifikasi();
                            TAG = "NOTIFIKASI";
                            break;
                        case R.id.order:
                            fragment = new fragmentOrder();
                            TAG = "ORDER";
                            break;
                        case R.id.profile:
                            fragment = new fragmentProfile();
                            TAG = "PROFILE";
                            break;
                    }
                    return loadFragment(fragment, TAG);
                }
            };


}
