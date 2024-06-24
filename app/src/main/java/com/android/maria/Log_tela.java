package com.android.maria;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Log_tela extends AppCompatActivity {
    private EditText EmailInBlock, Senhablock;
    private Button LogButton;
    String[] mensagens = {"Por favor, preencha todos os campos", "Login efetuado com sucesso !"};


    // <------------------------------------------------------------------------------------------------------------------------------------------------------------------->


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.log_tela);

        IniciarComponentes();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        // <------------------------------------------------------------------------------------------------------------------------------------------------------------------->


        LogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = EmailInBlock.getText().toString();
                String senha = Senhablock.getText().toString();

                if (email.isEmpty() || senha.isEmpty()) {
                    Snackbar snackbar = Snackbar.make(view, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();

                }else {
                    AutenticarUsuario(view);
                }
            }
        });
    }


    // <------------------------------------------------------------------------------------------------------------------------------------------------------------------->


    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser usuarioAtual = FirebaseAuth.getInstance().getCurrentUser();

        if (usuarioAtual != null) {
            Tlprincipal2();
        }
    }

    private void AutenticarUsuario(View view) {
        String email = EmailInBlock.getText().toString();
        String senha = Senhablock.getText().toString();

        //Método criado para autenticar usuários via email e senha
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    PS();
                    Snackbar snackbar = Snackbar.make(view, mensagens[1], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                } else {
                    String erro;

                    try {
                        throw task.getException();
                    } catch (Exception e) {
                        erro = "Erro ao logar usuário";
                    }
                    Snackbar snackbar = Snackbar.make(view, erro, Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }
            }
        });
    }


    // <------------------------------------------------------------------------------------------------------------------------------------------------------------------->


    private void IniciarComponentes() {
        EmailInBlock = findViewById(R.id.EmailInblock);
        Senhablock = findViewById(R.id.Senhablock);
        LogButton = findViewById(R.id.LogButton);
    }


    // <------------------------------------------------------------------------------------------------------------------------------------------------------------------->


    public void Cad(View v) {

        //criando objeto intent para abrir tela de cadastro
        Intent it_CadTela = new Intent(this, Cad_Tela.class);
        //Iniciar tela de login
        startActivity(it_CadTela);
    }

    public void Tlprincipal(View view) {

        //criando objeto intent para abrir tela de login
        Intent it_Tlprincipal = new Intent(this, Tela_Principal.class);
        //Iniciar tela de login
        startActivity(it_Tlprincipal);
    }

    public void PS() {

        //criando objeto intent para abrir tela de perfil
        Intent it_TlPerfil = new Intent(this, PerfilScreen.class);
        //Iniciar tela de login
        startActivity(it_TlPerfil);
    }

    public void Tlprincipal2() {

        //criando objeto intent para abrir tela principal
        Intent it_Tlprincipal = new Intent(this, Tela_Principal.class);
        //Iniciar tela principal
        startActivity(it_Tlprincipal);

    }
}