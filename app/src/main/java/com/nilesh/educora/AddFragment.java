package com.nilesh.educora;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class AddFragment extends Fragment {

    TextInputLayout pt,pc;
    TextInputEditText t, c;
    Button ap,si;
   FirebaseDatabase database;
   DatabaseReference reference;

    private static final int REQUEST_CODE_PERMISSION = 123;
    private static final int REQUEST_CODE_SELECT_IMAGES = 456;

    private LinearLayout imageContainer;
    private List<Uri> selectedImages;

    public AddFragment() {
        // Required empty public constructor
    }


    public static AddFragment newInstance(String param1, String param2) {
        AddFragment fragment = new AddFragment();

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
        View v = inflater.inflate(R.layout.fragment_add, container, false);




        pt = v.findViewById(R.id.ptl);
        pc = v.findViewById(R.id.pcl);
        t = v.findViewById(R.id.pte);
        c = v.findViewById(R.id.pce);
        ap = v.findViewById(R.id.apb);
        si = v.findViewById(R.id.select_img);

       /* si.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getContext(),
                        android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    // Permission is not granted, request it
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE},
                            REQUEST_CODE_PERMISSION);
                } else {
                    // Permission is already granted, start image selection
                    startImageSelection();
                }
            }
        });*/





        ap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference = database.getInstance().getReference("posts");
                String title = t.getText().toString();
                String content = c.getText().toString();
                final String randomCode2 = UUID.randomUUID().toString().substring(0, 7);
                String ids = randomCode2;
                reference.getDatabase().getReference("posts").child(ids).child("title").setValue(title);
                reference.getDatabase().getReference("posts").child(ids).child("content").setValue(content);
            }
        });





        return  v;
    }
/*
    private void startImageSelection() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        startActivityForResult(intent, REQUEST_CODE_SELECT_IMAGES);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SELECT_IMAGES && resultCode == RESULT_OK) {
            ArrayList<Bitmap> selectedImages = new ArrayList<>();

            if (data.getClipData() != null) {
                int count = data.getClipData().getItemCount();
                for (int i = 0; i < count; i++) {
                    try {
                        Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), data.getClipData().getItemAt(i).getUri());
                        selectedImages.add(imageBitmap);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else if (data.getData() != null) {
                try {
                    Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), data.getData());
                    selectedImages.add(imageBitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            displaySelectedImages(selectedImages);
        }
    }

    private void displaySelectedImages(ArrayList<Bitmap> images) {
        imageContainer.removeAllViews();

        for (Bitmap image : images) {
            ImageView imageView = new ImageView(getContext());
            imageView.setImageBitmap(image);
            imageView.setPadding(8, 0, 8, 0);
            imageContainer.addView(imageView);
        }
    }*/
}