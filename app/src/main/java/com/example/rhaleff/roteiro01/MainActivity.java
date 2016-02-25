package com.example.rhaleff.roteiro01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mBemVindoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBemVindoText = (TextView) findViewById(R.id.bemVindoText);
        Bundle cadastro = getIntent().getExtras(); //Pega a itent do Bundle da outra tela...
        String nome = cadastro.getString("nome"); //dados que eu quero usar nesta tela.
        String sobrenome = cadastro.getString("sobrenome");
        mBemVindoText.setText("Bem vindo, "+nome+" "+sobrenome+"! Seu cadastro foi criado com sucesso!");
    }
}
