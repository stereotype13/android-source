package com.bloc.blocnotes;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by stereotype13 on 6/29/14.
 */
public class NotebookAdapter extends ArrayAdapter<Notebook> {
    public NotebookAdapter(Context context, List<Notebook> notebookList) {
        super(context, 0, notebookList);
    }
}
