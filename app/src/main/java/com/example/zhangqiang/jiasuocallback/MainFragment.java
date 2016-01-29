package com.example.zhangqiang.jiasuocallback;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangqiang on 16-1-29.
 */
public class MainFragment extends Fragment implements OnButtonListener{
    MainActivity mainActivity;
    ListView listView;
    View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity = (MainActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.main_fragment, container, false);
        listView = (ListView) view.findViewById(R.id.main_fragment_lv);
        initLv();
        return view;
    }

    private void initLv() {
        List<Map<String, Object>> list = getData();
        LvAdapter lvAdapter = new LvAdapter(mainActivity, list);
        lvAdapter.setOnButtonListener(this);
        listView.setAdapter(lvAdapter);
    }

    public List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 10; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", R.mipmap.ic_launcher);
            map.put("title", "这是一个标题" + i);
            map.put("info", "这是一个详细信息" + i);
            list.add(map);
        }
        return list;
    }

    @Override
    public void CallBack(int position) {
        Toast.makeText(mainActivity,position+"",Toast.LENGTH_SHORT).show();
    }
}
