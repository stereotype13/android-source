package com.bloc.blocnotes;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.List;

/**
 * Created by rhodel on 7/18/2014.
 */
public class NotebookArrayAdapter extends ArrayAdapter<Notebook> {

    private List<Notebook> items;
    private int layoutResourceId;
    private Context context;
    private INotebookArrayAdapterListener listener = null;

    public static class NotebookHolder {
        TextView textView;
        ImageButton imageButton;
        Notebook notebook;
    }

    NotebookArrayAdapter(Context context, int layoutResourceId, List<Notebook> items) {
        super(context, layoutResourceId, items);

        this.items = items;
        this.layoutResourceId = layoutResourceId;
        this.context = context;

        listener = (INotebookArrayAdapterListener)context;

    }

    private void setupItem(final NotebookHolder notebookHolder) {

        notebookHolder.textView.setText(notebookHolder.notebook.getName());

        notebookHolder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(getContext(), notebookHolder.imageButton);
                popupMenu.getMenu().add(Menu.NONE, 0, Menu.NONE, "Add note");

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch(menuItem.getItemId()) {
                            case 0:
                                listener.onPopupMenuNewNotebook(notebookHolder.imageButton);
                                break;
                            default:
                        }

                        return true;
                    }
                });

                popupMenu.show();
            }
        });



    }

    public interface INotebookArrayAdapterListener {
        public void onPopupMenuNewNotebook(View view);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        NotebookHolder notebookHolder = null;

        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        row = inflater.inflate(layoutResourceId, parent, false);

        notebookHolder = new NotebookHolder();


        notebookHolder.notebook = items.get(position);
        notebookHolder.textView = (TextView)row.findViewById(R.id.notebook_name);
        notebookHolder.imageButton = (ImageButton)row.findViewById(R.id.three_dots);
        notebookHolder.imageButton.setFocusable(false);
        notebookHolder.imageButton.setTag(notebookHolder.notebook);


        row.setTag(notebookHolder);
        setupItem(notebookHolder);
        return row;
    }
}
