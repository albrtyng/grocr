package com.albertandmanisha.grocr;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;

/**
 * @author albertyang .
 **/
@SuppressLint("ValidFragment")
public class WelcomeActivityFragmentEasy extends Fragment {
    int wizard_page_position;

    public WelcomeActivityFragmentEasy(int position) {
        this.wizard_page_position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layout_id = R.layout.walkthrough_fragment_easy;
        View view = inflater.inflate(layout_id, container, false);

        String url3 = "https://s3.ca-central-1.amazonaws.com/grocr-albertyang/speedy-01.png";
        String url3Thumb = "https://s3.ca-central-1.amazonaws.com/grocr-albertyang/speedy-01.png";
        ImageView img3 = view.findViewById(R.id.imagePage3);
        loadImageRequest(img3, url3, url3Thumb);

        return view;
    }

    private void loadImageRequest(ImageView img, String url, String urlThumb) {
        DrawableRequestBuilder<String> thumbnailRequest = Glide
                .with(this)
                .load(urlThumb);

        Glide.with(this)
                .load(url)
//                .transform(new ImageViewCircleTransform(getActivity()))
//                .crossFade()
                .thumbnail(thumbnailRequest)
                .into(img);

    }
}
