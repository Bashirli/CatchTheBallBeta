package com.bashirli.catchtheballbeta;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.bashirli.catchtheballbeta.databinding.ActivityOyunBinding;

import java.util.Random;

public class oyun extends AppCompatActivity {
private ActivityOyunBinding binding;

    String oyuncu = null;
    TextView saniye;
    TextView xal;
    TextView rekord;
    int xal_hesab = 0;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView[] imageArray;
    int tiklanma = 0;
    Runnable runnable;
    Handler handler;
    SharedPreferences sharedPreferences;
long longg;


@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOyunBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Singleton singleton=Singleton.getSingleton();
        data selectedData=singleton.getData_level();

        if(selectedData.level_sec.equals("Asan")){
            longg=900;
        }else if(selectedData.level_sec.equals("Orta")){
          longg=650;
        }else if(selectedData.level_sec.equals("Çətin")){
longg=500;
        }else if(selectedData.level_sec.equals("Çox çətin")){
longg=300;
        }



    Intent intent=getIntent();
    oyuncu=intent.getStringExtra("oyuncu");


    imageView1=binding.imageView1;
    imageView2=binding.imageView2;
    imageView3=binding.imageView3;
    imageView4=binding.imageView4;
    imageView5=binding.imageView5;
    imageView6=binding.imageView6;
    imageView7=binding.imageView7;
    imageView8=binding.imageView8;
    imageView9=binding.imageView9;
    saniye=binding.textView;
    xal=binding.textView3;
    rekord=binding.textView2;
    imageArray=new ImageView[]{imageView1,imageView9,imageView8,imageView7,imageView2,imageView4,imageView5,imageView6,imageView3};
sharedPreferences=this.getSharedPreferences("com.bashirli.catchtheballbeta", Context.MODE_PRIVATE);
    rekord.setText("Ən yüksək xal : "+sharedPreferences.getInt("rekord",0));
sekil_gizlet();



new CountDownTimer(15000,1000){


    @Override
    public void onTick(long l) {
        saniye.setText("Saniye : "+l/1000);
    }

    @Override
    public void onFinish() {
        if(xal_hesab>sharedPreferences.getInt("rekord",0)){
            sharedPreferences.edit().putInt("rekord",xal_hesab).apply();
        rekord.setText("Ən yüksək xal : "+sharedPreferences.getInt("rekord",0));
        }
handler.removeCallbacks(runnable);

        AlertDialog.Builder alert=new AlertDialog.Builder(oyun.this);
        alert.setTitle("Restart");
        alert.setMessage(oyuncu+" oyuna yeniden baslayaq?");
        alert.setCancelable(false);
        alert.setPositiveButton("Bəli", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent1=getIntent();
                finish();
                startActivity(intent);

            }
        });
        alert.setNegativeButton("Xeyr", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(oyun.this, "Oyun bitdi!", Toast.LENGTH_SHORT).show();

            }
        });
    alert.show();

    }
}.start();




}

    public void score_art(View view){
if(tiklanma==0){
    for(ImageView image: imageArray){
        if(image.getVisibility()==View.INVISIBLE&&image.getId()==view.getId()){
            xal_hesab++;
            xal.setText("Xal : " + xal_hesab);
                    tiklanma=1;
                    return;
        }
    }
}

    }



public void sekil_gizlet(){
handler=new Handler();
runnable=new Runnable() {
    @Override
    public void run() {
for(ImageView imageView : imageArray){
imageView.setVisibility(View.INVISIBLE);
        }
        Random random=new Random();
tiklanma=0;
int rand=random.nextInt(9);
imageArray[rand].setVisibility(View.VISIBLE);
// SURET SECILIR::

handler.postDelayed(this,longg);


    }
};
handler.post(runnable);

}




}