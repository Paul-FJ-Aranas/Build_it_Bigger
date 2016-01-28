package com.udacity.gradle.builditbigger;


import android.test.ActivityInstrumentationTestCase2;
import android.text.TextUtils;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by Paul Aranas on 1/16/2016.
 */

public class AsyncTaskAndroidTest extends ActivityInstrumentationTestCase2<MainActivity> {

    EndpointsAsyncTask task;
    MainActivity activity;
    MainActivityFragment fragment;


    public AsyncTaskAndroidTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
        fragment = new MainActivityFragment();
        task = new EndpointsAsyncTask() {
            @Override
            protected void onPostExecute(String joke) {
            }
        };
    }


    public void testAsyncTaskReturnValueIsNotEmpty() throws Throwable {


        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                String result = null;
                try {
                    result = task.execute().get(30, TimeUnit.SECONDS);
                } catch (InterruptedException | ExecutionException | TimeoutException e) {
                    e.printStackTrace();
                }
                assertFalse(TextUtils.isEmpty(result));
            }
        });
    }


}




