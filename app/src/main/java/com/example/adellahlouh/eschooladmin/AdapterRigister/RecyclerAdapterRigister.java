package com.example.adellahlouh.eschooladmin.AdapterRigister;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.adellahlouh.eschooladmin.R;

public class RecyclerAdapterRigister extends RecyclerView.Adapter<RecyclerAdapterRigister.ViewHolder> {


    private String[] titles = {"1" , "2" , "3","4","5","6","7"};





    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {


        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view_rigister , viewGroup , false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        viewHolder.txt_rigister.setText(titles[position]);

    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txt_rigister ;
        public EditText edt_rigister ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_rigister = itemView.findViewById(R.id.txt_rigister);
            edt_rigister = itemView.findViewById(R.id.edt_rigister);



        }
    }




}
