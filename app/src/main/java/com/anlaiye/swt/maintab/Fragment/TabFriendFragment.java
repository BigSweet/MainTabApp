package com.anlaiye.swt.maintab.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anlaiye.swt.maintab.R;

/**
 * 介绍：这里写介绍
 * 作者：sweet
 * 邮箱：sunwentao@imcoming.cn
 * 时间: 2017/3/7
 */

public class TabFriendFragment extends Fragment {


    public static TabFriendFragment newInstance() {
        
        Bundle args = new Bundle();
        
        TabFriendFragment fragment = new TabFriendFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.tab_friend, container, false);
        return view;

    }
}
