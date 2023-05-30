package com.example.lr3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class Adapter extends ArrayAdapter<Student> {

    private final LayoutInflater inflater;
    private final int layout;
    private final List<Student> student;

    public Adapter(Context context, int resource, List<Student> student) {
        super(context, resource, student);
        this.student = student;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder viewHolder;
        if(view==null){
            view = inflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) view.getTag();
        }

        TextView FIOView = view.findViewById(R.id.name);
        TextView SEXView = view.findViewById(R.id.sex);
        TextView PLView = view.findViewById(R.id.lang);
        TextView IDEView = view.findViewById(R.id.ide);


        Student dt = student.get(position);

        FIOView.setText(dt.getName());
        SEXView.setText(dt.getSex());
        PLView.setText(dt.getLang());
        IDEView.setText(dt.getIde());

        return view;
    }

    private static class ViewHolder {
        TextView NameView, LView;
        ViewHolder(@NonNull View view){
            NameView = view.findViewById(R.id.name);
            LView = view.findViewById(R.id.lang);
        }
    }
}
