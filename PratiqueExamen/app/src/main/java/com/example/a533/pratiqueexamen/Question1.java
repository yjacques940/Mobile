package com.example.a533.pratiqueexamen;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Question1 extends AppCompatActivity {
    List<JobOfferModel> jobOffers = new ArrayList<>();
    final Context context = this;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createJobOffers();
        setContentView(R.layout.activity_question1);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new JobOfferRecyclerAdapter(jobOffers);
        recyclerView.setAdapter(adapter);
    }

    private void createJobOffers() {
        JobOfferModel firstOffer = new JobOfferModel("Programmeur",
                "Créer des logiciels de gestion client","45 000$");
        JobOfferModel secondOffer = new JobOfferModel("Enseignant",
                "Apprendre aux étudiants","40 000$");
        JobOfferModel thirdOffer = new JobOfferModel("Massothérapeute",
                "Assurer que les clients puissent se reposer lors de leurs visites au spa","45 00$");

    jobOffers.add(firstOffer);
    jobOffers.add(secondOffer);
    jobOffers.add(thirdOffer);
    }
}
