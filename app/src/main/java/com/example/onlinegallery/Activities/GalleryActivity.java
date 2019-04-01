package com.example.onlinegallery.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.onlinegallery.Adapters.GalleryImageAdapter;
import com.example.onlinegallery.Interfaces.IRecyclerViewClickListener;
import com.example.onlinegallery.R;

import java.util.Random;

public class    GalleryActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);


        Random random = new Random();
        final String[] images = new String[10];
        for(int i=0;i<images.length;i++)
            images[i] = "http://picsum.photos/600?image=" + random.nextInt(1000+1);
        final IRecyclerViewClickListener listener = new IRecyclerViewClickListener() {


            @Override
                    public void onClick(View view,int position) {

                Intent i = new Intent(getApplicationContext(), FullScreenActivity.class);
                i.putExtra("IMAGES", images);
                i.putExtra("POSITION", position);
                startActivity(i);
            }


        };

        GalleryImageAdapter galleryImageAdapter = new GalleryImageAdapter(this,images,listener);
        recyclerView.setAdapter(galleryImageAdapter);

    }
}
