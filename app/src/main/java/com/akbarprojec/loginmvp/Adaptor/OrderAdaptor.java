package com.akbarprojec.loginmvp.Adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.akbarprojec.loginmvp.Model.Order;
import com.akbarprojec.loginmvp.R;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.List;
import java.util.zip.Inflater;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OrderAdaptor extends RecyclerView.Adapter<OrderAdaptor.MyAdaptor> {
    List<Order> orderList;
    Context context;

    public OrderAdaptor(List<Order> orderList, Context context) {
        this.orderList = orderList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdaptor onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_card, parent, false);
        MyAdaptor myAdaptor = new MyAdaptor(view);
        return myAdaptor;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdaptor holder, int position) {
        Order order = orderList.get(position);
        holder.nomor.setText(order.getNoOrder().toString());
        holder.desc.setText(order.getDescOrder().toString());
        holder.status.setText(order.getStsOrder().toString());
        holder.created.setText(order.getCreatedBy().toString());
        holder.release.setText(order.getReleaseBy().toString());

    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }


    public class MyAdaptor extends RecyclerView.ViewHolder {
        TextView nomor, desc, status, created, release;

        public MyAdaptor(@NonNull View itemView) {
            super(itemView);
            nomor = itemView.findViewById(R.id.tv_noorder);
            desc = itemView.findViewById(R.id.tv_descOrder);
            status = itemView.findViewById(R.id.tv_stsOrder);
            created = itemView.findViewById(R.id.tv_created);
            release = itemView.findViewById(R.id.tv_release);
        }
    }
}
