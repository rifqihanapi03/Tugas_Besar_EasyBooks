package com.example.tugas_besar;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentLibrary extends Fragment {

    List<Book> lstBook ;
    View v;

    public FragmentLibrary() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.library_fragment,container,false);
        RecyclerView myrv = (RecyclerView) v.findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,lstBook);
        myrv.setLayoutManager(new GridLayoutManager(getContext(),3));
        myrv.setAdapter(myAdapter);
        return v;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstBook = new ArrayList<>();
        lstBook.add(new Book("Pendidikan Agama Islam1","Categorie Book","Description Book",R.drawable.img_2));
        lstBook.add(new Book("Pendidikan Agama Islam2","Categorie Book","Description Book",R.drawable.img_3));
        lstBook.add(new Book("Pendidikan Agama Islam3","Categorie Book","Description Book",R.drawable.img4));
        lstBook.add(new Book("Pendidikan Agama Islam4","Categorie Book","Description Book",R.drawable.img5));
        lstBook.add(new Book("Pendidikan Agama Islam5","Categorie Book","Description Book",R.drawable.img6));
        lstBook.add(new Book("Pendidikan Agama Islam6","Categorie Book","Description Book",R.drawable.img7));
        lstBook.add(new Book("Pendidikan Agama Islam1","Categorie Book","Description Book",R.drawable.img_2));
        lstBook.add(new Book("Pendidikan Agama Islam2","Categorie Book","Description Book",R.drawable.img_3));
        lstBook.add(new Book("Pendidikan Agama Islam3","Categorie Book","Description Book",R.drawable.img4));
        lstBook.add(new Book("Pendidikan Agama Islam4","Categorie Book","Description Book",R.drawable.img5));
        lstBook.add(new Book("Pendidikan Agama Islam5","Categorie Book","Description Book",R.drawable.img6));
        lstBook.add(new Book("Pendidikan Agama Islam6","Categorie Book","Description Book",R.drawable.img7));

    }
}
