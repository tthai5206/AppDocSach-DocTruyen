package com.example.appdoctruyen.model.main;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appdoctruyen.R;

public class MainThongTin extends AppCompatActivity {

    TextView txtThongTin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_thong_tin);

        txtThongTin = findViewById(R.id.textviewthongtin);

        String thongtin =
                " Ứng dụng vẫn còn những thiếu sót cần đưược phát triển sau. \n";
        txtThongTin.setText(thongtin);
    }
}