package com.android.maria;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class Tela_Principal extends AppCompatActivity {

    CalendarView calendarView; //objeto para vizualização do calendário
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_principal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        calendarView = findViewById(R.id.calendarView);
        calendar = Calendar.getInstance();

        setDate(1, 1, 2024);


        //Adiciona a função de mudança de data conforme a inserida pelo usuário
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
                //Aciona a visualização do calendário pelo que foi definido na mudança de data
        {

            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int day) {
                Toast.makeText(Tela_Principal.this, day + "/" + month + "/" + year, Toast.LENGTH_SHORT).show();  //o usuario recebe a mensagem do dia selecionado, exibindo o mesmo no topo do calendario"
            }
        });
    }

    public void setDate(int day, int month, int year) {
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        long millis = calendar.getTimeInMillis();
        calendarView.setDate(millis);

    }
}

