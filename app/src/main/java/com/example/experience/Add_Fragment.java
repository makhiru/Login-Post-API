package com.example.experience;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class Add_Fragment extends Fragment {

    EditText name, price, description;
    ImageView img;
    Button btnadd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);

        name = view.findViewById(R.id.pro_name);
        price = view.findViewById(R.id.pro_price);
        description = view.findViewById(R.id.pro_des);
        img = view.findViewById(R.id.pro_img);
        btnadd = view.findViewById(R.id.btnadd);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }
}