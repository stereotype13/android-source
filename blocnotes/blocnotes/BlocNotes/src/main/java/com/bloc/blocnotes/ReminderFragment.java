package com.bloc.blocnotes;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by rhodel on 7/22/2014.
 */
public class ReminderFragment extends DialogFragment implements AdapterView.OnItemSelectedListener {

    private Button mBtnOK;
    private Button mBtnCANCEL;
    private Spinner mSpinner;
    private ReminderFragmentListener mReminderFragmentListener;
    private Note mNote;

    public ReminderFragment(Activity activity) {
        mReminderFragmentListener = (ReminderFragmentListener)activity;
    }

    public ReminderFragment(Activity activity, Note note) {
        mReminderFragmentListener = (ReminderFragmentListener)activity;
        this.mNote = note;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView =  (View)inflater.inflate(R.layout.fragment_reminder, container, false);
        mSpinner = (Spinner)rootView.findViewById(R.id.reminder_spinner);
        mBtnOK = (Button) rootView.findViewById(R.id.btnOK);
        mBtnCANCEL = (Button) rootView.findViewById(R.id.btnCANCEL);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.reminder_intervals, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mSpinner.setAdapter(adapter);

        getDialog().setTitle("Add Reminder");

        mBtnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getDialog().dismiss();

                if(mNote == null) {
                    //Just create a blank note. We just want the body
                    mNote = new Note();
                }

                mReminderFragmentListener.onReminderIntervalSelected(mSpinner.getSelectedItem().toString(), mNote);

            }
        });

        mBtnCANCEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });

        return rootView;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String selectedItem = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(getActivity(), selectedItem, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public interface ReminderFragmentListener {
        public void onReminderIntervalSelected(String interval, Note note);
    }
}
