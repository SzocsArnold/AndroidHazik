package com.example.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.MyViewHolder> {

   private Context mContext;
   private List<Country> countryList;
   private MyViewHolder holder;

    public MyCustomAdapter(Context mContext, List<Country> countryList) {
        this.mContext = mContext;
        this.countryList = countryList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.recycle_view,null);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int position) {
        Country country = countryList.get(position);

        holder.textViewName.setText(country.getName());
        holder.textViewInfo.setText(country.getInfo());
        holder.imageView.setImageDrawable(mContext.getResources().getDrawable(country.getImage()));



    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
    TextView textViewName,textViewInfo;
    ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = (TextView)itemView.findViewById(R.id.textView1);
            textViewInfo = itemView.findViewById(R.id.textView2);
            imageView = itemView.findViewById(R.id.textView2);

        }
    }
}
