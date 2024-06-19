package com.android.maria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PerfilScreen extends AppCompatActivity {
    private TextView nomecamp, emailcamp;
    private Button deslogButton;


    // <------------------------------------------------------------------------------------------------------------------------------------------------------------------->


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

    private void IniciarComponentes() {
        nomecamp = findViewById(R.id.nomecamp);
        emailcamp = findViewById(R.id.Emailblock);
        deslogButton = findViewById(R.id.deslogButton);
    }


    // <------------------------------------------------------------------------------------------------------------------------------------------------------------------->


    public void Tlprincipal(View v) {

        //criando objeto intent para abrir tela principal
        Intent it_Tlprincipal = new Intent(this, Tela_Principal.class);
        //Iniciar tela principal
        startActivity(it_Tlprincipal);
    }

    public void Cad(View v) {

        //criando objeto intent para abrir tela de cadastro
        Intent it_CadTela = new Intent(this, Cad_Tela.class);
        //Iniciar tela de login
        startActivity(it_CadTela);
    }

    public void CS(View v) {

        //criando objeto intent para abrir tela de créditos
        Intent CScreen = new Intent(this, Tela_Cred.class);
        //Iniciar tela de créditos
        startActivity(CScreen);
    }


}