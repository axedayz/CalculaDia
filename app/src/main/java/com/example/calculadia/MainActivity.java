package com.example.calculadia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private EditText etData1, etData2;
    private Button btnCalcular;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etData1 = findViewById(R.id.etData1);
        etData2 = findViewById(R.id.etData2);
        btnCalcular = findViewById(R.id.btnCalcular);
        tvResultado = findViewById(R.id.tvResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data1 = etData1.getText().toString();
                String data2 = etData2.getText().toString();

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date date1 = sdf.parse(data1);
                    Date date2 = sdf.parse(data2);

                    long diffInMillies = Math.abs(date2.getTime() - date1.getTime());
                    long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

                    tvResultado.setText("Diferença em dias: " + diff);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
