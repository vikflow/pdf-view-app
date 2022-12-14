package com.example.spsstutorial;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String[] data1, data2;
    int[] image;
    Context context;

    public MyAdapter(Context ct, String[] s1, String[] s2, int[] img) {

        context = ct;
        data1 = s1;
        data2 = s2;
        image = img;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.textView1.setText(data1[position]);
        holder.textView2.setText(data2[position]);
        holder.myImage.setImageResource(image[position]);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AboutActivity.class);
                String name = data1[position].trim();
                intent.putExtra("PName", name);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return image.length;
    }

    public class MyViewHolder  extends RecyclerView.ViewHolder {

        TextView textView1, textView2;
        ImageView myImage;
        ConstraintLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.textView2);
            textView2 = itemView.findViewById(R.id.textView);
            myImage = itemView.findViewById(R.id.imageView2);
            mainLayout = itemView.findViewById(R.id.mainLayout1);
        }
    }
}
