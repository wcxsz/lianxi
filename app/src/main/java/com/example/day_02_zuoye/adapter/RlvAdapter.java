package com.example.day_02_zuoye.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.day_02_zuoye.R;
import com.example.day_02_zuoye.bean.DaBean;

import java.util.ArrayList;

public class RlvAdapter extends RecyclerView.Adapter<RlvAdapter.MyHolder> {
    private ArrayList<DaBean.NewslistBean> list;
    private Context context;

    public RlvAdapter(ArrayList<DaBean.NewslistBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(ArrayList<DaBean.NewslistBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_item, viewGroup, false);
        MyHolder myHolder = new MyHolder(inflate);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        Glide.with(context).load(list.get(i).getPicUrl()).into(myHolder.url);
        myHolder.title.setText(list.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private final ImageView url;
        private final TextView title;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            url = itemView.findViewById(R.id.url);
            title = itemView.findViewById(R.id.tv_title);
        }
    }
}
