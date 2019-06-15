package com.example.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    Context context;
    private ArrayList<Transaksi> dataList;

    public UserAdapter(ArrayList<Transaksi> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int i) {
        holder.txtGateIn.setText(dataList.get(i).getGateIn());
        holder.txtGateOut.setText(dataList.get(i).getGateOut());
        holder.txtDate.setText(dataList.get(i).getDateIn());
        holder.txtTarif.setText("Rp " + dataList.get(i).getTarif());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }


    public class UserViewHolder extends RecyclerView.ViewHolder{
        private TextView txtGateIn,txtGateOut, txtDate, txtTarif;

        public UserViewHolder(View itemView) {
            super(itemView);
            txtGateIn= (TextView) itemView.findViewById(R.id.gateIn);
            txtGateOut = (TextView) itemView.findViewById(R.id.gateOut);
            txtDate = (TextView) itemView.findViewById(R.id.date);
            txtTarif= (TextView) itemView.findViewById(R.id.tarif);
        }
    }
}
