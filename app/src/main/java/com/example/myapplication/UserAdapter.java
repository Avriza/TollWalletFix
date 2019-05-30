package com.example.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private ArrayList<UserInformation> dataList;

    public UserAdapter(ArrayList<UserInformation> dataList) {
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
        holder.txtNama.setText(dataList.get(i).getName());
        holder.txtEmail.setText(dataList.get(i).getEmail());
        holder.txtPass.setText(dataList.get(i).getPass());
        holder.txtAlat.setText(dataList.get(i).getAlat());
        holder.txtPlat.setText(dataList.get(i).getPlat());
        holder.txtSaldo.setText(dataList.get(i).getSaldo());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }


    public class UserViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNama, txtEmail, txtPass, txtAlat, txtPlat, txtSaldo;

        public UserViewHolder(View itemView) {
            super(itemView);
            txtNama= (TextView) itemView.findViewById(R.id.name_item);
            txtEmail = (TextView) itemView.findViewById(R.id.email_item);
            txtPass = (TextView) itemView.findViewById(R.id.pass_item);
            txtAlat= (TextView) itemView.findViewById(R.id.alat_item);
            txtPlat= (TextView) itemView.findViewById(R.id.plat_item);
            txtSaldo= (TextView) itemView.findViewById(R.id.saldo_item);
        }
    }
}
