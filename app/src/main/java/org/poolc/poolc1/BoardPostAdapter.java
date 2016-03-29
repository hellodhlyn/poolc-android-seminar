package org.poolc.poolc1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class BoardPostAdapter extends BaseAdapter {
    private Context context;
    private List<BoardPost> list;

    public BoardPostAdapter(Context context, List<BoardPost> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public BoardPost getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup group) {
        ViewHolder holder;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item_post, group, false);

            holder = new ViewHolder();
            holder.titleTextView = (TextView) view.findViewById(R.id.list_item_post_title);
            holder.metaTextView = (TextView) view.findViewById(R.id.list_item_post_meta);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.titleTextView.setText(getItem(position).getTitle());
        holder.metaTextView.setText(getItem(position).getWriter() + " | " + getItem(position).getTime());

        return view;
    }

    class ViewHolder {
        TextView titleTextView;
        TextView metaTextView;
    }
}
