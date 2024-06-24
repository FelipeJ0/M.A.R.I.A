package com.android.maria;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Cad_Tela extends AppCompatActivity {

    private com.google.android.material.textfield.TextInputEditText Nomeblock, Emailblock, Senhablock;
    private Button CadButton;

    //armazena as mensagens de sucesso e erro
    String[] mensagens = {"Por favor, preencha todos os campos", "Cadastro realizado com sucesso !"};
    String usuarioID;


    // <------------------------------------------------------------------------------------------------------------------------------------------------------------------->


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.cad_tela);

        //associar os campos aos seus respectivos ids
        IniciarComponentes();

        //verificar se os campos estão preenchidos
        CadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = Nomeblock.getText().toString();
                String email = Emailblock.getText().toString();
                String senha = Senhablock.getText().toString();

                //mostrar uma mensagem caso algum dos campos não esteja preenchido
                if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }else {
                    //se os campos estiverem preenchidos, o usuário é cadastrado
                    CadastrarUsuarios(v);
                }
            }
        });
    }


    // <------------------------------------------------------------------------------------------------------------------------------------------------------------------->


    //objeto para coletar o que foi digitado nos campos de email e senha
    private void CadastrarUsuarios(View v){
        String email = Emailblock.getText().toString();
        String senha = Senhablock.getText().toString();
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    //caso tudo ocorra sem problemas, o usuário é cadastrado e será exibido uma mensagem
                    SalvarDadosUsuario();
                    Tlog(v);
                    Snackbar snackbar = Snackbar.make(v, mensagens[1], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }
                else {
                    String erro;

                    //criando as excessões no momento do cadastro
                    try {
                        throw task.getException();
                    } catch (FirebaseAuthWeakPasswordException e) {
                        erro = "Digite uma senha com no mínimo 6 caracteres";
                    } catch (FirebaseAuthUserCollisionException e) {
                        erro = "Esta conta já foi cadastrada";
                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        erro = "Email inválido";
                    } catch (Exception e) {
                        erro = "Erro ao cadastrar usuário";
                    }
                    Snackbar snackbar = Snackbar.make(v, erro, Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }
            }
        });
    }


    // <------------------------------------------------------------------------------------------------------------------------------------------------------------------->


    //objeto que coleta o nome do usuário
    private void SalvarDadosUsuario(){
        String nome = Nomeblock.getText().toString();

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String,Object> usuarios = new HashMap<>();
        usuarios.put("nome", nome);

        //Obter o ID do usuário atual
        usuarioID = FirebaseAuth.getInstance().getCurrentUser().getUid();

        //cria uma collection que irá armazenar o nome do usuário cadastrado
        DocumentReference documentReference = db.collection("Usuário").document(usuarioID);
        documentReference.set(usuarios).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {

                //se tudo der certo, uma mensagem de sucesso será exibida no console do Android Studio
                Log.d("db", "Sucesso ao salvar os dados");

            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        //se algum erro ocorrer, uma mensagem de erro e exibida no console do Android Studio
                        Log.d("db_error", "Erro ao salvar os dados" + e.toString());
                    }
                });
    }


    // <------------------------------------------------------------------------------------------------------------------------------------------------------------------->


    //associando os objetos aos seus respectivos ids
    private void IniciarComponentes(){
        Nomeblock = findViewById(R.id.Nomeblock);
        Emailblock = findViewById(R.id.Emailblock);
        Senhablock = findViewById(R.id.Senhablock);
        CadButton = findViewById(R.id.CadButton);
    }


    // <------------------------------------------------------------------------------------------------------------------------------------------------------------------->


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

    public void Tlog(View view) {

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

    public void Tlprincipal2() {

        //criando objeto intent para abrir tela principal
        Intent it_Tlprincipal = new Intent(this, Tela_Principal.class);
        //Iniciar tela principal
        startActivity(it_Tlprincipal);

    }

}