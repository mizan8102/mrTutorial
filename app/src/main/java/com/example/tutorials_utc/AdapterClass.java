package com.example.tutorials_utc;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewHolder> {
    Context context;
    List<Info_data> list;


    public AdapterClass(Context context, List<Info_data> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.recyclertest,parent,false);

        final ViewHolder viewHolder = new ViewHolder(view) ;
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,Tutorial_viewActivity.class);
                intent.putExtra("header",list.get(viewHolder.getAdapterPosition()).getHeader());
                intent.putExtra("des",list.get(viewHolder.getAdapterPosition()).getDes());
                intent.putExtra("code",list.get(viewHolder.getAdapterPosition()).getCode());
                intent.putExtra("pic",list.get(viewHolder.getAdapterPosition()).getDpic());
                context.startActivity(intent);
            }
        });




        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       holder.tv.setText(list.get(position).getHeader());
        Picasso.get().load(list.get(position).getHpic()).into(holder.hpic);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        ImageView hpic;
        LinearLayout view_container;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view_container = itemView.findViewById(R.id.container);
            tv=itemView.findViewById(R.id.songTitle);

            hpic=itemView.findViewById(R.id.txthpic);
        }
    }
}

