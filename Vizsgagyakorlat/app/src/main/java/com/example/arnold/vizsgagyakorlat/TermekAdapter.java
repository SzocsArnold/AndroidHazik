package com.example.arnold.vizsgagyakorlat;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TermekAdapter extends RecyclerView.Adapter<TermekAdapter.TermekViewHolder> {

    public TermekAdapter(Context mContext, List<Termek> termekLista) {
        this.mContext = mContext;
        this.termekLista = termekLista;
    }

    private Context mContext;
    private List<Termek> termekLista;

    @NonNull
    @Override
    public TermekViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.recycle_layout,null);
        TermekViewHolder holder = new TermekViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull TermekViewHolder holder, int position) {
        Termek termek = termekLista.get(position);

        holder.textViewDesc.setText(termek.getShortdesc());
        holder.textViewTitle.setText(termek.getTitle());
        holder.textViewRating.setText(String.valueOf(termek.getRating()));
        holder.textViewPrice.setText(String.valueOf(termek.getPrice()));

        holder.imageView.setImageDrawable(mContext.getResources().getDrawable(termek.getImage()));

    }

    @Override
    public int getItemCount() {
        return termekLista.size();
    }

    class TermekViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textViewTitle,textViewDesc, textViewRating,textViewPrice;

        public TermekViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewRating = itemView.findViewById(R.id.textViewRating);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            textViewDesc = itemView.findViewById(R.id.textViewShortDesc);


        }
    }
}
