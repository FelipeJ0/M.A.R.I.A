package com.android.maria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Cad_Tela extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.cad_tela);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    public void Cad(View v){
        //criando objeto intent para abrir tela principal
        //Intent it_telaPrincipal = new Intent(this, Tela_Principal.class);
        //Iniciar activity 2 (Tela Principal)
        //startActivity(it_telaPrincipal);

        //criando objeto intent para abrir tela de cadastro
        Intent it_logTela = new Intent(this, Log_tela.class);
        //Iniciar tela de cadastro
         startActivity(it_logTela);

    }

    public void Tlog(View v) {

        //criando objeto intent para abrir tela de login
        Intent it_Tlog = new Intent(this, Log_tela.class);
        //Iniciar tela de login
        startActivity(it_Tlog);
    }

    public void Tlprincipal(View v) {

        //criando objeto intent para abrir tela principal
        Intent it_Tlprincipal = new Intent(this, Tela_Principal.class);
        //Iniciar tela principal
        startActivity(it_Tlprincipal);
    }


}