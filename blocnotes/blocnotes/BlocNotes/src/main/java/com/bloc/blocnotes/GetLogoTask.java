package com.bloc.blocnotes;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by rhodel on 7/30/2014.
 */
public class GetLogoTask extends AsyncTask<Bundle , Integer, Bitmap> {

    IGetLogoTaskListener mListener;

    private static final String LOGO_URL = "LOGO_URL";
    private static final String NOTE_ID = "NOTE_ID";

    private long mNoteID;
    private String mURL;

    public GetLogoTask(Activity activity) {
        mListener = (IGetLogoTaskListener)activity;
    }

    @Override
    protected Bitmap doInBackground(Bundle... bundles) {


        mURL = bundles[0].getString(LOGO_URL);
        mNoteID = bundles[0].getLong(NOTE_ID);

        Bitmap logo = null;

        try {
            URL logoURL = new URL(mURL);

            URLConnection urlConnection = logoURL.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            logo = BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }



        return logo;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        mListener.onGetLogoTaskCompleted(bitmap, mNoteID, mURL);
    }

    public interface IGetLogoTaskListener {
        public void onGetLogoTaskCompleted(Bitmap bitmap, Long noteID, String url);
    }
}
