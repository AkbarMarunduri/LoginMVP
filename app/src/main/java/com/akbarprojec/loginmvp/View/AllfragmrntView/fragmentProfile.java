package com.akbarprojec.loginmvp.View.AllfragmrntView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.akbarprojec.loginmvp.Model.Notifikasi;
import com.akbarprojec.loginmvp.Model.Order;
import com.akbarprojec.loginmvp.Model.User;
import com.akbarprojec.loginmvp.Presenter.NotifikasiPresenter;
import com.akbarprojec.loginmvp.Presenter.OrderPresenter;
import com.akbarprojec.loginmvp.R;
import com.akbarprojec.loginmvp.View.AIview.INotifikasiView;
import com.akbarprojec.loginmvp.View.AIview.IOrderView;
import com.akbarprojec.loginmvp.databinding.FragmentNotifikasiViewBinding;
import com.akbarprojec.loginmvp.databinding.FragmentProfileViewBinding;

import java.util.List;
import java.util.zip.Inflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

public class fragmentProfile extends Fragment implements INotifikasiView, IOrderView {
    public static String KEY_USER = "user";
    FragmentProfileViewBinding binding;
    User user;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile_view, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        userid = view.findViewById(R.id.tv_user);
//        counNotif = view.findViewById(R.id.tv_countNotif);
//        countOrder = view.findViewById(R.id.tv_countOrder);
//        countResv = view.findViewById(R.id.tv_countReservation);

        NotifikasiPresenter presenter = new NotifikasiPresenter(this);
        OrderPresenter presenter1 = new OrderPresenter(this);
        presenter.listDataNotifikasi();
        presenter1.listDataOrder();

        //mengambil argument yang dikirim dari ActivityMain
        user = (User) getArguments().get(KEY_USER);
        binding.tvUser.setText(user.getUser() + " || " + user.getLevel());

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }


    @Override
    public void notifikasiList(List<Notifikasi> notifikasiListData) {
        binding.tvCountNotif.setText("" + notifikasiListData.size());
    }

    @Override
    public void listOrder(List<Order> orderList) {
        binding.tvCountOrder.setText("" + orderList.size());
    }
}
