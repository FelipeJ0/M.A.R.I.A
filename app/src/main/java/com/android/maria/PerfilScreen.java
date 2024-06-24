package com.android.maria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class PerfilScreen extends AppCompatActivity {
    private TextView nomecamp, emailcamp;
    private Button deslogButton;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String UsuarioID;


    // <------------------------------------------------------------------------------------------------------------------------------------------------------------------->


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.perfil_screen);
        IniciarComponentes();

        deslogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseAuth.getInstance().signOut();
                Tlog();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    // <------------------------------------------------------------------------------------------------------------------------------------------------------------------->


    @Override
    protected void onStart() {
        super.onStart();

        UsuarioID = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference documentReference = db.collection("Usuário").document(UsuarioID);
        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                if (documentSnapshot != null) {
                    String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
                    nomecamp.setText(documentSnapshot.getString("nome"));
                    emailcamp.setText(email);
                }

            }
        });
    }

    private void IniciarComponentes() {
        nomecamp = findViewById(R.id.nomecamp);
        emailcamp = findViewById(R.id.emailcamp);
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

    public void TF(View view) {

        //criando objeto intent para abrir tela de login
        Intent it_Tf = new Intent(this, TelaListaTarefas.class);
        //Iniciar tela de login
        startActivity(it_Tf);
    }

    public void Tlog() {

        //criando objeto intent para abrir tela de login
        Intent it_Tlog = new Intent(this, Log_tela.class);
        //Iniciar tela de login
        startActivity(it_Tlog);

    }
}