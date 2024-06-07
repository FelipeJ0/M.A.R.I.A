package com.android.maria;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class Cad_Tela extends AppCompatActivity {

    private com.google.android.material.textfield.TextInputEditText Nomeblock, Emailblock, Senhablock;
    private Button CadButton;
    //armazena as mensagens de sucesso e erro
    String[] mensagens = {"Por favor, preencha todos os campos", "Cadastro realizado com sucesso !"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.cad_tela);

        //iniciando o método IniciarComponentes
        IniciarComponentes();

        //verificar se os campos estão preenchidos
        CadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nome = Nomeblock.getText().toString();
                String email = Emailblock.getText().toString();
                String senha = Senhablock.getText().toString();

                if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                    Snackbar snackbar = Snackbar.make(view, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();

                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

    }

    //associando os objetos aos seus respectivos ids
    private void IniciarComponentes(){
        Nomeblock = findViewById(R.id.Nomeblock);
        Emailblock = findViewById(R.id.Emailblock);
        Senhablock = findViewById(R.id.Senhablock);
        CadButton = findViewById(R.id.CadButton);
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