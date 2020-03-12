package com.example.appclass_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.Telephony;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int count;
    private TextView countTv;
    private int num_radom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity","Hola Mundo");
        countTv= findViewById(R.id.textView);

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

    }

    public void aleatorynumber (View view){

        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        count = random.nextInt(100);

        countTv.setText(Integer.toString(count));
    }
}
