package com.lroxima.demo.complex.complex;

import java.util.UUID;

/**
 * Created by leon on 03/09/17.
 */

public class Entry {

    private UUID mId;
    private String mTitle;

    public Entry() {
        // Generate unique identifier
        mId = UUID.randomUUID();
    }

    public UUID getmId() {
        return mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }
}
