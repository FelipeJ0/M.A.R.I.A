package com.android.maria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PerfilScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.perfil_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void Tlprincipal(View v) {

        //criando objeto intent para abrir tela de login
        Intent it_Tlprincipal = new Intent(this, Tela_Principal.class);
        //Iniciar tela de login
        startActivity(it_Tlprincipal);
    }

    public void Cad(View v) {

        //criando objeto intent para abrir tela de cadastro
        Intent it_CadTela = new Intent(this, Cad_Tela.class);
        //Iniciar tela de login
        startActivity(it_CadTela);
    }


}