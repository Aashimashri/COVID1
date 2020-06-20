package com.example.corona19.Videos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.corona19.R;

import java.util.Vector;

public class video extends AppCompatActivity {
    RecyclerView recyclerView ;
    Vector<Youtubevideos> youtubeVideos = new Vector<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        recyclerView =  findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        youtubeVideos.add(new Youtubevideos("<iframe width=\"400#\" height=\"300#\"  src=\"https://www.youtube.com/embed/8dlUqlMDkR4\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add(new Youtubevideos("<iframe width=\"400#\" height=\"300#\" src=\"https://www.youtube.com/embed/8c_UJwLq8PI\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add(new Youtubevideos("<iframe width=\"400#\" height=\"300#\" src=\"https://www.youtube.com/embed/DCdxsnRF1Fk\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add(new Youtubevideos("<iframe width=\"400#\" height=\"300#\" src=\"https://www.youtube.com/embed/Rn7LhJeqYiI\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add(new Youtubevideos("<iframe width=\"400#\" height=\"300#\" src=\"https://www.youtube.com/embed/pN7bL2likPI\" frameborder=\"0\" allowfullscreen></iframe>") );
        VideoAdapter videoAdapter = new VideoAdapter(youtubeVideos);
        recyclerView.setAdapter(videoAdapter);
    }
}
