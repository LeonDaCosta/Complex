package com.lroxima.demo.complex.complex;

import java.util.Date;
import java.util.UUID;

/**
 * Created by leon on 03/09/17.
 */

public class Entry {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public Entry() {
        // Generate unique identifier
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }
    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Date getDate() { return mDate; }
    public void setDate(Date date) { mDate = date; }

    public boolean isSolved() { return mSolved; }
    public void setSolved(boolean solved) { mSolved = solved; }
}
