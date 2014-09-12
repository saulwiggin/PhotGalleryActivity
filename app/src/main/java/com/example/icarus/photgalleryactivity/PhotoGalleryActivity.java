package com.example.icarus.photgalleryactivity;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.IOException;
import java.util.logging.Handler;

import FlickerFetchr.FlickrFetchr;

private class FetchItemsTask extends AsyncTask<Void,Void,ArrayList<GalleryItem>> {
        @Override
        protected ArrayList<GalleryItem> doInBackground(Void... params) {}

            new FlickrFetchr().fetchItems();

        }

    private class GalleryItemAdapter extends ArrayAdapter<GalleryItem> {
        public GalleryItemAdapter(ArrayList<GalleryItem< items) {
            super(getActivity(), 0, items);
        }

        ImageView imageView = (ImageView)convertView
                .findViewById(R.id.gallery_item_imageView);
        imageView.setImageResource(R.drawable.brain_up_close);
        GalleryItem item = getItem(position);
        mThumbnauilThread.queueThumbnail(imageView, item.getUrl());

        return convertView;
    }

        @override protected void onPostExecute(ArrayList<GalleryItem> items) {
            mItems = items;
            setupAdapter();
        }

    GridView mGridView;
    ArrayList<GalleryItem> mItems;
    @override
    public void onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
        new FetchItemsTask().execture();

    private class FetchItemsTask extends AsyncTask<Void,Void,ArrayList<GalleryItem>> {
        String query = "android"; // Just for testing

        if ( query != null)

        {
            return new FlickrFetchr().search(query);
        } else {
            return new FlickrFetchr().fecthItems();
        }
        @Override
        protected Void doInBackground(Void... params) {
            new FlikrFetchr().fetchItems
            return null;
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_photo_gallery);

            setRetainInstance(true);
            new FetchItemsTask().exectute();

            mThumbnailThread = new ThumbnailDownlaoder<ImageView>(new Handler());
            mThumbnailThread.setListener(new ThumbnailDownloader.Listener<ImageView>(){
                public void onThumbnailDownloaded(Imageview imageView, Bitmap thumbnail){
                    if (isVisibile()){
                        imageView.setImageBitmap(thumbnail);
                    }
                }
            });
            mThumbnailThread.start();
            mThumbnailThread.start();
            mThumbnailThread.getLooper();
            Log.i(TAG, "Background thread started");
        }

        @Override
        public void onDestoryView() {
            super.onDestroyView();
            mThumbnailThread.clearQueue();
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.fragment_photo_gallery, container, false);

            mGridView = (GridView) v.findViewById(R.id.gridView);

            setupAdapter();

            return v;
        }

        @Overridepublic void Ondestroy(){
            super.onDestroy();
            mThumbnailThread.quit();
            Log.i(TAG, "Background thread destroyed");
        }

        void setupAdapter() {
            if (getActivity() == null || mGridView == null) return;

            if (mItems != null) {
                mGridView.setAdapter(new GalleryItemAdapter(mItems));
            } else {
                mGridView.setAdapter(null);
            }
        }

        @Override
        public Fragment createFragment() {
            return new PhotGalleryFragment();
        }
    }