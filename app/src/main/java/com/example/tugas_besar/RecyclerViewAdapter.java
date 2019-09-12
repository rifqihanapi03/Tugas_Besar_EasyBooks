package com.example.tugas_besar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.PrimitiveIterator;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContxt ;
    private List<Book> mData ;


    public RecyclerViewAdapter(Context mContxt, List<Book> mData) {
        this.mContxt = mContxt;
        this.mData = mData;
    }

    public RecyclerViewAdapter(FragmentLibrary fragmentLibrary, List<Book> lstBook) {

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContxt);
        view = mInflater.inflate(R.layout.cardview_item_book,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.tv_book_title.setText(mData.get(i).getTitle());
        myViewHolder.img_book_thumbnail.setImageResource(mData.get(i).getThumbnail());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_book_title ;
        ImageView img_book_thumbnail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_book_title = (TextView) itemView.findViewById(R.id.book_title);
            img_book_thumbnail = (ImageView) itemView.findViewById(R.id.book_img_id);
        }
    }


}
