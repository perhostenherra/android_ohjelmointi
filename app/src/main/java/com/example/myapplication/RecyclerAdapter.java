package com.example.myapplication;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private ArrayList<Company> dataSet;
    public static final String TAG ="MyAppMessage";

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView itemPosition;
        TextView textViewName;
        TextView textViewBusinessId;
        TextView textViewRegistrationDate;
        TextView textViewCompanyForm;



        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            this.textViewBusinessId = (TextView) itemView.findViewById(R.id.textViewBusinessId);
            this.textViewRegistrationDate = (TextView) itemView.findViewById(R.id.textViewRegistrationDate);
            this.textViewCompanyForm = (TextView) itemView.findViewById(R.id.textViewCompanyForm);
        }
    }

    public RecyclerAdapter(ArrayList<Company> data) {
        this.dataSet = data;
        Log.e(TAG, String.valueOf(dataSet.size()));
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);


        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {


        TextView textViewName = holder.textViewName;
        TextView textViewBusinessId = holder.textViewBusinessId;
        TextView textViewRegistrationDate= holder.textViewRegistrationDate;
        TextView textViewCompanyForm = holder.textViewCompanyForm;

        textViewName.setText(dataSet.get(listPosition).getName());
        textViewBusinessId.setText(dataSet.get(listPosition).getBusinessId());
        textViewRegistrationDate.setText(dataSet.get(listPosition).getRegistrationDate());
        textViewCompanyForm.setText(dataSet.get(listPosition).getCompanyForm());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View hiddenView = holder.itemView.findViewById(R.id.lytHidden);
                hiddenView.setVisibility( hiddenView.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    //@Override
    //public Filter getFilter() {}


}
    //public class ClickListiner{

    //public click(int index);

//}
