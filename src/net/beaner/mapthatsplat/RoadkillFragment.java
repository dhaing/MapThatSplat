package net.beaner.mapthatsplat;

import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.views.MapView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RoadkillFragment extends Fragment {
	private MapView map_;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_roadkill, container, false);

        map_ = (MapView)rootView.findViewById(R.id.mapview);
        map_.setTileSource(TileSourceFactory.MAPNIK);
        map_.setBuiltInZoomControls(true);
        map_.setMultiTouchControls(true);
        map_.
        
        return rootView;
    }

}
