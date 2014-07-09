package com.bloc.blocnotes;

import android.app.DialogFragment;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

/**
 * Created by rhodel on 6/18/2014.
 */
public class CustomStyleDialogFragment extends DialogFragment implements AdapterView.OnItemSelectedListener {

    public Spinner spinner;
    public CustomStyleDialogFragment() {
        //To do
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_custom_style_dialog, container);
        getDialog().setTitle("Custom Dialog");

        spinner = (Spinner) view.findViewById(R.id.spinner_fonts);
        spinner.setOnItemSelectedListener(this);


        //rootView = (View) inflater.inflate(R.layout.fragment_bloc_notes);
        //final EditText editText = (EditText) view.findViewById(R.id.etEditText1);
        final EditText editText = (EditText) getActivity().findViewById(R.id.etEditText1);


        RadioGroup group = (RadioGroup) view.findViewById(R.id.rg_font_size);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                SharedPreferences.Editor editor = getActivity().getPreferences(0).edit();
                if (checkedId == R.id.rb_small) {
                    editText.setTextSize(10);
                    editor.putString("font_size", "10");
                    editor.commit();
                } else if (checkedId == R.id.rb_medium) {
                    editText.setTextSize(25);
                    editor.putString("font_size", "25");
                    editor.commit();
                } else if (checkedId == R.id.rb_large) {
                    editText.setTextSize(50);
                    editor.putString("font_size", "50");
                    editor.commit();
                }
            }
        });

        return view;
    }

    public void changeStyle(Typeface tf) {
        EditText et = (EditText) getActivity().findViewById(R.id.etEditText1);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String type_face = prefs.getString("type_face", "default");
        String text_size = prefs.getString("font_size", "25");
        tf = Typeface.DEFAULT;

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

        et.setTypeface(tf);
        et.setTextSize(ts);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        Typeface tf = Typeface.DEFAULT;

        SharedPreferences.Editor editor = getActivity().getPreferences(0).edit();


        if("System font".equals(parent.getItemAtPosition(pos).toString())){
            tf = Typeface.DEFAULT;
            editor.putString("type_face", "default");
            editor.commit();
        } else if("Helvetica".equals(parent.getItemAtPosition(pos).toString())) {
            tf = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Helvetica_Reg.ttf");
            editor.putString("type_face", "fonts/Helvetica_Reg.ttf");
            editor.commit();
        } else if("Helvetica-Neue".equals(parent.getItemAtPosition(pos).toString())) {
            tf = Typeface.createFromAsset(getActivity().getAssets(), "fonts/HelveticaNeue_Lt.ttf");
            editor.putString("type_face", "fonts/HelveticaNeue_Lt.ttf");
            editor.commit();
        } else if("Impact".equals(parent.getItemAtPosition(pos).toString())) {
            tf = Typeface.createFromAsset(getActivity().getAssets(), "fonts/impact.ttf");
            editor.putString("type_face", "fonts/impact.ttf");
            editor.commit();
        }


        changeStyle(tf);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
