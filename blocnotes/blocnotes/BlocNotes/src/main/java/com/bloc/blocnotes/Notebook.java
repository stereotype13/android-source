package com.bloc.blocnotes;

/**
 * Created by stereotype13 on 6/29/14.
 */
public class Notebook {
    private int mId;
    private String mName;

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public void setId(int id) {
        mId = id;
    }

    public void setName(String name) {
        mName = name;
    }

    public Notebook(int id, String name) {
        mId = id;
        mName = name;
    }

    public Notebook() {
        mId = -1;
        mName = null;
    }

    @Override
    public String toString() {
        return (mId + " " + mName);
    }
}
