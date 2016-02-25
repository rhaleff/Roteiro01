package com.example.rhaleff.roteiro01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {

    private EditText mNome;
    private EditText mSobrenome;
    private EditText mUsuario;
    private EditText mSenha;
    private EditText mConfirmeSenha;
    private Button mBotaoConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        mNome = (EditText) findViewById(R.id.nome);
        mSobrenome = (EditText) findViewById(R.id.sobrenome);
        mUsuario = (EditText) findViewById(R.id.usuario);
        mSenha = (EditText) findViewById(R.id.senha);
        mConfirmeSenha = (EditText) findViewById(R.id.confirmesenha);
        mBotaoConfirmar = (Button) findViewById(R.id.botaoConfirmar);

        mBotaoConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrar();
            }
        });

    }

    private void cadastrar() {
        String nome = this.mNome.getText().toString();
        String sobrenome = this.mSobrenome.getText().toString();
        String usuario = this.mUsuario.getText().toString();
        String senha = this.mSenha.getText().toString();
        String confirmeSenha = this.mConfirmeSenha.getText().toString();

        if(usuario.equalsIgnoreCase("rhaleff") && senha.equalsIgnoreCase(confirmeSenha)){
            Intent i = new Intent(this, MainActivity.class); //itent desta tela para a próxima...
            Bundle b = new Bundle();
            b.putString("nome",nome.toString()); //tipo um add
            b.putString("sobrenome", sobrenome.toString());
            b.putString("usuario", usuario.toString());
            i.putExtras(b);
            startActivity(i);
            finish(); //fecha esta tela.
        }
        else{
            View focus = null;
            if(TextUtils.isEmpty(nome)){
                this.mNome.setError("Campo Vazio");
                focus = this.mNome;
                focus.requestFocus();
            }
            if(TextUtils.isEmpty(sobrenome)){
                this.mSobrenome.setError("Campo Vazio");
                focus = this.mSobrenome;
                focus.requestFocus();
            }

            if(TextUtils.isEmpty(usuario)){
                this.mUsuario.setError("Campo Vazio");
                focus = this.mUsuario;
                focus.requestFocus();
            }

            if(TextUtils.isEmpty(senha)){
                this.mSenha.setError("Campo Vazio");
                focus = this.mSenha;
                focus.requestFocus();
            }
            if(TextUtils.isEmpty(confirmeSenha)){
                this.mConfirmeSenha.setError("Campo Vazio");
                focus = this.mConfirmeSenha;
                focus.requestFocus();
            }

            if(!senha.equalsIgnoreCase(confirmeSenha)){
                this.mSenha.setError("Senhas não compatíveis");
                focus = this.mSenha;
                focus.requestFocus();
            }

            else{
                this.mUsuario.setError("Problema ao se cadastrar");
                focus = this.mUsuario;
                focus.requestFocus();
            }

        }
    }
}
