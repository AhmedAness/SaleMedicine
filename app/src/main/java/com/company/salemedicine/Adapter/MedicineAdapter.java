package com.company.salemedicine.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.company.salemedicine.R;
import com.company.salemedicine.model.MedicineModel;

import java.util.List;

public class MedicineAdapter extends
        RecyclerView.Adapter<MedicineAdapter.MyViewHolder>{

    private List<MedicineModel> medicineModels;

    /**
     * View holder class
     * */
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView Name;
        public TextView Price;
        public TextView Quantity;

        public MyViewHolder(View view) {
            super(view);
            Name = (TextView) view.findViewById(R.id.Name);
            Price = (TextView) view.findViewById(R.id.Price);
            Quantity = (TextView) view.findViewById(R.id.Quantity);
        }
    }

    public MedicineAdapter(List<MedicineModel> MedicineList) {
        this.medicineModels = MedicineList;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MedicineModel c = medicineModels.get(position);
        holder.Name.setText(c.getName());
        holder.Price.setText(String.valueOf(c.getPrice()));
        holder.Quantity.setText(String.valueOf(c.getQuantaty()));
    }

    @Override
    public int getItemCount() {
        return medicineModels.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.medicin_item,parent, false);
        return new MyViewHolder(v);
    }

}
