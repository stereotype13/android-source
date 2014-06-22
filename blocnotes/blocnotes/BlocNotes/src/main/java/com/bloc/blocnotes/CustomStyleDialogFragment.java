package com.bloc.blocnotes;

import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by rhodel on 6/18/2014.
 */
public class CustomStyleDialogFragment extends DialogFragment {

    public CustomStyleDialogFragment() {
        //To do
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_custom_style_dialog, container);
        getDialog().setTitle("Custom Dialog");

        return view;
    }

}
