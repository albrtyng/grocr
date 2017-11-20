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
public class WelcomeActivityFragmentWelcome extends Fragment {
    int wizard_page_position;

    public WelcomeActivityFragmentWelcome(int position) {
        this.wizard_page_position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layout_id = R.layout.walkthrough_fragment_welcome;
        View view = inflater.inflate(layout_id, container, false);

        String url = "https://s3.ca-central-1.amazonaws.com/grocr-albertyang/grocr_logo-01.png";
        String urlThumb = "https://s3.ca-central-1.amazonaws.com/grocr-albertyang/grocr_logo-01.png";
        ImageView img1 = view.findViewById(R.id.imagePage1);
        loadImageRequest(img1, url, urlThumb);

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
