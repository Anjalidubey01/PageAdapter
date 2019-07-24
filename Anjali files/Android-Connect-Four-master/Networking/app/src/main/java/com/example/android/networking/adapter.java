package com.example.android.networking;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class adapter extends ArrayAdapter<earth> {
public adapter(Activity context, ArrayList<earth> eath){
    super(context,0,eath);
}
@Override
    public View getView(int position,  View convertView, ViewGroup parent) {
    View listItemView = convertView;
    if(listItemView==null){
        listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake,parent,false);
    }
    earth vocab = getItem(position);
    Date dateObject = new Date(vocab.getDate());


    TextView name = (TextView)listItemView.findViewById(R.id.textView3);
    //name.setText(vocab.getDate());
    String formattedDate = formatDate(dateObject);
    name.setText(formattedDate);
    TextView roll = (TextView)listItemView.findViewById(R.id.textView2);
    roll.setText(vocab.getPlace());
    TextView rol = (TextView)listItemView.findViewById(R.id.textView);
    rol.setText(vocab.getMag());
    TextView time = (TextView)listItemView.findViewById(R.id.textView4);
    String formattedTime = formatTime(dateObject);
    time.setText(formattedTime);
    return listItemView;

    }

     private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }


}
