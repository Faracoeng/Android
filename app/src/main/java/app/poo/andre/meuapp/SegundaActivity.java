package app.poo.andre.meuapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
}
