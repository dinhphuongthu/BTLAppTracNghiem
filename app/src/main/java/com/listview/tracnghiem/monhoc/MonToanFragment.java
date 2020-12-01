package com.listview.tracnghiem.monhoc;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.listview.tracnghiem.MainActivity;
import com.listview.tracnghiem.R;
import com.listview.tracnghiem.slide.ScreenSlideActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MonToanFragment extends Fragment {

    ExamAdapter examAdapter;
    GridView gridExam;
    ArrayList<Exam> arr_exam = new ArrayList<Exam>();


    public MonToanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Môn Toán");
        return inflater.inflate(R.layout.fragment_mon_toan, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gridExam = (GridView) getActivity().findViewById(R.id.gvToan);
        arr_exam.add(new Exam("Đề số 1"));
        arr_exam.add(new Exam("Đề số 2"));
        arr_exam.add(new Exam("Đề số 3"));
        arr_exam.add(new Exam("Đề số 4"));
        arr_exam.add(new Exam("Đề số 5"));

        examAdapter=new ExamAdapter(getActivity(),arr_exam);
        gridExam.setAdapter(examAdapter);
        gridExam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(),ScreenSlideActivity.class);
                startActivity(i);
            }
        });
    }
}
