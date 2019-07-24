package com.example.android.memegen;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class top extends Fragment {
    EditText one;
    EditText two;
    Button button;
    TopSectionListener activityCommander;
    public interface TopSectionListener{public void createMeme(String top,String bot);}

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

            try{
                activityCommander=(TopSectionListener)context;

            }catch (ClassCastException e){}
            throw new ClassCastException(context.toString());
        }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_frag,container,false);
         one = (EditText)view.findViewById(R.id.editText);
         two = (EditText)view.findViewById(R.id.editText2);
        button = (Button)view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityCommander.createMeme(one.getText().toString(),two.getText().toString());

            }
        });


        return view;
    }
}
