package com.bashirli.catchtheballbeta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;


import com.bashirli.catchtheballbeta.databinding.ActivityLevels2Binding;

import java.util.ArrayList;
import java.util.logging.Level;

public class Levels extends AppCompatActivity {
private ActivityLevels2Binding binding;
String oyuncu;

ArrayList<data> dataArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLevels2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

dataArray=new ArrayList<>();
data l1=new data("Asan");
        data l2=new data("Orta");
        data l3=new data("Çətin");
        data l4=new data("Çox çətin");
dataArray.add(l1); dataArray.add(l2); dataArray.add(l3); dataArray.add(l4);
        Intent intent=getIntent();
        oyuncu=intent.getStringExtra("oyuncu_data");
binding.recyclerViewOyun.setLayoutManager(new LinearLayoutManager(this));
RecyclerData rd=new RecyclerData(dataArray,oyuncu);
binding.recyclerViewOyun.setAdapter(rd);


    }
}