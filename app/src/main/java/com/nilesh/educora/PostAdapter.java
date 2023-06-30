package com.nilesh.educora;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class PostAdapter extends ArrayAdapter<Posts> {
    public PostAdapter(@NonNull Context context, ArrayList<Posts> postsArrayList) {
        super(context, 0, postsArrayList);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // below line is use to inflate the
        // layout for our item of list view.
        View listitemView = convertView;
        if (listitemView == null) {
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.list_post, parent, false);
        }

        // after inflating an item of listview item
        // we are getting data from array list inside
        // our modal class.
        Posts posts = getItem(position);

        // initializing our UI components of list view item.
        TextView tit = listitemView.findViewById(R.id.title_text);
        TextView con = listitemView.findViewById(R.id.content_text);


        // after initializing our items we are
        // setting data to our view.
        // below line is use to set data to our text view.
        tit.setText(posts.getTitle());
        con.setText(posts.getContent());


        // below line is use to add item click listener
        // for our item of list view.
        listitemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on the item click on our list view.
                // we are displaying a toast message.
                Toast.makeText(getContext(), "Item clicked is : " + posts.getTitle(), Toast.LENGTH_LONG).show();
            }
        });
        return listitemView;
    }
}
