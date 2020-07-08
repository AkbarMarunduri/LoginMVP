package com.akbarprojec.loginmvp.View.AllfragmrntView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.akbarprojec.loginmvp.Model.Notifikasi;
import com.akbarprojec.loginmvp.Model.Order;
import com.akbarprojec.loginmvp.Presenter.NotifikasiPresenter;
import com.akbarprojec.loginmvp.Presenter.OrderPresenter;
import com.akbarprojec.loginmvp.R;
import com.akbarprojec.loginmvp.View.AIview.INotifikasiView;
import com.akbarprojec.loginmvp.View.AIview.IOrderView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class fragmentProfile extends Fragment implements INotifikasiView, IOrderView {
    public static String KEY_USER = "user";
    public static String KEY_LEVEL = "level";

    TextView userid, level, counNotif, countOrder, countResv;
    String user, lv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_view, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userid = view.findViewById(R.id.tv_user);
        //level = view.findViewById(R.id.tv_level);
        counNotif = view.findViewById(R.id.tv_countNotif);
        countOrder = view.findViewById(R.id.tv_countOrder);
        countResv = view.findViewById(R.id.tv_countReservation);
        NotifikasiPresenter presenter = new NotifikasiPresenter(this);
        OrderPresenter presenter1 = new OrderPresenter(this);
        presenter.listDataNotifikasi();
        presenter1.listDataOrder();
        //mengambil argument yang dikirim dari ActivityMain
        user = getArguments().getString(KEY_USER);
        lv = getArguments().getString(KEY_LEVEL);

        //menampilkan ke TextView
        userid.setText(user+" || "+lv);
        //level.setText(lv);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }


    @Override
    public void notifikasiList(List<Notifikasi> notifikasiListData) {
        counNotif.setText(""+ notifikasiListData.size());
    }

    @Override
    public void listOrder(List<Order> orderList) {
        countOrder.setText(""+orderList.size());
    }
}
