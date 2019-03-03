package com.example.sherif.damakvf;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class RequestAdapter extends ArrayAdapter<Request>{
    public RequestAdapter(@NonNull Context context, int resource, @NonNull List<Request> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null){
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.request,parent,false);
        }

        TextView name = convertView.findViewById(R.id.name);
        TextView phone = convertView.findViewById(R.id.phone);
        TextView date = convertView.findViewById(R.id.date);
        TextView bloodType = convertView.findViewById(R.id.blood_type);
        TextView city = convertView.findViewById(R.id.city);
        LinearLayout cardView = convertView.findViewById(R.id.card_view);

        Request request = getItem(position);

        if ( ( Posts.city_send.equalsIgnoreCase("All")  || Posts.city_send.equalsIgnoreCase(request.getCity()) )&&
                ( Posts.blood_send.equalsIgnoreCase("All") || Posts.blood_send.equalsIgnoreCase(request.getBloodType())) ){
            name.setText(request.getName());
            phone.setText(request.getPhone());
            date.setText(request.getDate());
            bloodType.setText(request.getBloodType());
            city.setText(request.getCity());
       }else{
            name.setTextColor(Color.parseColor("#d61618"));
            phone.setTextColor(Color.parseColor("#d61618"));
            date.setTextColor(Color.parseColor("#d61618"));
            bloodType.setTextColor(Color.parseColor("#d61618"));
            city.setTextColor(Color.parseColor("#d61618"));
            bloodType.setBackgroundColor(Color.parseColor("#d61618"));
            cardView.setBackgroundColor(Color.parseColor("#d61618"));
        }


        return convertView;
    }
}
