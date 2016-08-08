package com.ufpb.eduardo.roteiro1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {
    private EditText mNome,mSobrenome,mUsuario,mSenha,mConfSenha;
    private Button mOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        mNome = (EditText)findViewById(R.id.nome);
        mSobrenome = (EditText)findViewById(R.id.sobrenome);
        mUsuario = (EditText)findViewById(R.id.usuario);
        mSenha = (EditText)findViewById(R.id.senha);
        mConfSenha = (EditText)findViewById(R.id.confsenha);
        mOk = (Button)findViewById(R.id.btnok);


        mOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastrar();
            }
        });
    }
    public void cadastrar(){
        String nome,sobrenome,usuario,senha,confsenha;
        nome = mNome.getText().toString();
        sobrenome = mSobrenome.getText().toString();
        usuario = mUsuario.getText().toString();
        senha = mSenha.getText().toString();
        confsenha = mConfSenha.getText().toString();

        if(!nome.isEmpty() && !sobrenome.isEmpty() && !usuario.isEmpty() && !senha.isEmpty() && confsenha.equals(senha)){
            Intent intent = new Intent(this,MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("usuario", usuario);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        else{
            View focus;
            if(TextUtils.isEmpty(nome)){
                mNome.setError("Campo vazio!");
                focus = mNome;
                focus.requestFocus();
            }
            if(TextUtils.isEmpty(sobrenome)){
                mSobrenome.setError("Campo vazio!");
                focus = mSobrenome;
                focus.requestFocus();
            }
            if(TextUtils.isEmpty(usuario)){
                mUsuario.setError("Campo vazio!");
                focus = mUsuario;
                focus.requestFocus();
            }
            if(TextUtils.isEmpty(senha)){
                mSenha.setError("Campo vazio!");
                focus = mSenha;
                focus.requestFocus();
            }
            if(!TextUtils.equals(confsenha,senha)){
                mConfSenha.setError("senha inválida!");
                focus = mConfSenha;
                focus.requestFocus();
            }
        }
    }
}
