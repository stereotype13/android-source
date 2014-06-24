package com.bloc.blocnotes;

import android.app.DialogFragment;
import android.app.Fragment;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

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

        Button smallButton = (Button) view.findViewById(R.id.btn_small);
        smallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setTextAppearance(getActivity(), android.R.style.TextAppearance_Small);
                //editText.setText("Clicked Small");
            }
        });

        Button mediumButton = (Button) view.findViewById(R.id.btn_medium);
        mediumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setTextAppearance(getActivity(), android.R.style.TextAppearance_Medium);
                //editText.setText("Clicked Medium");
            }
        });

        Button largeButton = (Button) view.findViewById(R.id.btn_large);
        largeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setTextAppearance(getActivity(), android.R.style.TextAppearance_Large);
               // editText.setText("Clicked Large");
            }
        });

        return view;
    }

    public void changeStyle(Typeface tf) {
        EditText et = (EditText) getActivity().findViewById(R.id.etEditText1);
        et.setTypeface(tf);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        Typeface tf = Typeface.DEFAULT;

        if("System font".equals(parent.getItemAtPosition(pos).toString())){
            tf = Typeface.DEFAULT;
        } else if("Helvetica".equals(parent.getItemAtPosition(pos).toString())) {
            tf = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Helvetica_Reg.ttf");
        } else if("Helvetica-Neue".equals(parent.getItemAtPosition(pos).toString())) {
            tf = Typeface.createFromAsset(getActivity().getAssets(), "fonts/HelveticaNeue_Lt.ttf");
        } else if("Impact".equals(parent.getItemAtPosition(pos).toString())) {
            tf = Typeface.createFromAsset(getActivity().getAssets(), "fonts/impact.ttf");
        }


        changeStyle(tf);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
