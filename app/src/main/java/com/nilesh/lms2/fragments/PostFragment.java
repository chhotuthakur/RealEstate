package com.nilesh.lms2.fragments;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.nilesh.lms2.R;
import com.nilesh.lms2.activities.MainActivity;

import java.util.UUID;


public class PostFragment extends Fragment {



    EditText tit,desc,locat,price,phone;
    String id,img_uri;
    Button selImg,postData;
    ImageView imgv;
    final int RESULT_LOAD_IMG =100;
    StorageReference storageReference;
    StorageReference imageref;
    private Uri selectedImageUri;
    Uri fileUri;
    FirebaseDatabase database;
    ActivityResultLauncher<String> launcher;
    String ids, img_url,titl,descrip,locate,phonesw,authors;
    String imgyurl;


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

postData.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        uploadImage(selectedImageUri);
        titl = tit.getText().toString();
        descrip = desc.getText().toString();
        locate = locat.getText().toString();
        phonesw = phone.getText().toString();

        ids = phone.getText().toString();

        uploadImage(selectedImageUri);

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
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK) {
            selectedImageUri = data.getData();
            imgv.setImageURI(selectedImageUri);






        }
    }


    private void uploadImage(Uri selectedImageUri) {
        StorageReference storageReference1 = FirebaseStorage.getInstance().getReference().child("plots");
        String fid = UUID.randomUUID().toString();
        StorageReference imageName = storageReference1.child(fid);

        imageName.putFile(selectedImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                imageName.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {

                        DatabaseReference db =FirebaseDatabase.getInstance().getReference("plots")
                                .child(ids)
                                .child("image1_url");
                        db.setValue(uri.toString());
                        db.getDatabase().getReference("plots").child(ids).child("title").setValue(titl);
                        db.getDatabase().getReference("plots").child(ids).child("desc").setValue(descrip);
                        db.getDatabase().getReference("plots").child(ids).child("phone").setValue(phonesw);
                        db.getDatabase().getReference("plots").child(ids).child("location").setValue(locate);
                        db.getDatabase().getReference("plots").child(ids).child("author").setValue(authors);
                    }

                });


            }
        });

    }


}