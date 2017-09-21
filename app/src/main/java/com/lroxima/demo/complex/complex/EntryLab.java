package com.lroxima.demo.complex.complex;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EntryLab {
    private static EntryLab sEntryLab;
    private static List<Entry> mEntries;

    public  static EntryLab get(Context context) {
        if (sEntryLab == null) {
            sEntryLab = new EntryLab(context);
        }
        return sEntryLab;
    }

    private EntryLab (Context context) {
        mEntries = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Entry entry = new Entry();
            entry.setTitle("Enrty #" + i);
            entry.setSolved(i % 2 == 0); // Every other one
            mEntries.add(entry);
        }
    }

    public List<Entry> getmEntries() {
        return mEntries;
    }

    public Entry getEntries(UUID id) {
        for (Entry entry : mEntries) {
            if (entry.getId().equals(id)) {
                return entry;
            }
        }
        return null;
    }
}
