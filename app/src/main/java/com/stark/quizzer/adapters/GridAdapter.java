package com.stark.quizzer.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.stark.quizzer.Activities.Questions;
import com.stark.quizzer.R;

import java.util.List;

public class GridAdapter extends BaseAdapter {
    private List<String> sets;
    private  String category;

    public GridAdapter(List<String> sets,String category)
    {
        this.sets = sets;
        this.category=category;
    }

    @Override
    public int getCount() {
        return sets.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        View view;
        TextView textView;
        if(convertView==null)
        {
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.set_item,parent,false);
           }
        else
        {
            view=convertView;
        }
        textView=view.findViewById(R.id.set_text);
        textView.setText(String.valueOf(position+1));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent questionIntent=new Intent(parent.getContext(), Questions.class);
                questionIntent.putExtra("category",category);
                questionIntent.putExtra("setId",sets.get(position));
                parent.getContext().startActivity(questionIntent);
            }
        });


        return view;
    }
}
