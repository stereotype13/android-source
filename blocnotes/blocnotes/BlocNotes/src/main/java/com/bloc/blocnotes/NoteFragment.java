package com.bloc.blocnotes;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by stereotype13 on 6/15/14.
 */
public class NoteFragment extends Fragment {

    private EditText mEditText;
    private String mBodyText;

    public NoteFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null){

            mBodyText = savedInstanceState.getString("body");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View rootView = inflater.inflate(R.layout.fragment_note, container, false);
        mEditText = (EditText) rootView.findViewById(R.id.etEditText1);

        if(savedInstanceState != null) {
            mBodyText = savedInstanceState.getString("body");
            mEditText.setText(mBodyText);
        }
        //mEditText.setText(mBodyText);
        //mEditText.setText("Hello, World!");
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("body", mEditText.getText().toString());



    }



}