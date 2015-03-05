package geowear.de.geowear;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.support.wearable.view.WearableListView;

import java.util.ArrayList;

import geowear.de.geowear.domain.CacheItem;
import geowear.de.geowear.domain.Position;

public class MainActivity extends Activity implements WearableListView.ClickListener {


    private ArrayList<CacheItem> cachesItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cache_list);

        cachesItems = new ArrayList<>();

        cachesItems.add(new CacheItem("SolutionSpace", "0m", new Position("3478", "3478")));
        cachesItems.add(new CacheItem("Kölner Dom", "220m", new Position("3478", "3478")));
        cachesItems.add(new CacheItem("Hohe Straße", "400m", new Position("3478", "3478")));
        cachesItems.add(new CacheItem("Hohenzollern Brücke", "1300m", new Position("3478", "3478")));
        cachesItems.add(new CacheItem("Rheinufer", "2040m", new Position("3478", "3478")));
        cachesItems.add(new CacheItem("St. Martin Kirche", "4000m", new Position("3478", "3478")));
        cachesItems.add(new CacheItem("Eduardus Krankenhaus", "5040m", new Position("3478", "3478")));
        cachesItems.add(new CacheItem("Humboldpark", "8000m", new Position("3478", "3478")));

        final CacheAdapter adapter = new CacheAdapter(this, cachesItems);

        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                WearableListView lv = (WearableListView) findViewById(R.id.cache_list);
                lv.setClickListener(MainActivity.this);
                lv.setAdapter(adapter);
            }
        });
    }

    @Override
    public void onClick(WearableListView.ViewHolder v) {
        int position = (int) v.itemView.getTag();
        CacheItem cacheItem = cachesItems.get(position);
        Intent intent = new Intent(this, CacheDetailView.class);
        intent.putExtra("name", cacheItem.getName());
        intent.putExtra("description", cacheItem.getName());
        this.startActivity(intent);
    }

    @Override
    public void onTopEmptyRegionClick() {

    }
}
