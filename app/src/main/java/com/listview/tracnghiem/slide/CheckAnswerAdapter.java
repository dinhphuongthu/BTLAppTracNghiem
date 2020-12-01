package com.listview.tracnghiem.slide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.listview.tracnghiem.R;
import com.listview.tracnghiem.question.Question;

import java.util.ArrayList;

public class CheckAnswerAdapter extends BaseAdapter {
    ArrayList listData;
    LayoutInflater inflater;

    public CheckAnswerAdapter(ArrayList listData, Context context){
        this.listData=listData;
        inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private static class ViewHolder{
        TextView tvNumAns,tvAnswer;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Question data = (Question) getItem(position);
        ViewHolder holder;
        if(convertView==null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_girdview_list_answer,null);
            holder.tvNumAns = (TextView) convertView.findViewById(R.id.tvnumAnswer);
            holder.tvAnswer = (TextView) convertView.findViewById(R.id.tvAnswer);
            convertView.setTag(holder);

        }else{
           holder = (ViewHolder) convertView.getTag();
        }
        int i = position+1; //cau tra loi thu i
        holder.tvNumAns.setText("Câu "+i+ ": ");
        holder.tvAnswer.setText(data.getTraloi());
        return convertView;
    }
}
