package com.vuforia.samples.VuforiaSamples.app.ImageTargets;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import com.vuforia.samples.VuforiaSamples.R;

public class ImageAdapter extends BaseAdapter
{
    private Context mContext;

    public ImageAdapter(Context c)
    {
        mContext = c;
    }

    public int getCount()
    {
        return mThumbIds.length;
    }

    public Object getItem(int position)
    {
        return null;
    }

    public long getItemId(int position)
    {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ImageView imageView;
        if (convertView == null)
        {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(1694, 1175));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        }
        else
        {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    private Integer[] mThumbIds =
            {
                    R.drawable.h1, R.drawable.h2,
                    R.drawable.h3, R.drawable.h4,
                    R.drawable.h5, R.drawable.h6,
                    R.drawable.h7, R.drawable.h8,
                    R.drawable.h9
            };
}
