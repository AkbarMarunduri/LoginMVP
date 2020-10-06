package com.akbarprojec.loginmvp.View.AllfragmrntView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.akbarprojec.loginmvp.Adaptor.NotifikasiAdaptor;
import com.akbarprojec.loginmvp.Model.Notifikasi;
import com.akbarprojec.loginmvp.Model.User;
import com.akbarprojec.loginmvp.Presenter.NotifikasiPresenter;
import com.akbarprojec.loginmvp.R;
import com.akbarprojec.loginmvp.View.AIview.INotifikasiView;
import com.akbarprojec.loginmvp.View.CreatedNotificationActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import es.dmoral.toasty.Toasty;

public class fragmentNotifikasi extends Fragment implements INotifikasiView {
    public static String KEY_USER="user";
    User user;

    FloatingActionButton bt_crtNotif;
    RecyclerView recyclerView;
    NotifikasiAdaptor adaptor;
    Context context;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notifikasi_view, container, false);
        NotifikasiPresenter presenter = new NotifikasiPresenter(this);
        presenter.listDataNotifikasi();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv_notifikasi);
        bt_crtNotif = view.findViewById(R.id.btCreateNotifikasi);
        bt_crtNotif.setOnClickListener(listener);

        user= (User) getArguments().get(KEY_USER);
    }

    @Override
    public void notifikasiList(List<Notifikasi> notifikasiListData) {
        //mengirim data ke adaptor untuk ditampilkan
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adaptor = new NotifikasiAdaptor(notifikasiListData, context);
        recyclerView.setAdapter(adaptor);
    }

    private Button.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getContext(), CreatedNotificationActivity.class);
            intent.putExtra("ID", KEY_USER);
            startActivity(intent);
        }
    };


}
