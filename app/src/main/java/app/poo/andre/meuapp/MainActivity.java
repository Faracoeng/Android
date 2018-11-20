package app.poo.andre.meuapp;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mContador = 0;
    private TextView mTextViewContador;
    private TextView mShowCount;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
          super.onSaveInstanceState(outState);// salvando o valor que eta no TextView
          outState.putInt("count", Integer.parseInt(String.valueOf(mShowCount.getText())));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mTextViewContador = findViewById(R.id.TvContador);// R.id é padrão para identificar o botão assiciado
        mShowCount = findViewById(R.id.showTitle);
        if (savedInstanceState != null) {
            int count = savedInstanceState.getInt("count");
            if (mShowCount != null) {
                mShowCount.setText(count);

            }
        }
    }


    //@SuppressLint("SetTextI18n")
    public void incrementarContador(View view) {
        mContador++;
        mTextViewContador.setText(Integer.toString(mContador));

        Toast toast = Toast.makeText(this, "incrementou", Toast.LENGTH_LONG);
                                                        //ou R.string.texto_saudacao
        toast.show();

    }

}
