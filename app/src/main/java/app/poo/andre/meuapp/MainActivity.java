package app.poo.andre.meuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mContador = 0;
    private TextView mTextViewContador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mTextViewContador = findViewById(R.id.TvContador);

    }

    public void incrementarContador(View view) {
       mContador++;

       mTextViewContador.setText(Integer.toString(mContador));

        Toast toast = Toast.makeText(this,R.string.texto_saudacao,Toast.LENGTH_LONG);
        toast.show();
    }
}
