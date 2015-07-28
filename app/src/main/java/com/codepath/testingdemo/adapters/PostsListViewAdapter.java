package com.codepath.testingdemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.codepath.testingdemo.R;
import com.codepath.testingdemo.models.Post;

import java.util.ArrayList;

public class PostsListViewAdapter extends ArrayAdapter<Post> {
    public PostsListViewAdapter(Context context, ArrayList<Post> posts) {
        super(context, 0, posts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Post post = getItem(position);

        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_item_post, parent, false);
            viewHolder.tvCaption = (TextView)convertView.findViewById(R.id.tvCaption);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        viewHolder.tvCaption.setText(post.userName + post.caption);

        return convertView;
    }

    private static class ViewHolder {
        TextView tvCaption;
    }
}