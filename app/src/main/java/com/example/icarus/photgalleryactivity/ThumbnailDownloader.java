package com.example.icarus.photgalleryactivity;

import android.os.HandlerThread;
import android.util.Log;

/**
 * Created by Icarus on 9/12/2014.
 */
public class ThumbnailDownloader<Token> extends HandlerThread {
    private static final String TAG = "Thumbnaildown";

    public ThumbnailDownloader(){
        super(TAG);
    }

    public void queueThumbnail(Token token, String url) {
        Log.i(TAG, "Got an URL: " + url);
    }
}
