package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends android.app.Fragment implements View.OnClickListener {
    private Button jokeButton;
    private ProgressDialog progressDialog;
    EndpointsAsyncTask task = null;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        jokeButton = (Button) root.findViewById(R.id.tell_joke);
        jokeButton.setOnClickListener(this);
        if (task != null && task.getStatus() == AsyncTask.Status.RUNNING) {
            showProgressDialog();
        }

        return root;
    }

    //loading indicators for jokes
    public void showProgressDialog() {
        CharSequence loadingTitle =  getActivity().getResources().getString(R.string.loading_title);
        CharSequence loadingMessage =  getActivity().getResources().getString(R.string.loading_message);
        progressDialog = ProgressDialog.show(getActivity(),loadingTitle,loadingMessage);
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tell_joke) {
            fetchJoke();
            showProgressDialog();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }
    //asyncTask to fetch joke
    public void fetchJoke() {
        task = new EndpointsAsyncTask(this);
        task.execute();

    }


}







