package com.example.icarus.photgalleryactivity;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.io.IOException;

    private class FetchItemsTask extends AsyncTask<Void,Void,Void> {
        new FlickrFetchr().fetchItems();
        return null;
    }

    private class FetchItemsTask extneds AsyncTask<Void,Void,Void> {
        @Override
            protected Void doInBackground(Void... params){
        new FlickrFetchr().fetchItems();
        return null;
        }
        }

    GridView mGridView;
    ArrayList<GalleryItem> mItems;
    @override
    public void onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
        new FetchItemsTask().execture();



    private class FetchItemsTask extends AsyncTask<Void,Void,Void> {
        @Override
        protected Void doInBackground(Void... params) {
            new FlikrFetchr().fetchItems
            return null;

        }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_photo_gallery);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_photo_gallery, container, false);

        mGridView = (GridView) v.findViewById(R.id.gridView);


        setupAdapter();


        return v;
    }

    void setupAdapter() {
        if (getActivity() == null || mGridView == null) return;

        if (mItems != null) {
            mGridView.setAdapter(new ArrayAdapter<GalleryItem>(getActivity(),
                    android.R.layout.simple_gallery_item, mItems));
        } else {
            mGridView.setAdapter(null);
        }
        }





    @Override
    public Fragment createFragment() {
        return new PhotGalleryFragment();
}
