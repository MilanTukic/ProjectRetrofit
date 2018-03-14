package com.example.tukic.projectretrofit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.tukic.projectretrofit.R;
import com.example.tukic.projectretrofit.model.Student;

import java.util.List;

/**
 * Created by Tukic on 6/9/2017.
 */

public class RepoAdapter extends ArrayAdapter<Student> {

    private Context context;
    private List<Student> values;

    public RepoAdapter(Context context, List<Student> values) {
        super(context, R.layout.list_item_pagination, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.list_item_pagination, parent, false);
        }

        TextView textView = (TextView) row.findViewById(R.id.list_item_pagination_text);
        Student item = values.get(position);
        String message = item.getFirstName();
        String message1 = item.getSecondName();
        textView.setText(message+" "+message1);
        return row;
    }
}
