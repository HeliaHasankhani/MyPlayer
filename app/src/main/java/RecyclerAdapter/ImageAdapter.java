package RecyclerAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.qhs.myplayer.R;

public class ImageAdapter extends BaseAdapter {
    private Context context;
    private int categoryID;
    private Integer[] imageIds;

    public ImageAdapter(Context c, int id){
        context = c;
        categoryID = id;

        switch (categoryID){
            case 0:
                imageIds = imageRelaxation;
                break;
            case 1:
                imageIds = imageStudy;
                break;
            case 2:
                imageIds = imageRaining;
                break;
            case 3:
                imageIds = imageOut;
                break;
            case 4:
                imageIds = imageLove;
                break;
            case 5:
                imageIds = imageSleep;
                break;
            case 6:
                imageIds = imageKids;
                break;
            case 7:
                imageIds = imageExercise;
                break;
        }
    }

    @Override
    public int getCount() {
        return imageIds.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(150, 150));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(10, 10, 10, 10);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(imageIds[position]);
        return imageView;
    }

    private Integer[] imageRelaxation = {
            R.drawable.photo_1, R.drawable.photo_2,
            R.drawable.photo_3, R.drawable.photo_4,
            R.drawable.photo_5, R.drawable.photo_6
    };

    private Integer[] imageStudy = {
            R.drawable.photo_7, R.drawable.photo_8,
            R.drawable.photo_1, R.drawable.photo_2,
            R.drawable.photo_3, R.drawable.photo_4,
            R.drawable.photo_5, R.drawable.photo_6,
            R.drawable.photo_7
    };

    private Integer[] imageLove = {
            R.drawable.photo_8, R.drawable.photo_1, R.drawable.photo_2,
            R.drawable.photo_3, R.drawable.photo_4,
            R.drawable.photo_5, R.drawable.photo_6,
            R.drawable.photo_7, R.drawable.photo_8,
            R.drawable.photo_1, R.drawable.photo_2,
            R.drawable.photo_3, R.drawable.photo_4,
            R.drawable.photo_5, R.drawable.photo_6,
            R.drawable.photo_7
    };

    private Integer[] imageRaining = {
            R.drawable.photo_2,
            R.drawable.photo_3, R.drawable.photo_4,
            R.drawable.photo_5, R.drawable.photo_6,
            R.drawable.photo_7, R.drawable.photo_8,
            R.drawable.photo_1, R.drawable.photo_2,
            R.drawable.photo_3, R.drawable.photo_4,
            R.drawable.photo_5, R.drawable.photo_6,
            R.drawable.photo_7
    };

    private Integer[] imageOut = {
            R.drawable.photo_3, R.drawable.photo_4,
            R.drawable.photo_5, R.drawable.photo_6,
            R.drawable.photo_7, R.drawable.photo_8,
            R.drawable.photo_1, R.drawable.photo_2,
            R.drawable.photo_3, R.drawable.photo_4,
            R.drawable.photo_5, R.drawable.photo_6,
            R.drawable.photo_7
    };

    private Integer[] imageSleep = {
            R.drawable.photo_4,
            R.drawable.photo_5, R.drawable.photo_6,
            R.drawable.photo_7, R.drawable.photo_8,
            R.drawable.photo_1, R.drawable.photo_2,
            R.drawable.photo_3, R.drawable.photo_4,
            R.drawable.photo_5, R.drawable.photo_6
    };
    private Integer[] imageKids = {
            R.drawable.photo_5, R.drawable.photo_6,
            R.drawable.photo_7, R.drawable.photo_8,
            R.drawable.photo_1, R.drawable.photo_2,
            R.drawable.photo_3, R.drawable.photo_4,
            R.drawable.photo_5
    };
    private Integer[] imageExercise = {
            R.drawable.photo_6,
            R.drawable.photo_7, R.drawable.photo_8,
            R.drawable.photo_1, R.drawable.photo_2,
            R.drawable.photo_3, R.drawable.photo_4
    };

}
