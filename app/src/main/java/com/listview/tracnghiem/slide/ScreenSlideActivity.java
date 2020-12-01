package com.listview.tracnghiem.slide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.listview.tracnghiem.R;
import com.listview.tracnghiem.question.Question;
import com.listview.tracnghiem.question.QuestionController;

import java.util.ArrayList;

//Su dung ViewPage
public class ScreenSlideActivity extends FragmentActivity {

    private static final int NUM_PAGES = 10;
    private ViewPager mPager;
    private PagerAdapter pagerAdapter;

    private int num_exam;
    private String subject;
    TextView tvKiemtra;
    //CSDL
    QuestionController questionController;
    ArrayList<Question> listQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);
        mPager.setPageTransformer(true, new ZoomOutPageTransformer());

        //intent luu num exam, subject

//        Intent in = getIntent();
//        subject = in.getStringExtra("subject");

        //Lay cau hoi tu csdl len slide page
        questionController = new QuestionController(this);
        listQuestion = new ArrayList<Question>();
        listQuestion=questionController.getQuestion(1,"toan");

        tvKiemtra =(TextView) findViewById(R.id.tvKiemTra);
        tvKiemtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 checkAnswer();
               // Toast.makeText(getApplicationContext(), "aaaa", Toast.LENGTH_SHORT).show();
            }
        });

        //Load cau hoi len fragment
        //trang so 1 --- tuong ung cau hoi 1 listQuestion[1]
        //B1: truyen duoc data sang fragmnet ; B2 truyen vi tri sang fragment
    }



    public ArrayList<Question> getData(){
        return listQuestion;
    }
    private class ZoomOutPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0f);

            } else if (position <= 1) { // [-1,1]
                // Modify the default slide transition to shrink the page as well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }

                // Scale the page down (between MIN_SCALE and 1)
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                // Fade the page relative to its size.
                view.setAlpha(MIN_ALPHA +
                        (scaleFactor - MIN_SCALE) /
                                (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0f);
            }
        }


    }
    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return ScreenSlidePageFragment.create(position);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

    public void checkAnswer(){
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.check_answer_dialog);
        dialog.setTitle("Danh sách câu trả lời");

        CheckAnswerAdapter answerAdapter = new CheckAnswerAdapter(listQuestion,this);
        GridView gvListAnswer =  dialog.findViewById(R.id.gvAnswer);
        gvListAnswer.setAdapter(answerAdapter);
        gvListAnswer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dialog.dismiss();
            }
        });
        Button btnCancel,btnFinish;
        btnCancel = (Button) dialog.findViewById(R.id.btnDong);
        btnFinish = (Button) dialog.findViewById(R.id.btnKetthuc);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
