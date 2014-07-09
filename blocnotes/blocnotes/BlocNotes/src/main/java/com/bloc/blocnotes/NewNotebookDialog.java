package com.bloc.blocnotes;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by stereotype13 on 7/6/14.
 */
public class NewNotebookDialog extends DialogFragment {

    public OnNewNotebookListener mCallback;

    public interface OnNewNotebookListener {
        public void onNewNotebook();
    }



    private String mNotebookName;
    private EditText mEditText;
    private Button mOKButton;

    public NewNotebookDialog() {
        //do nothing
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (OnNewNotebookListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnNewNotebookListener");
        }
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_new_notebook_dialog, container);

        mEditText = (EditText) rootView.findViewById(R.id.etNewNotebookName);

        mOKButton = (Button) rootView.findViewById(R.id.buttonNewNotebookOK);


        mOKButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNotebookName = mEditText.getText().toString();

                SQLiteDatabase db =  BlocNotesApplication.getBlocNotesDBHelper().getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("NAME", mNotebookName);

                db.insert("Notebooks", null, values);
                db.close();



                mCallback.onNewNotebook();
                dismiss();
            }
        });

        return rootView;

    }



}
