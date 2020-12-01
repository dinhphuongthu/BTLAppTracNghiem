package com.listview.tracnghiem.monhoc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.listview.tracnghiem.R;

import java.util.ArrayList;

public class ExamAdapter extends ArrayAdapter<Exam> {
    public ExamAdapter(@NonNull Context context, ArrayList<Exam> exams) {
        super(context, 0, exams);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       if(convertView==null){
           LayoutInflater inflater = LayoutInflater.from(getContext());
           convertView = inflater.inflate(R.layout.item_girdview,parent,false);

       }
        TextView tvname = (TextView) convertView.findViewById(R.id.txt_num_exam);
        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.imageView);

        Exam p = getItem(position);
        if(p!=null){
            tvname.setText(""+p.getName());
            imgIcon.setImageResource(R.drawable.icon_dethi);
        }
        return convertView;
    }


}
