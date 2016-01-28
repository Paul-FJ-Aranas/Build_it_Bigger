package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends android.app.Fragment implements View.OnClickListener {
    private Button jokeButton;
    private ProgressDialog progressDialog;
    EndpointsAsyncTask task = null;
    InterstitialAd mInterstatialAd;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);


        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        jokeButton = (Button) root.findViewById(R.id.tell_joke);
        jokeButton.setOnClickListener(this);
        if (task != null && task.getStatus() == AsyncTask.Status.RUNNING) {
            showProgressDialog();
        }
        mInterstatialAd = new InterstitialAd(getActivity());
        mInterstatialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        requestNewInterstitial();
        mInterstatialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                fetchJoke();
                showProgressDialog();

            }
        });
        return root;
    }

    //Loading indicator for jokes
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
            if (mInterstatialAd.isLoaded()) {
                mInterstatialAd.show();
            } else {
                fetchJoke();
                showProgressDialog();
            }

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

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mInterstatialAd.loadAd(adRequest);
    }

}







