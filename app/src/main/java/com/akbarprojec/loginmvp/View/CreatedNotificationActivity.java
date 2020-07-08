package com.akbarprojec.loginmvp.View;

import androidx.appcompat.app.AppCompatActivity;
import es.dmoral.toasty.Toasty;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.akbarprojec.loginmvp.Model.Notifikasi;
import com.akbarprojec.loginmvp.Presenter.NotifikasiPresenter;
import com.akbarprojec.loginmvp.R;
import com.akbarprojec.loginmvp.View.AIview.ICreaatedNotifiksaiView;
import com.google.android.material.textfield.TextInputLayout;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CreatedNotificationActivity extends AppCompatActivity implements ICreaatedNotifiksaiView {
    TextInputLayout tanggalTogel, jamTogel;
    EditText edDesc, edStatus, edMesin, edTanggal, edJam, edPlant, edPelapor, edCatatan;
    Button simpanNotifikasi;
    String IDUSER;

    final NotifikasiPresenter presenter = new NotifikasiPresenter(this);
    final Calendar curentDate = Calendar.getInstance();

    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    private SimpleDateFormat simpleDateFormat;
    private SimpleDateFormat simpelTimeFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_created_notification);

        tanggalTogel = findViewById(R.id.tfTanggal);
        jamTogel = findViewById(R.id.tfJam);

        edDesc = findViewById(R.id.edDesc);
        edStatus = findViewById(R.id.edStatus);
        edMesin = findViewById(R.id.edMesin);
        edTanggal = findViewById(R.id.edTanggal);
        edJam = findViewById(R.id.edJam);
        edPlant = findViewById(R.id.edPlant);
        edPelapor = findViewById(R.id.edPelapor);
        edCatatan = findViewById(R.id.edCatatan);

        simpanNotifikasi = findViewById(R.id.btSimpan);

        Bundle bundle = getIntent().getExtras();
        IDUSER = bundle.getString("ID");

        //menentukaan format taanggal dan jam
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        simpelTimeFormat = new SimpleDateFormat("hh:mm", Locale.US);

        //listener button
        tanggalTogel.setEndIconOnClickListener(selecDate);
        jamTogel.setEndIconOnClickListener(selectJam);
        simpanNotifikasi.setOnClickListener(simpanListener);

        //mengatu default tanggal dan jam saat activity mincul
        edTanggal.setText(simpleDateFormat.format(curentDate.getTime()));
        edJam.setText(simpelTimeFormat.format(curentDate.getTime()));

    }


    private void showDateDialog() {
        //menampilkan dialog datePicker
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                Calendar selectedDate = Calendar.getInstance();
                selectedDate.set(year, month, dayOfMonth);
                edTanggal.setText(simpleDateFormat.format(selectedDate.getTime()));
            }

        }, curentDate.get(Calendar.YEAR), curentDate.get(Calendar.MONTH), curentDate.get(Calendar.DAY_OF_MONTH));
        //mengatur maximal dan minimal tanggal pada date picker
        //https://www.it-swarm.dev/id/android/cara-mengatur-tanggal-datepicker-minimum-ke-tanggal-saat-ini/1070412880/
        DatePicker dp = datePickerDialog.getDatePicker();
        dp.setMaxDate(System.currentTimeMillis());
        //datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
        datePickerDialog.show();
    }

    private void selectedTime() {
        //menampilkan dialog timePicker
        timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minuts) {
                edJam.setText(hour + ":" + minuts);
            }
        }, curentDate.get(Calendar.HOUR_OF_DAY), curentDate.get(Calendar.MINUTE), true);
        timePickerDialog.show();
    }

    private Button.OnClickListener simpanListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Notifikasi n = new Notifikasi();
            n.setDesc(edDesc.getText().toString());
            n.setStatus(edStatus.getText().toString());
            n.setMesin(edMesin.getText().toString());
            n.setTanggal(edTanggal.getText().toString());
            n.setJam(edJam.getText().toString());
            n.setPlant(edPlant.getText().toString());
            n.setPelapor(edPelapor.getText().toString());
            n.setCatatan(edCatatan.getText().toString());
            n.setCreated(IDUSER);
            n.setCreatedDate(simpleDateFormat.format(curentDate.getTime()));
            presenter.cretedNotifikasi(n);
        }
    };

    private TextInputLayout.OnClickListener selecDate = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            showDateDialog();
        }
    };

    private TextInputLayout.OnClickListener selectJam = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            selectedTime();
        }
    };

    @Override
    public void onCreatedError(String pesan) {
        Toasty.error(this, pesan, Toasty.LENGTH_SHORT).show();
    }

    @Override
    public void onCreatedSucses(String pesan) {
        Toasty.success(this, pesan, Toasty.LENGTH_SHORT).show();
        finish();
    }
}
