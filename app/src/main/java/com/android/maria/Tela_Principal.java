package com.android.maria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Tela_Principal extends AppCompatActivity {

    //CalendarView calendarView; //objeto para vizualização do calendário
    //Calendar calendar;

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
        }

    public void TF(View view) {

        //criando objeto intent para abrir tela de login
        Intent it_Tf = new Intent(this, TelaListaTarefas.class);
        //Iniciar tela de login
        startActivity(it_Tf);
    }

    public void PS(View v) {

        //criando objeto intent para abrir tela de perfil
        Intent it_TlPerfil = new Intent(this, PerfilScreen.class);
        //Iniciar tela de login
        startActivity(it_TlPerfil);
    }

        /*calendarView = findViewById(R.id.calendarView);
        calendar = Calendar.getInstance();

        setDate(3, 1, 2024);

        getDate();

        //Adiciona a função de mudança de data conforme a inserida pelo usuário
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
                //Aciona a visualização do calendário pelo que foi definido na mudança de data
        {

            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int day) {
                Toast.makeText(Tela_Principal.this, day + "/" + month + 1 + "/" + year, Toast.LENGTH_SHORT).show();  //o usuario recebe a mensagem do dia selecionado, exibindo o mesmo no topo do calendario"
            }
        });
    }

    public void getDate(){
        long date = calendarView.getDate();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy", Locale.getDefault());
        calendar.setTimeInMillis(date);
        String selected_date = simpleDateFormat.format(calendar.getTime());
        Toast.makeText(this, selected_date, Toast.LENGTH_SHORT).show();
    }

    public void setDate(int day, int month, int year) {
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        long millis = calendar.getTimeInMillis();
        calendarView.setDate(millis);

    }
    */


}

