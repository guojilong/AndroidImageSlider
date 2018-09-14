package com.daimajia.slider.demo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.slider.library.R;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

/**
 * This is a slider with a description TextView.
 */
public class MyTextSliderView extends BaseSliderView {
    private static final String TAG = MyTextSliderView.class.getSimpleName();

    public MyTextSliderView(Context context) {
        super(context);
    }

    @Override
    public View getView() {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.render_type_text, null);
        ImageView target = (ImageView) v.findViewById(R.id.daimajia_slider_image);
        TextView description = (TextView) v.findViewById(R.id.description);



        final BaseSliderView me = this;

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnSliderClickListener != null) {
                    mOnSliderClickListener.onSliderClick(me);
                }
            }
        });


        Picasso p = Picasso.with(mContext);
        RequestCreator rq = null;

        rq = p.load(getUrl());

        rq.into(target, new Callback() {
            @Override
            public void onSuccess() {


                Log.e(TAG, "load succ");
            }

            @Override
            public void onError() {
                Log.e(TAG, "load error");

            }
        });
        return v;
    }
}
