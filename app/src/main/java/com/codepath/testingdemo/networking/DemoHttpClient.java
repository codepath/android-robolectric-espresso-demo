package com.codepath.testingdemo.networking;

import android.os.AsyncTask;

import com.codepath.testingdemo.models.Post;

import java.util.List;

public class DemoHttpClient {

    public interface HttpResponseCallback {
        void onSuccess(List<Post> posts);
        void onFailure(int httpStatusCode);
    }

    public void getAsynchronously(String url, final HttpResponseCallback callback) {
        new AsyncTask<Void, Void, Void>() {
            protected Void doInBackground(Void... params) {
                try {
                    Thread.sleep(5000); // 5 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            protected void onPostExecute(Void result) {
                callback.onFailure(404); // Not Found
            }
        }.execute();
    }
}
