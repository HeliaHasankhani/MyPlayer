package RecyclerAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.qhs.myplayer.DeleteDialogActivity;
import com.example.qhs.myplayer.MusicsActivity;
import com.example.qhs.myplayer.PlayListActivity;
import com.example.qhs.myplayer.R;
import com.example.qhs.myplayer.RecyclerActivity;
import com.example.qhs.myplayer.RenameDialogActivity;

import java.util.List;

import Data.SampleData;
import Model.Music;

/**
 * Created by QHS on 27/09/2018.
 */

public class PlayListAdapter extends RecyclerView.Adapter<PlayListAdapter.ViewHolder> {
    private Context context;
    private List<Music> listMusics;

    public  PlayListAdapter(RecyclerActivity context, List listmusic){
        this.context=context;
        this.listMusics=listmusic;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final SampleData db = new SampleData();
        Music music = listMusics.get(position);
        holder.name.setText(music.getName());
         holder.rename.setOnClickListener(new Button.OnClickListener() {

             @Override
             public void onClick(View view) {
                 Intent intent =new Intent(context,RenameDialogActivity.class);
                 context.startActivity(intent);
             }});
        holder.delete.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent =new Intent(context,DeleteDialogActivity.class);
                context.startActivity(intent);
            }});
    }

    @Override
    public int getItemCount() {
        return listMusics.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name;
        public Button rename;
        public Button delete;
        public ViewHolder(View musicView) {
            super(musicView);
            musicView.setOnClickListener(this);
            name = (TextView) musicView.findViewById(R.id.txtPlylistName);
            rename = (Button) musicView.findViewById(R.id.btnPlaylistRne);
            delete = (Button) musicView.findViewById(R.id.btnPlaylistDlt);
        }
        @Override
        public void onClick(View view) {

            Intent intent =new Intent(context,PlayListActivity.class);
            context.startActivity(intent);

        }
    }
}
