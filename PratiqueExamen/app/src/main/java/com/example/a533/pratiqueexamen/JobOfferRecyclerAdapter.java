package com.example.a533.pratiqueexamen;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class JobOfferRecyclerAdapter extends RecyclerView.Adapter<JobOfferRecyclerAdapter.MyViewHolder>{
List<JobOfferModel> jobOffers;


    public JobOfferRecyclerAdapter(List<JobOfferModel> jobOffers) {
        this.jobOffers = jobOffers;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Title;
        TextView Description;
        TextView Salary;

        public MyViewHolder(View itemView){
            super(itemView);
            Title = itemView.findViewById(R.id.textView_jobtitle);
            Description = itemView.findViewById(R.id.textView_jobdescription);
            Salary = itemView.findViewById(R.id.textView_salary);
        }
    }
    @NonNull
    @Override
    public JobOfferRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.job_offer_cardview,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        JobOfferModel jobOfferToDisplay = jobOffers.get(position);
        holder.Title.setText(jobOfferToDisplay.JobTitle);
        holder.Description.setText(jobOfferToDisplay.JobDescription);
        holder.Salary.setText(jobOfferToDisplay.Salary);
    }

    @Override
    public int getItemCount() {
        return jobOffers.size();
    }
}
