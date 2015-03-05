package geowear.de.geowear;

import android.content.Context;
import android.support.wearable.view.WearableListView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import geowear.de.geowear.domain.CacheItem;

public class CacheAdapter extends WearableListView.Adapter {


    private final LayoutInflater inflater;
    private ArrayList<CacheItem> cacheItems;

    public CacheAdapter(Context context, ArrayList<CacheItem> cacheItems) {
        this.cacheItems = cacheItems;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public WearableListView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ItemViewHolder(inflater.inflate(R.layout.cache_list_item, null));
    }

    @Override
    public void onBindViewHolder(WearableListView.ViewHolder viewHolder, int i) {
        ItemViewHolder vh = (ItemViewHolder) viewHolder;
        vh.nameTextView.setText(cacheItems.get(i).getName());
        vh.descriptionTextView.setText(cacheItems.get(i).getDescription());
        viewHolder.itemView.setTag(i);
    }

    @Override
    public int getItemCount() {
        return cacheItems.size();
    }

    class ItemViewHolder extends WearableListView.ViewHolder {

        public TextView nameTextView;
        public TextView descriptionTextView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.cache_name);
            descriptionTextView = (TextView) itemView.findViewById(R.id.cache_description);
        }
    }
}
