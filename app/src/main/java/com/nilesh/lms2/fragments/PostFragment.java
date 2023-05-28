package com.nilesh.lms2.fragments;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.storage.StorageReference;
import com.nilesh.lms2.R;
import com.nilesh.lms2.activities.MainActivity;

import java.util.UUID;


public class PostFragment extends Fragment {



    EditText tit,desc,locat,price,phone;
    String id,img_uri;
            Button selImg,postData;
            ImageView imgv;
    final int RESULT_LOAD_IMG =100;
    private StorageReference storageReference;
    private Uri selectedImageUri;


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
        imgv = v.findViewById(R.id.demo_img);
selImg.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        chooseImage();
    }
});




        return v;
    }
    private void chooseImage() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, RESULT_LOAD_IMG);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK) {
            selectedImageUri = data.getData();
            imgv.setImageURI(selectedImageUri);
            uploadImage();
        }
    }
    private void uploadImage() {
        if (selectedImageUri != null) {
            StorageReference imageRef = storageReference.child("images/" + UUID.randomUUID().toString());
            imageRef.putFile(selectedImageUri)
                    .addOnSuccessListener(taskSnapshot -> {
                        Toast.makeText(getContext(), "Image uploaded successfully", Toast.LENGTH_SHORT).show();
                        String imgurl = selectedImageUri.toString();
                        tit.setText(imgurl);

                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(getContext(), "Image upload failed", Toast.LENGTH_SHORT).show();

                    });
        }
//        @Override
//        public void onSuccess(Uri) {
//                String imageUrl = downloadUri.toString();
//        // Use the URL as needed
//                        }
    }
}