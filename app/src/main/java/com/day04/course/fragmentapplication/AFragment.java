package com.day04.course.fragmentapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class AFragment extends Fragment {

    private static final String DATA = "data";
    private AListener listener;


    public static final AFragment newInstance(String label, AListener listener){
        AFragment fragment = new AFragment();
        fragment.setListener(listener);
        Bundle bundle = new Bundle();
        bundle.putString(DATA, label);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_a, container, false);
        TextView aText = rootView.findViewById(R.id.aText);
        Button changeTextInB = rootView.findViewById(R.id.changeTextInB);

        String label = getArguments().getString(DATA);
        aText.setText(label);


        changeTextInB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.showAndUpdateB("This is B");

            }
        });
        return rootView;

    }

    public void setListener(AListener listener) {
        this.listener = listener;
    }

    public interface AListener{
        void showAndUpdateB(String value);
    }

}
