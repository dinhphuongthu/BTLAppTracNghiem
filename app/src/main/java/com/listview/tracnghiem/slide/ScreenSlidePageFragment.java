package com.listview.tracnghiem.slide;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.listview.tracnghiem.R;
import com.listview.tracnghiem.question.Question;

import java.util.ArrayList;
import java.util.Queue;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ScreenSlidePageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScreenSlidePageFragment extends Fragment {
       ArrayList<Question> listQuestions; //khai bao 1 mang question

       public static final String ARG_PAGE="page";
       private int mPagenumber; // Vi tri trang hien tai

    TextView tvNum, tvQuestion;
    RadioGroup radioGroup;
    RadioButton radA,radB,radC,radD;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ScreenSlidePageFragment() {
        // Required empty public constructor
    }


     //TODO: Rename and change types and number of parameters
    public static ScreenSlidePageFragment newInstance(String param1, String param2) {
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    //get Data from ScreenSlideActivity
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listQuestions = new ArrayList<Question>();
        ScreenSlideActivity slideActivity = (ScreenSlideActivity) getActivity();
        listQuestions = slideActivity.getData();
        //LAY VI TRI
        mPagenumber = getArguments().getInt(ARG_PAGE);
    }
    public static ScreenSlidePageFragment create(int pageNumber){
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        //Đóng gói dữ liệu để truyền
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE,pageNumber);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);
        tvNum = (TextView)rootView.findViewById(R.id.tvNum);
        tvQuestion = (TextView)rootView.findViewById(R.id.tvQuestion);
        radA = (RadioButton) rootView.findViewById(R.id.radA);
        radB = (RadioButton) rootView.findViewById(R.id.radB);
        radC = (RadioButton) rootView.findViewById(R.id.radC);
        radD = (RadioButton) rootView.findViewById(R.id.radD);
        radioGroup = (RadioGroup) rootView.findViewById(R.id.radGroup);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvNum.setText("Câu " + (mPagenumber+1));
        tvQuestion.setText(listQuestions.get(mPagenumber).getQuestion());
        radA.setText(listQuestions.get(mPagenumber).getAns_a());
        radB.setText(listQuestions.get(mPagenumber).getAns_b());
        radC.setText(listQuestions.get(mPagenumber).getAns_c());
        radD.setText(listQuestions.get(mPagenumber).getAns_d());
    }
}
