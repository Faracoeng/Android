package app.poo.andre.meuapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import javax.xml.transform.Result;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
       // Intent messageIntent = new Intent(this, SegundaActivity.class);
        Bundle extras = getIntent().getExtras();
        int contador = extras.getInt("contador");
        //colocar no textView



    }
    public void clicouNoOK(View view){
        Intent intent = new Intent();

        Bundle extras = new Bundle();
        extras.putString("botão","ok");
        intent.putExtras(extras);

        setResult(RESULT_OK,intent);

        finish();


    }
}
