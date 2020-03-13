package com.example.appclass_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.Telephony;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int count;
    private TextView countTv;
    private Button btnCount;
    private Button btnZero;

    private int num_radom;
    private ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity","Hola Mundo");
        countTv= findViewById(R.id.textView);
        btnCount= findViewById(R.id.btn_count);
        btnZero= findViewById(R.id.btn_Zero);

        if(savedInstanceState != null){
            countTv.setText(savedInstanceState.getString("contador"));
            count = Integer.parseInt(savedInstanceState.getString("contador"));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        outState.putString("contador", (String) countTv.getText());

        super.onSaveInstanceState(outState);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.menssage,Toast.LENGTH_LONG);
        toast.show();
    }

    public void countApp(View view) {
        count++;
        if (countTv != null)
            countTv.setText(Integer.toString(count));

        if (count >=1){
            cambiarColor();
        }
    }

    public void aleatorynumber (View view){

        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        count = random.nextInt(999);

        if (count >=1){
            cambiarColor();
        }

        countTv.setText(Integer.toString(count));
    }

    public void cambiarColor(){
        btnCount.setBackgroundColor(ContextCompat.getColor(getBaseContext(), android.R.color.holo_green_dark));
        btnCount.setTextColor(ContextCompat.getColor(getBaseContext(), android.R.color.white));

        btnZero.setBackgroundColor(ContextCompat.getColor(getBaseContext(), android.R.color.holo_purple));
        btnZero.setTextColor(ContextCompat.getColor(getBaseContext(), android.R.color.white));
    }

    public void reset(View view){
        count = 0;
        countTv.setText(Integer.toString(0));

        btnZero.setBackgroundColor(ContextCompat.getColor(getBaseContext(), android.R.color.darker_gray));
        btnZero.setTextColor(ContextCompat.getColor(getBaseContext(), android.R.color.black));

        btnCount.setBackgroundColor(ContextCompat.getColor(getBaseContext(), R.color.colorPrimary));
        btnCount.setTextColor(ContextCompat.getColor(getBaseContext(), android.R.color.black));
    }
}
