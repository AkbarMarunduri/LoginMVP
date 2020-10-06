package com.akbarprojec.loginmvp.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import es.dmoral.toasty.Toasty;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.akbarprojec.loginmvp.Model.User;
import com.akbarprojec.loginmvp.R;
import com.akbarprojec.loginmvp.View.AllfragmrntView.fragmentMenu;
import com.akbarprojec.loginmvp.View.AllfragmrntView.fragmentNotifikasi;
import com.akbarprojec.loginmvp.View.AllfragmrntView.fragmentOrder;
import com.akbarprojec.loginmvp.View.AllfragmrntView.fragmentProfile;
import com.akbarprojec.loginmvp.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    final static String TAG_PROFILE="PROFILE",TAG_MENU="MENU",TAG_NOTIFIKASI="NOTIFIKASI",TAG_ORDER="ORDER";
    ActivityMainBinding mainBinding;
    User user;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        mainBinding.bottomNavigationView.setOnNavigationItemSelectedListener(listener);

        //mengambil data yang dikirim dari halaman login
        user = getIntent().getParcelableExtra("user");

        //sekarang bagaimana mengirim data ke fraagment
        loadFragment(new fragmentProfile(), TAG_PROFILE);
        mainBinding.bottomNavigationView.setSelectedItemId(R.id.profile);

    }

    //memuat fragment yang dipilih melalui navigator kedalam container
    private boolean loadFragment(Fragment fragment, String TAG) {
        if (fragment != null) {
            fragment.setArguments(kirimData(TAG));
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
        Bundle data = new Bundle();
        switch (TAG) {
            case TAG_PROFILE:
                data.putParcelable(fragmentProfile.KEY_USER,user);
                break;
            case TAG_NOTIFIKASI:
                data.putParcelable(fragmentNotifikasi.KEY_USER,user);
                break;
            case TAG_ORDER:
                data.putParcelable(fragmentOrder.KEY_USER,user);
                break;
            case TAG_MENU:
                data.putParcelable(fragmentMenu.KEY_USER,user);
                break;
        }
        return data;
    }

}
