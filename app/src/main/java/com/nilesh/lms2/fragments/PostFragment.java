package com.nilesh.lms2.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.nilesh.lms2.R;


public class PostFragment extends Fragment {



    EditText tit,desc,locat,price,phone;
    String id,img_uri;
            Button selImg,postData;


    public PostFragment() {
        // Required empty public constructor
    }


    public static PostFragment newInstance(String param1, String param2) {
        PostFragment fragment = new PostFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_post, container, false);

        tit  = v.findViewById(R.id.edt_plot_title);
        locat  = v.findViewById(R.id.edt_plot_locate);
        desc  = v.findViewById(R.id.edt_plot_desc);
        price  = v.findViewById(R.id.edt_plot_price);
        phone  = v.findViewById(R.id.edt_plot_phone);
        selImg = v.findViewById(R.id.sel_img_btn);
        postData = v.findViewById(R.id.post_data_btn);





        return v;
    }
}