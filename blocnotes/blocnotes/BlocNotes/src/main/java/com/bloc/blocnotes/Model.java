package com.bloc.blocnotes;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bloc.blocnotes.BlocNotesApplication;

/**
 * Created by stereotype13 on 7/10/14.
 */
public abstract class Model {
    // This model's unique ID
    protected long mRowId;
    // The table this model belongs to
    protected String mTableName;
    // True if loaded
    protected boolean mLoaded;

    public Model() {

    }

    // Partial constructor
    public Model(String table, long rowId) {
        this(table, rowId, true);
    }

    // Full constructor
    public Model(String table, long rowId, boolean lazy) {
        mTableName = table;
        mRowId = rowId;
        if (lazy == false) {
            load();
        }
    }

    // Cursor-based constructor
    public Model(String table, Cursor cursor) {
        mTableName = table;
        mRowId = cursor.getLong(cursor.getColumnIndex("_id"));
        _load(cursor);
    }

    public boolean isLoaded() {
        return mLoaded;
    }

    protected void setLoaded(boolean loaded) {
        mLoaded = loaded;
    }

    public final void load() {
        if (isLoaded()) {
            return;
        }
        Cursor row =
                BlocNotesApplication.getBlocNotesDBHelper().getWritableDatabase().query(true,
                        mTableName,
                        null, "_id=",
                        new String[]{String.valueOf(getRowId())},
                        null, null, null, "1");
        row.moveToFirst();
        _load(row);
        row.close();
        setLoaded(true);
    }

    public final void save() {
        ContentValues values = _getContentValues();

        SQLiteDatabase db = BlocNotesApplication.getBlocNotesDBHelper().getWritableDatabase();

        Cursor cursor = db.query(mTableName, new String[]{"_id"}, String.valueOf(getRowId()), null, null, null, null );

        if(cursor.getCount() > 0) {
            db.update(mTableName,
                    values, "_id=",
                    new String[]{String.valueOf(getRowId())});
        }
        else
        {
            db.insert(mTableName, null, values);
        }

    }

    public final long getRowId() {
        return mRowId;
    }

    // Populate model with data from the cursor
    protected abstract void _load(Cursor row);

    // Recover ContentValues for the model
    protected abstract ContentValues _getContentValues();
}
