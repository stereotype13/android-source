package com.bloc.blocnotes;

import android.app.Activity;

import android.app.ActionBar;
import android.app.AlarmManager;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class BlocNotes extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks,
        NewNotebookDialog.OnNewNotebookListener,
        QueryNotebookTask.IQueryNotebookTask,
        NotebookCenter.INotebookCenter, NotebookArrayAdapter.INotebookArrayAdapterListener, ReminderFragment.ReminderFragmentListener {


    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private NotebookFragment mNotebookFragment;
    private NotebookCenter mNotebookCenter;
    private QueryNotebookTask mQueryNotebookTask;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    private NoteFragment mNoteFragment;

    @Override
    public void onDataSetUpdated() {
        //Notify all necessary components that the dataset was updated.
        BlocNotesApplication.showMessage("onDataSetUpdated");
        if(mNavigationDrawerFragment != null) {
            mNavigationDrawerFragment.refreshListView();
        }

    }

   @Override
    public void onNotebookQueryComplete(Cursor cursor) {

        //BlocNotesApplication.showMessage("The query has completed");
        //BlocNotesApplication.showMessage("There are " + cursor.getCount() + " records in the cursor.");
        NotebookCenter.getInstance(this).fill(cursor);


    }

    @Override
    public void onNewNotebook() {

        //A new notebook has been inserted into the database, so re-query (in a seperate thread)
        QueryNotebookTask queryNotebookTask = new QueryNotebookTask(this);
        queryNotebookTask.execute();
    }

    public static class CustomStylePreferenceFragment extends PreferenceFragment {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            addPreferencesFromResource(R.xml.preferences);
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //BlocNotesApplication.get(this).getBlocNotesDBHelper()
        setContentView(R.layout.activity_bloc_notes);

        //First, create a notebook data center
        mNotebookCenter = NotebookCenter.getInstance(this);

        mQueryNotebookTask = new QueryNotebookTask(this);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);

        /*Cursor cursor =
                BlocNotesApplication.getBlocNotesDBHelper().getWritableDatabase().query(true,
                        "Notebooks",
                        null, null,
                        null,
                        null, null, null, null);

        BlocNotesApplication.showMessage("Cursor has " + cursor.getCount() + " records");

        mNotebookCenter.fill(cursor);*/



        mTitle = getTitle();

        // New NoteFragment
        if(savedInstanceState == null) {

            mNoteFragment = new NoteFragment();

            getFragmentManager().beginTransaction().replace(R.id.container, mNoteFragment, "note_fragment").addToBackStack(null).commit();
        }
        else {

            mNoteFragment = (NoteFragment) getFragmentManager().findFragmentByTag("note_fragment");
        }

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));


    }


    @Override
    public void onNavigationDrawerItemSelected(int position) {


        Notebook notebook = new Notebook(2, "Some other notebook");


        if(mNavigationDrawerFragment != null) {

            notebook = mNavigationDrawerFragment.getNotebookFromPosition(position);
            Toast.makeText(this, notebook.toString(), Toast.LENGTH_SHORT).show();

            mNotebookFragment = new NotebookFragment(notebook);


            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.container, mNotebookFragment)
                    .addToBackStack(null)
                    .commit();

        }

        //Toast.makeText(this, notebook.toString(), Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, position, Toast.LENGTH_SHORT).show();
        // update the main content by replacing fragments
        //Toast.makeText(this, mNavigationDrawerFragment.getNotebookFromPosition(position).toString(), Toast.LENGTH_SHORT).show();
       /* FragmentManager fragmentManager = getFragmentManager();
       fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();*/

    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = "Section 1";
                break;
            case 2:
                mTitle = "Section 2";
                break;
            case 3:
                mTitle = "Section 3";
                break;
            case 4:
                mTitle = "Hello";
                break;
            case 5:
                mTitle = "World";
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.bloc_notes, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.ic_menu_cut:
                EditText editText = (EditText)findViewById(R.id.etEditText1);
                editText.setText("");
                break;
            case R.id.ic_menu_custom_dialog:
                CustomStyleDialogFragment customStyleDialogFragment = new CustomStyleDialogFragment();
                customStyleDialogFragment.show(getFragmentManager(), "custom_dialog");
                break;
            case R.id.ic_menu_custom_preferences:
                Toast.makeText(this, "I clicked action_settings", Toast.LENGTH_SHORT).show();
                //getFragmentManager().beginTransaction().replace(R.id.container, new CustomStylePreferenceFragment()).commit();
                //Start new activity that will contain the CustomStylePreferenceFragment
                getFragmentManager().beginTransaction().replace(R.id.container, new CustomStylePreferenceFragment()).addToBackStack(null).commit();
                break;
            case R.id.save_note:
                NoteFragment noteFragment = (NoteFragment)getFragmentManager().findFragmentByTag("note_fragment");
                if(noteFragment != null) {
                    noteFragment.saveNote();
                }
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_bloc_notes, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((BlocNotes) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }


    public void onStyleChange(CustomStyleDialogFragment dialog, int styleId) {

    }


    public void onFontChange(CustomStyleDialogFragment dialog, String fontName) {

    }


    public void onThemeChange(CustomStyleDialogFragment dialog, int themeId) {

    }

    public void onPopupMenuNewNotebook(View v) {
        Notebook notebook = (Notebook)v.getTag();

        Note note = new Note();
        note.setNotebook(notebook);
        notebook.notes.add(note);

        mNoteFragment = new NoteFragment(note);

        getFragmentManager().beginTransaction().replace(R.id.container, mNoteFragment, "note_fragment").addToBackStack(null).commit();

        if(mNavigationDrawerFragment != null) {
            mNavigationDrawerFragment.closeDrawer();
        }

    }

    public void onMenuSaveNote() {
        //
    }


    @Override
    public void onReminderIntervalSelected(String interval, Note note) {

        Intent noteReminder = new Intent(this, NoteReminderReceiver.class);
        noteReminder.setAction("SHOW_NOTIFICATION");
        noteReminder.putExtra("NOTE", note.getBody());

        PendingIntent noteReminderPending = PendingIntent.getBroadcast(this, 0, noteReminder, 0);

        AlarmManager alarmManager = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);



        if(interval.equals("5 minutes")) {
            //alarmManager.set(AlarmManager.RTC, System.currentTimeMillis() + 5*60*1000, noteReminderPending);
            alarmManager.set(AlarmManager.RTC, System.currentTimeMillis() + 1000, noteReminderPending);
        }

        if(interval.equals("10 minutes")) {
            alarmManager.set(AlarmManager.RTC, System.currentTimeMillis() + 10*60*1000, noteReminderPending);
        }

        if(interval.equals("15 minutes")) {
            alarmManager.set(AlarmManager.RTC, System.currentTimeMillis() + 15*60*1000, noteReminderPending);
        }

        if(interval.equals("30 minutes")) {
            alarmManager.set(AlarmManager.RTC, System.currentTimeMillis() + 30*60*1000, noteReminderPending);
        }

        if(interval.equals("60 minutes")) {
            alarmManager.set(AlarmManager.RTC, System.currentTimeMillis() + 60*60*1000, noteReminderPending);
        }
    }
}
