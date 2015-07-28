package com.codepath.testingdemo.helpers;

import android.support.test.espresso.contrib.CountingIdlingResource;

import com.codepath.testingdemo.activities.CustomNetworkRequestActivity;

// Wrapper around CustomHttpClient that uses CountingIdlingResource to let Espresso know
// when it is idle
public class DecoratedCustomHttpClient implements CustomNetworkRequestActivity.CustomHttpClient {
    private final CustomNetworkRequestActivity.CustomHttpClient customHttpClient;
    private final CountingIdlingResource customHttpClientIdlingResource;

    public DecoratedCustomHttpClient(CustomNetworkRequestActivity.CustomHttpClient customHttpClient,
                                     CountingIdlingResource customHttpClientIdlingResource) {
        this.customHttpClient = customHttpClient;
        this.customHttpClientIdlingResource = customHttpClientIdlingResource;
    }

    @Override
    public void makeRequest() {
        // Use CountingIdlingResource to track in-flight network requests.
        // Whenever the count goes to zero, Espresso will be notified that this resource is idle
        // and the test will be able to proceed.
        customHttpClientIdlingResource.increment();
        try {
            customHttpClient.makeRequest();
        } finally {
            customHttpClientIdlingResource.decrement();
        }
    }
}
