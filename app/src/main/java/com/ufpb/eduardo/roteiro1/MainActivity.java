package com.ufpb.eduardo.roteiro1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mBemVindo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBemVindo = (TextView)findViewById(R.id.bemvindo);

        Bundle bundle = getIntent().getExtras();
        String usuario = bundle.getString("usuario");
        mBemVindo.setText("Seja bem vindo!"+ usuario);

    }
}
