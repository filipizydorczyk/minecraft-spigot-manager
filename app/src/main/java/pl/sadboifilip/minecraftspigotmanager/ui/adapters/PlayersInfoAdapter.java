package pl.sadboifilip.minecraftspigotmanager.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import pl.sadboifilip.minecraftspigotmanager.R;
import pl.sadboifilip.minecraftspigotmanager.data.models.PlayerInfo;

public class PlayersInfoAdapter extends ArrayAdapter<PlayerInfo> {

    private int mResource;

    public PlayersInfoAdapter(@NonNull Context context, int resource, @NonNull List<PlayerInfo> objects) {
        super(context, resource, objects);
        this.mResource = resource;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        final PlayerInfo player = getItem(position);

        final LayoutInflater inflater = LayoutInflater.from(this.getContext());
        convertView = inflater.inflate(mResource,parent,false);

        final TextView textView = convertView.findViewById(R.id.listitem_players__name);

        textView.setText(player.getName());
        return convertView;
    }
}
