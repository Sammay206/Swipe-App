package com.example.swipeapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final ViewPager2 videoViewPager = findViewById(R.id.videosViewPager);

        List<VideoItem> videoItems = new ArrayList<>();
        VideoItem videoKittens = new VideoItem();
        videoKittens.videoURL = "https://firebasestorage.googleapis.com/v0/b/test-5f039.appspot.com/o/The%20life%20of%20ducklings%20and%20cute%20cats.%20Very%20interesting%20(720p%2C%20h264%2C%20youtube).mp4?alt=media&token=9f0bf84d-771d-4bf8-8352-3af9a744410b";
        videoKittens.videoTitle = "KITTENS";
        videoKittens.videoDescription = "I LOVE KITTENS";
        videoItems.add(videoKittens);

        VideoItem videoPuppy = new VideoItem();
        videoPuppy.videoURL = "https://firebasestorage.googleapis.com/v0/b/test-5f039.appspot.com/o/Puppy%20sound%20%23shorts%20%23puppy%20%23dog.mp4?alt=media&token=59b47b9a-e015-4df0-a6b8-a1dc6e24cdb2";
        videoPuppy.videoTitle = "PUPPY";
        videoPuppy.videoDescription = "I LOVE PUPPIES";
        videoItems.add(videoPuppy);


        videoViewPager.setAdapter(new VideoAdapter(videoItems));
    }
}