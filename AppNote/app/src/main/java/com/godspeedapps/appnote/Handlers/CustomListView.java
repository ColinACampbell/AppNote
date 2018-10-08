package com.godspeedapps.appnote.Handlers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.godspeedapps.appnote.R;

/**
 * Created by Keanu on 29/3/2018.
 */

public class CustomListView extends ArrayAdapter<String> {
    String[] title =  null;
    String[] description = null;
    public CustomListView(Context context, String[] title, String[] description)
    {
        super(context, R.layout.list_layout,title);
        this.title =  title;
        this.description = description;
    }


    @Override
    public View getView(int position, View convertView,ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.list_layout,parent,false);
        TextView Title = customView.findViewById(R.id.Title);
        TextView Description = customView.findViewById(R.id.Description);

        Title.setText(title[position]);
        Description.setText(description[position]);

        return customView;
    }

    public void haha(int hahashit)
    {
        String sumn = "Cadoodles";
        System.out.println(sumn);
    }
}
