package com.bloc.blocnotes;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by stereotype13 on 7/27/14.
 */
public class ShowSnoozeFragment extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ReminderFragment reminderFragment = new ReminderFragment(getParent());
        reminderFragment.show(getFragmentManager(), "reminder_fragment");


    }
}
