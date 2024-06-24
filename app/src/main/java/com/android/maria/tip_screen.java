package com.android.maria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class tip_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tip_screen);
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

    public void Tlprincipal(View v) {

        //criando objeto intent para abrir tela principal
        Intent it_Tlprincipal = new Intent(this, Tela_Principal.class);
        //Iniciar tela principal
        startActivity(it_Tlprincipal);
    }
}