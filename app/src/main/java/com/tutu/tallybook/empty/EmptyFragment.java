package com.tutu.tallybook.empty;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by tu on 2017/12/17.
 */

public class EmptyFragment extends Fragment {
    private static final String ARG_C = "content";

    public static EmptyFragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString(ARG_C, content);
        EmptyFragment fragment = new EmptyFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
