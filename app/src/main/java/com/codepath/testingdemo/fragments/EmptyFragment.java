package com.codepath.testingdemo.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.codepath.testingdemo.R;

public class EmptyFragment extends Fragment {
    private static final String ARG_BACKGROUND_COLOR = "backgroundColor";
    private static final String ARG_IS_ANSWER_FRAGMENT = "isAnswerFragment";
    private int colorResourceId;
    private boolean isAnswerFragment;
    Button btnCompleteLevel;
    private OnAnswerClickedListener mListener;


    public static EmptyFragment newInstance(@IdRes int colorResourceId, boolean isAnswerFragment) {
        EmptyFragment fragment = new EmptyFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_BACKGROUND_COLOR, colorResourceId);
        args.putBoolean(ARG_IS_ANSWER_FRAGMENT, isAnswerFragment);
        fragment.setArguments(args);
        return fragment;
    }

    public EmptyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            colorResourceId = getArguments().getInt(ARG_BACKGROUND_COLOR);
            isAnswerFragment = getArguments().getBoolean(ARG_IS_ANSWER_FRAGMENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_empty, container, false);
        view.setBackgroundColor(this.colorResourceId);
        btnCompleteLevel = (Button)view.findViewById(R.id.btnCompleteLevel);
        btnCompleteLevel.setVisibility(isAnswerFragment ? View.VISIBLE : View.GONE);
        btnCompleteLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onAnswerClicked();
                }

            }
        });
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnAnswerClickedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnAnswerClickedListener {
        void onAnswerClicked();
    }
}
