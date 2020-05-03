package com.akbarprojec.loginmvp.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.akbarprojec.loginmvp.Adaptor.NotifikasiAdaptor;
import com.akbarprojec.loginmvp.Model.Notif;
import com.akbarprojec.loginmvp.Presenter.NotifikasiPresenter;
import com.akbarprojec.loginmvp.R;
import com.akbarprojec.loginmvp.View.AIview.INotifikasiView;

import java.util.List;

public class NotifikasiActivity extends AppCompatActivity implements INotifikasiView {
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    NotifikasiAdaptor adaptor;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifikasi);

        final NotifikasiPresenter presenter = new NotifikasiPresenter(this);
        presenter.listDataNotifikasi();

        recyclerView = findViewById(R.id.rv_notifikasi);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    @Override
    public void notifikasiList(List<Notif> notifListData) {
        adaptor = new NotifikasiAdaptor(notifListData, context);
        recyclerView.setAdapter(adaptor);
    }
}
