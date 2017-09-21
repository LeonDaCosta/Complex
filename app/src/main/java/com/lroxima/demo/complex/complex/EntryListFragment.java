package com.lroxima.demo.complex.complex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

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

    private void updateUI() {
        EntryLab entryLab = EntryLab.get(getActivity());
        List<Entry> entries = entryLab.getmEntries();

        if(mAdapter == null) {
            mAdapter = new EntryAdapter(entries);
            mEntryRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private class EntryHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private  Entry mEntry;

        private TextView mTitleTextView;
        private TextView mDateTextView;
        private CheckBox mSolvedCheckBox;

        public EntryHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.list_item_crime_title_text_view);
            mDateTextView = (TextView) itemView.findViewById(R.id.list_item_crime_date_text_view);
            mSolvedCheckBox = (CheckBox) itemView.findViewById(R.id.list_item_entry_solved_check_box);
        }

        public void bindEntry(Entry entry) {
            mEntry = entry;
            mTitleTextView.setText(mEntry.getTitle());
            mDateTextView.setText(mEntry.getDate().toString());
            mSolvedCheckBox.setChecked(mEntry.isSolved());
        }

        @Override
        public void onClick(View view) {
            //Intent intent = EntryPagerActivity.newIntent(getActivity(), mEntry.getId());
            //startActivity(intent);
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
            View view = layoutInflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            return new EntryHolder(view);
        }

        @Override
        public void onBindViewHolder(EntryHolder holder, int position) {
            Entry entry = mEntries.get(position);
            holder.bindEntry(entry);
        }

        @Override
        public int getItemCount() {
            return mEntries.size();
        }
    }
}
