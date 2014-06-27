package com.bloc.blocnotes;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
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

    public NoteFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState != null){

           // mBodyText = savedInstanceState.getString("body");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View rootView = inflater.inflate(R.layout.fragment_note, container, false);

        mEditText = (EditText) rootView.findViewById(R.id.etEditText1);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String type_face = prefs.getString("type_face", "default");
        String text_size = prefs.getString("font_size", "25");
        Typeface tf = Typeface.DEFAULT;


        Toast.makeText(getActivity(), "The number of the typeface is " + type_face, Toast.LENGTH_SHORT).show();

        //Set the typeface
        if(type_face.equals("default")) {
            tf = Typeface.DEFAULT;
        } else if(type_face.equals("fonts/Helvetica_Reg.ttf")) {
            tf = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Helvetica_Reg.ttf");
        } else if(type_face.equals("fonts/HelveticaNeue_Lt.ttf")) {
            tf = Typeface.createFromAsset(getActivity().getAssets(), "fonts/HelveticaNeue_Lt.ttf");
        } else if(type_face.equals("fonts/impact.ttf")) {
            tf = Typeface.createFromAsset(getActivity().getAssets(), "fonts/impact.ttf");
        }

        float ts = 25;
        //Set the textSize
        if(text_size.equals("10")) {
            ts = 10;
        } else if(text_size.equals("25")) {
            ts = 25;
        } else if(text_size.equals("50")) {
            ts = 50;
        }

        mEditText.setTypeface(tf);
        mEditText.setTextSize(ts);

        if(savedInstanceState != null) {

            mEditText.setText(savedInstanceState.getString("body"));
        }

        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("body", mEditText.getText().toString());



    }



}