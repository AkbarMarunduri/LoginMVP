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
    final static String TAG_PROFILE="PROFILE",TAG_MENU="MENU",TAG_NOTIFIKASI="NOTIFIKASI",TAG_ORDER="ORDER";
    BottomNavigationView bnv;
    Fragment fragment;
    String user, level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnv = findViewById(R.id.bottomNavigationView);
        bnv.setOnNavigationItemSelectedListener(listener);

        //mengambil data yang dikirim dari halaman login
        Bundle bundle = getIntent().getExtras();
        user = bundle.getString("user");
        level = bundle.getString("level");

        //sekarang bagaimana mengirim data ke fraagment
        loadFragment(new fragmentProfile(), TAG_PROFILE);
        bnv.setSelectedItemId(R.id.profile);

    }

    //memuat fragment yang dipilih melalui navigator kedalam container
    private boolean loadFragment(Fragment fragment, String TAG) {
        if (fragment != null) {
            //mengirim data yang ada dalam bundle kirimData melalui arguments ke fragment yang akan di load
            fragment.setArguments(kirimData(TAG));
            // load fragment kedalam container
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
                            TAG = TAG_MENU;
                            break;
                        case R.id.notification:
                            fragment = new fragmentNotifikasi();
                            TAG = TAG_NOTIFIKASI;
                            break;
                        case R.id.order:
                            fragment = new fragmentOrder();
                            TAG = TAG_ORDER;
                            break;
                        case R.id.profile:
                            fragment = new fragmentProfile();
                            TAG = TAG_PROFILE;
                            break;
                    }
                    return loadFragment(fragment, TAG);
                }
            };

    //menentukan data yang akan dikirim ke fragment berdasarkan TAG
    private Bundle kirimData(String TAG) {
        //membuat bundel untuk membungkus data
        Bundle data = new Bundle();
        switch (TAG) {
            case TAG_PROFILE:
                data.putString(fragmentProfile.KEY_USER,user);
                data.putString(fragmentProfile.KEY_LEVEL,level);
                break;
            case TAG_NOTIFIKASI:
                data.putString(fragmentNotifikasi.KEY_USER,user);
                break;
            case TAG_ORDER:
                data.putString(fragmentOrder.KEY_USER,"Bundel data terkirim ke ORDER");
                break;
            case TAG_MENU:
                data.putString(fragmentMenu.KEY_USER,"Bundel data terkirim ke MENU");
                break;
        }
        return data;
    }

}
