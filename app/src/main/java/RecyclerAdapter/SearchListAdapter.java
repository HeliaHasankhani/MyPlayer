package RecyclerAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.qhs.myplayer.MainActivity;
import com.example.qhs.myplayer.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import Model.Music;

public class SearchListAdapter extends BaseAdapter {
    // Declare Variables

    Context mContext;
    LayoutInflater inflater;
    private List<Music> musicNamesList = null;
    private ArrayList<Music> arraylist;

    public SearchListAdapter(Context context, List<Music> animalNamesList) {
        mContext = context;
        this.musicNamesList = animalNamesList;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<Music>();
        this.arraylist.addAll(animalNamesList);
    }

    public class ViewHolder {
        TextView name;
    }

    @Override
    public int getCount() {
        return musicNamesList.size();
    }

    @Override
    public Music getItem(int position) {
        return musicNamesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.list_row_search, null);
            holder.name = (TextView) view.findViewById(R.id.name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.name.setText(musicNamesList.get(position).getName());
        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        musicNamesList.clear();
        if (charText.length() == 0) {
            musicNamesList.addAll(arraylist);
        } else {
            for (Music wp : arraylist) {
                if (wp.getName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    musicNamesList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}
