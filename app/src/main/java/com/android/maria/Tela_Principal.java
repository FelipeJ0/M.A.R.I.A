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
}

