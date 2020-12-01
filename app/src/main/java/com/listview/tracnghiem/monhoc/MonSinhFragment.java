package com.listview.tracnghiem.monhoc;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.listview.tracnghiem.MainActivity;
import com.listview.tracnghiem.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MonSinhFragment extends Fragment {

    public MonSinhFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Môn Sinh");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mon_sinh, container, false);
    }
}
