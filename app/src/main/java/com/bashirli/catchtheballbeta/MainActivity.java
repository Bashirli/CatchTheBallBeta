package com.bashirli.catchtheballbeta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView textView;
EditText editText;
String oyuncu=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.oyuncu_ad);


    }
public int problem_tapma(String str){
        if(str.length()==0){
            Toast.makeText(MainActivity.this,"Ad boş buraxılıb!",Toast.LENGTH_LONG).show();
            return 0;
        }
        if(str.length()>30){
        Toast.makeText(MainActivity.this,"Ad çox uzundur !\n(Maks 30 simvol)",Toast.LENGTH_LONG).show();
        return 0;
    }
        return 1;
}



    public void oyuna_basla(View view){
if(problem_tapma(editText.getText().toString())==0){
    return;
}
oyuncu=editText.getText().toString();
        Intent intent=new Intent(MainActivity.this,Levels.class);
intent.putExtra("oyuncu_data",oyuncu);
startActivity(intent);

    }

}