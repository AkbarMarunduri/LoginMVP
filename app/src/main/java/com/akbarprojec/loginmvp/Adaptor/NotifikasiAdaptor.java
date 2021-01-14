package com.akbarprojec.loginmvp.Adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.akbarprojec.loginmvp.Model.Notifikasi;
import com.akbarprojec.loginmvp.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NotifikasiAdaptor extends RecyclerView.Adapter<NotifikasiAdaptor.MyNotifikasi> {

    List<Notifikasi> notifikasiList;
    Context context;

    public NotifikasiAdaptor(List<Notifikasi> notifikasiList, Context context) {
        this.notifikasiList = notifikasiList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyNotifikasi onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notifikasi_card, parent, false);
        MyNotifikasi myNotifikasi = new MyNotifikasi(view);
        return myNotifikasi;
    }

    @Override
    public void onBindViewHolder(@NonNull MyNotifikasi holder, int position) {
        holder.getDataNotifikasi(notifikasiList.get(position));
    }

    @Override
    public int getItemCount() {
        return notifikasiList.size();
    }

    public class MyNotifikasi extends RecyclerView.ViewHolder {
        TextView tvnomor,tvdesc,tvmesin,tvstatus;

        public MyNotifikasi(@NonNull View itemView) {
            super(itemView);
            tvnomor = itemView.findViewById(R.id.tv_nomor);
            tvdesc = itemView.findViewById(R.id.tv_desc);
            tvmesin = itemView.findViewById(R.id.tv_mesin);
            tvstatus = itemView.findViewById(R.id.tv_status);
        }

        public void getDataNotifikasi(Notifikasi notifikasi) {
            String nomor,desc,mesin,status;
            nomor= notifikasi.getNomor().toString();
            desc= notifikasi.getDesc().toString();
            mesin= notifikasi.getMesin().toString();
            status= notifikasi.getStatus().toString();

            tvnomor.setText(nomor);
            tvdesc.setText(desc);
            tvmesin.setText(mesin);
            tvstatus.setText(status);
        }

    }
}
