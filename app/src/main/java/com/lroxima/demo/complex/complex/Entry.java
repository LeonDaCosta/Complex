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

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }
}
