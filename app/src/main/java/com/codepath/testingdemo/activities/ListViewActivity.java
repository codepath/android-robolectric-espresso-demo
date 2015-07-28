package com.codepath.testingdemo.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.codepath.testingdemo.R;
import com.codepath.testingdemo.adapters.PostsListViewAdapter;
import com.codepath.testingdemo.data.Data;
import com.codepath.testingdemo.models.Post;

import java.util.ArrayList;

public class ListViewActivity extends GameLevelActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ArrayList<Post> posts = Data.POSTS;

        PostsListViewAdapter adapter = new PostsListViewAdapter(this, posts);
        ListView lvPosts = (ListView) findViewById(R.id.lvPosts);
        lvPosts.setAdapter(adapter);
        lvPosts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 2) {
                    launchLevelPassedActivity();
                }
            }
        });
    }
}
