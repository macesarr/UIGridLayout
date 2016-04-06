package course.examples.UI.GridLayout;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by macesarr on 06/04/16.
 */
public class GalleryAdapter extends BaseAdapter {
    private Context mContext;
    private List<Integer> mThumbIds;

    public List<Integer> getmThumbIds() {
        return mThumbIds;
    }

    public GalleryAdapter(Context c, List<Integer> ids) {
        mContext = c;
        mThumbIds = ids;
    }

    @Override
    public int getCount() {
        return mThumbIds.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return mThumbIds.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds.get(position));
        return imageView;
    }

    static class ViewHolder{
        ImageView imageView;
    }
}
