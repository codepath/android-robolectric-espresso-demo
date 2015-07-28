package com.codepath.testingdemo.data;

import com.codepath.testingdemo.models.Post;

import java.util.ArrayList;
import java.util.Arrays;

public class Data {
    public static final ArrayList<Post> POSTS = new ArrayList<>(Arrays.asList(
            new Post("Andre", "Yes!"),
            new Post("Klay", "We did it!!!"),
            new Post("Steph", "We Won!!!"),
            new Post("Lebron", "No comment"),
            new Post("Harrison", "Haha")
    ));
}
