package com.lroxima.demo.complex.complex;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class EntryListFragment extends Fragment {

    private RecyclerView mEntryRecyclerView;
    private EntryAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_entry_list, container, false);

        mEntryRecyclerView = (RecyclerView) view.findViewById(R.id.entry_recycler_view);
        mEntryRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        EntryLab entryLab = EntryLab.get(getActivity());
        List<Entry> entries = entryLab.getmEntries();

        if (mAdapter == null) {
            mAdapter = new EntryAdapter(entries);
            mEntryRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    private class EntryHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Entry mEntry;

        private TextView mTitleTextView;
        private TextView mDateTextView;
        private CheckBox mSolvedCheckBox;

        public EntryHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_entry, parent, false));

            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.entry_title);
            mDateTextView = (TextView) itemView.findViewById(R.id.entry_date);
            mSolvedCheckBox = (CheckBox) itemView.findViewById(R.id.entry_solved);
        }

        public void bind(Entry entry) {
            mEntry = entry;
            mTitleTextView.setText(mEntry.getTitle());
            mDateTextView.setText(mEntry.getDate().toString());
            //mSolvedCheckBox.setChecked(mEntry.isSolved());
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(getActivity(), mEntry.getTitle() + " clicked!", Toast.LENGTH_SHORT).show();
        }
    }

    private class EntryAdapter extends RecyclerView.Adapter<EntryHolder> {

        private List<Entry> mEntries;

        public EntryAdapter(List<Entry> entries) {
            mEntries = entries;
        }

        @Override
        public EntryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new EntryHolder(layoutInflater,parent);
        }

        @Override
        public void onBindViewHolder(EntryHolder holder, int position) {
            Entry entry = mEntries.get(position);
            holder.bind(entry);
        }

        @Override
        public int getItemCount() {
            return mEntries.size();
        }
    }
}
