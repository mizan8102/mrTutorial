package com.example.tutorials_utc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

public class jobAdapter extends RecyclerView.Adapter<jobAdapter.jAdapter> {
    Context context;
    List<Jobinfo> list;

    public jobAdapter(Context context, List<Jobinfo> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public jAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.joblayout,parent,false);
        return new jAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull jAdapter holder, int position) {

        holder.head.setText(list.get(position).getHeader());
        holder.jdes.setText(list.get(position).getDes());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class jAdapter extends RecyclerView.ViewHolder {

        TextView head,jdes;
        public jAdapter(@NonNull View itemView) {
            super(itemView);
            head=(TextView)itemView.findViewById(R.id.jheader);
            jdes=itemView.findViewById(R.id.jdes);
        }
    }
}
