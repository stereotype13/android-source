package com.bloc.blocnotes;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by stereotype13 on 7/30/14.
 */
public class NotebookCustomAdapter extends ArrayAdapter<Note> {

    private String externalCacheDir;

    public NotebookCustomAdapter(Context context, List<Note> noteList) {
        super(context, 0, noteList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rootView = (View)LayoutInflater.from(getContext()).inflate(R.layout.single_note_bitmap, parent, false);

        ImageView imageView = (ImageView)rootView.findViewById(R.id.imgIcon);
        TextView textView = (TextView)rootView.findViewById(R.id.txtNotebody);

        textView.setText(getItem(position).getBody());
        imageView.setImageBitmap(bitmapFromCache(String.valueOf(getItem(position).getId())));

        return rootView;
    }

    public Bitmap bitmapFromCache(String name) {
        String extState = Environment.getExternalStorageState();
        if (!(extState.equals(Environment.MEDIA_MOUNTED) ||
                extState.equals(Environment.MEDIA_MOUNTED_READ_ONLY))) {
            return null;
        }
        String photoPath = getContext().getExternalCacheDir() + File.separator + name;
        File photoFile = new File(photoPath);

        // Check if the file exists
        if (photoFile.exists() == false) {
            // Returning null signifies that the file is not in cache
            return null;
        }
        // Re-create the bitmap from the raw data saved during `saveImageToSD`
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        return BitmapFactory.decodeFile(photoPath, options);
    }


}
