package com.bashirli.catchtheballbeta;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bashirli.catchtheballbeta.databinding.RecyclerXmlBinding;

import java.util.ArrayList;

public class RecyclerData extends RecyclerView.Adapter<RecyclerData.RecyclerHold> {
    ArrayList<data> dataArray;
    String oyuncu;


public RecyclerData(ArrayList<data> dataArray,String oyuncu){
    this.dataArray=dataArray;
    this.oyuncu=oyuncu;
}

    @NonNull
    @Override
    public RecyclerHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerXmlBinding recyclerXmlBinding=RecyclerXmlBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new RecyclerHold(recyclerXmlBinding);
    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerHold holder, int position) {
        holder.binding.recyclerText.setText(dataArray.get(position).level_sec);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(holder.itemView.getContext(),oyun.class);
                Singleton singleton=Singleton.getSingleton();
                singleton.setData_level(dataArray.get(position));
                intent.putExtra("oyuncu",oyuncu);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataArray.size();
    }

    public class RecyclerHold extends RecyclerView.ViewHolder{
private RecyclerXmlBinding binding;
        public RecyclerHold(RecyclerXmlBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }

}
