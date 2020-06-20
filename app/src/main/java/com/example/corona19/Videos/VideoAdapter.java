package com.example.corona19.Videos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.corona19.R;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.videoviewHolder>{

    List<Youtubevideos> youtubeVideosList;
    public  VideoAdapter(){

    }
    public  VideoAdapter(List<Youtubevideos> youtubeVideosList){
        this.youtubeVideosList = youtubeVideosList;
    }

    @NonNull
    @Override
    public videoviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_view,parent,false);

        return new  videoviewHolder(view);

    }

    @Override
    public int getItemCount() {
        return youtubeVideosList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdapter.videoviewHolder holder, int position) {
        holder.videoWeb.loadData(youtubeVideosList.get(position).getVideoUrl(),"text/html","utf-0");

    }
    public class videoviewHolder extends  RecyclerView.ViewHolder {
        WebView videoWeb ;

        public videoviewHolder(View itemView) {
            super(itemView);
            videoWeb =itemView.findViewById(R.id.videowebview);
//            assert videoWeb != null;
            videoWeb.getSettings().setJavaScriptEnabled(true);
            videoWeb.setWebChromeClient(new WebChromeClient());
        }
    }
}
