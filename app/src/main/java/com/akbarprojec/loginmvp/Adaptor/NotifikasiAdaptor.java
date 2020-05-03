package com.akbarprojec.loginmvp.Adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.akbarprojec.loginmvp.Model.Notif;
import com.akbarprojec.loginmvp.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NotifikasiAdaptor extends RecyclerView.Adapter<NotifikasiAdaptor.MyNotifikasi> {

    List<Notif> notifList;
    Context context;

    public NotifikasiAdaptor(List<Notif> notifList, Context context) {
        this.notifList = notifList;
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
        Notif notif = notifList.get(position);
        String nomor,desc,mesin,status;
        nomor=notif.getNomor().toString();
        desc=notif.getDesc().toString();
        mesin=notif.getMesin().toString();
        status=notif.getStatus().toString();

        holder.tvnomor.setText(nomor);
        holder.tvdesc.setText(desc);
        holder.tvmesin.setText(mesin);
        holder.tvstatus.setText(status);
    }

    @Override
    public int getItemCount() {
        return notifList.size();
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

    }
}
