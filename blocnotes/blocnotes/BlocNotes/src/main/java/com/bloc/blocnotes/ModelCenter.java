package com.bloc.blocnotes;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by stereotype13 on 7/10/14.
 */
public abstract class ModelCenter<T extends Model> {
    private String mTableName;
    private Map<Long, T> mModels;

    public ModelCenter(String table) {
        mTableName = table;
        mModels = new HashMap<Long, T>();
    }

    public Model get(long rowId) {
        return get(rowId, true);
    }

    public T get(long rowId, boolean lazyLoad) {
        //T model = null;

        T model = mModels.get(String.valueOf(rowId));

        if(model == null) {
            model = _createModel(rowId);
        }

        if (lazyLoad == false && model.isLoaded() == false) {
            model.load();
        }
        return model;
    }



    protected abstract T _createModel(long rowId);
}
