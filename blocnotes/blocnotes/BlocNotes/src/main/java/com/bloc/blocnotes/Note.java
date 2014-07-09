package com.bloc.blocnotes;

/**
 * Created by stereotype13 on 6/29/14.
 */
public class Note {
    private int mId;
    private String mBody;
    private int mNotebookID;
    private Notebook mNotebook; //parent notebook

    public int getId() {
        return mId;
    }

    public String getBody() {
        return mBody;
    }

    public void setId(int id) {
        mId = id;
    }

    public void setBody(String body) {
        mBody = body;
    }

    public void setNotebook(Notebook notebook) {
        mNotebook = notebook;
        mNotebookID = notebook.getId();
    }

    public Note(int id, Notebook notebook, String body) {
        mId = id;
        mNotebookID = notebook.getId();
        mBody = body;
        mNotebook = notebook;
    }

    public Note(int id, int notebookID, String body) {
        mId = id;
        mNotebookID = notebookID;
        mBody = body;
        mNotebook = null;
    }

    public Note() {
        mId = -1;
        mNotebookID = -1;
        mBody = null;
    }

    @Override
    public String toString() {
        return (mId + " " + mNotebookID + " " + mBody);
    }
}
