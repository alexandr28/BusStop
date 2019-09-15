package com.acampdev.busstop;

import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class Salir extends Fragment {
    private static final long SPLASH_SCREEN_DELAY = 1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        rootView=inflater.inflate(R.layout.fragment_salir,container,false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SplashEnd();
    }

    private void  SplashEnd(){
        TimerTask task= new TimerTask() {
            @Override
            public void run() {
                Intent intent= new Intent(getContext(),SplashActivity.class);
                startActivity(intent);
                Objects.requireNonNull(getActivity()).finish();
            }
        };
        Timer timer=new Timer();
        timer.schedule(task,SPLASH_SCREEN_DELAY);
    }
}
