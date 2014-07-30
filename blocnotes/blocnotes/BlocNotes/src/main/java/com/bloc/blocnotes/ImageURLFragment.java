package com.bloc.blocnotes;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by rhodel on 7/30/2014.
 */
public class ImageURLFragment extends DialogFragment {

    private String mURL;
    private EditText mEditText;
    private Button mOkButton;
    private ImageURLFragmentListener mImageURLFragmentListener;
    private Note mNote;


    public ImageURLFragment(Activity activity, Note note) {
        mImageURLFragmentListener = (ImageURLFragmentListener) activity;
        mURL = "";
        mNote = note;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = (View)inflater.inflate(R.layout.fragment_image_url, container, false);
        mEditText = (EditText) rootView.findViewById(R.id.etImageURLFragment);
        mOkButton = (Button) rootView.findViewById(R.id.btnImageURLFragmentOK);

        getDialog().setTitle("Choose Image URL");

        mOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mEditText.getText() != null) {
                    mURL = mEditText.getText().toString();
                    mNote.setURL(mURL);
                    mNote.save();
                }
                else {
                    mURL = "";
                    mNote.setURL(mURL);
                    mNote.save();
                }

                mImageURLFragmentListener.onURLSelected(mURL, mNote);
            }
        });


        return rootView;
    }

    public interface ImageURLFragmentListener {
        public void onURLSelected(String url, Note note);
    }
}
