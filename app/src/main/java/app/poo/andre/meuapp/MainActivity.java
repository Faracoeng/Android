package app.poo.andre.meuapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mContador = 0;
    private TextView mTextViewContador;
    private TextView mShowCount;
    private static final String CONTADOR_PREFS = "contadorSharedPrefs";
    private SharedPreferences mSharedPrefs;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
          super.onSaveInstanceState(outState);// salvando o valor que eta no TextView
          outState.putInt("count", Integer.parseInt(String.valueOf(mShowCount.getText())));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //parte alterada ultima aula 27/11 --------------------------------
        mSharedPrefs = getSharedPreferences(CONTADOR_PREFS,MODE_PRIVATE);
        //pegar do disco o valor persistente no passado

        mContador =mSharedPrefs.getInt("CONTADOR", 0);
        this.mTextViewContador = findViewById(R.id.TvContador);
        this.mTextViewContador.setText(mContador);
        //----------------------------------------------------------------
        this.mTextViewContador = findViewById(R.id.TvContador);// R.id é padrão para identificar o botão assiciado
        mShowCount = findViewById(R.id.showTitle);
        if (savedInstanceState != null) {
            int count = savedInstanceState.getInt("count");
            if (mShowCount != null) {
                mShowCount.setText(count);

            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor prefsEditor = mSharedPrefs.edit();
        prefsEditor.putInt("Contador",mContador);
        prefsEditor.apply();
    }

    public void incrementarContador(View view) {
        mContador++;
        mTextViewContador.setText(Integer.toString(mContador));

        Toast toast = Toast.makeText(this, "incrementou", Toast.LENGTH_LONG);
        //ou R.string.texto_saudacao
        toast.show();

    }

    public void exibirMensagem(View view){

        Intent intent = new Intent(this, SegundaActivity.class);
        Bundle extras = new Bundle();
        extras.putInt("contador", mContador);
        intent.putExtras(extras);
        //startActivity(intent);
        startActivityForResult(intent,20);//pode ser qualquer inteiro
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 20){

            if(resultCode == RESULT_OK){
                //COLOCAR CONTADOR EM ZERO
                mTextViewContador.setText("0");
            }else if(resultCode == RESULT_CANCELED){
                //IMPRIMIR NO LOG QUE FOI CANCELADO

            }
        }
    }
}

