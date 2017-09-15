package com.day04.course.fragmentapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BFragment extends Fragment {

    public static BFragment newInstance(String messageNew) {

        Bundle args = new Bundle();

        args.putString("messageNew", messageNew);
        BFragment fragment = new BFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_b, container, false);

        String message = getArguments().getString("messageNew");

        TextView bTextView = rootView.findViewById(R.id.bTextView);
        bTextView.setText(message);
        return rootView;
    }

}
