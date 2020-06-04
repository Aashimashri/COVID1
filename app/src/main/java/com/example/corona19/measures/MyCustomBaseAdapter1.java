package com.example.corona19.measures;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.corona19.R;

class MyCustomBaseAdapter1 extends BaseAdapter {
    Context context;
    int image[];
    String data[];
    public MyCustomBaseAdapter1(Context context, int[] image, String[] data) {
        this.context=context;
        this.image=image;
        this.data = data;
    }

    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ImageView iv;
        TextView tv;
        LayoutInflater li;
        li= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = li.inflate(R.layout.customlistview,parent,false);
        iv = view.findViewById(R.id.imageView);
        tv = view.findViewById(R.id.txtData);
        iv.setImageResource(image[position]);
        tv.setText(data[position]);
        return view;
    }
}
