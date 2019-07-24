package com.example.android.crimedetail;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CrimeAdapter extends RecyclerView.Adapter<CrimeAdapter.CrimeViewHolder> {
    @Override
    public CrimeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.crime_detail, parent, false);
        return new CrimeViewHolder(view);
    }
    @Override
    public void onBindViewHolder(CrimeViewHolder holder, int position) {
        // TODO: Populate adapter with movies
    }

    @Override
    public int getItemCount() {
        return 50;
    }

    class CrimeViewHolder extends RecyclerView.ViewHolder {
        public CrimeViewHolder(View itemView) {
            super(itemView);
        }
    }
}
