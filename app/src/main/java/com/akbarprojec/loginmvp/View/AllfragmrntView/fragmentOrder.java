package com.akbarprojec.loginmvp.View.AllfragmrntView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akbarprojec.loginmvp.Adaptor.OrderAdaptor;
import com.akbarprojec.loginmvp.Model.Order;
import com.akbarprojec.loginmvp.Model.User;
import com.akbarprojec.loginmvp.Presenter.OrderPresenter;
import com.akbarprojec.loginmvp.R;
import com.akbarprojec.loginmvp.View.AIview.IOrderView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import es.dmoral.toasty.Toasty;

public class fragmentOrder extends Fragment implements IOrderView {
    public static String KEY_USER = "user";
    User user;
    RecyclerView recyclerView;
    OrderAdaptor orderAdaptor;
    Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order_view, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        OrderPresenter presenter = new OrderPresenter(this);
        presenter.listDataOrder();
        recyclerView = view.findViewById(R.id.rv_order);

        user = (User) getArguments().get(KEY_USER);

    }

    @Override
    public void listOrder(List<Order> orderList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        orderAdaptor = new OrderAdaptor(orderList, context);
        recyclerView.setAdapter(orderAdaptor);
    }
}
