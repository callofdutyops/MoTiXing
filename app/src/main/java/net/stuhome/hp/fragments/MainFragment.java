package net.stuhome.hp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import net.stuhome.hp.motixing.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainFragment extends Fragment {
    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            map.put("icon", "1");
            map.put("content", "Todo some thing");
            map.put("time", "15:40pm");
            list.add(map);
        }
        String[] from = {"icon", "content", "time"};
        int[] to = {R.id.iv_icon, R.id.tv_content, R.id.tv_time};

        ListView todayListView = (ListView) view.findViewById(R.id.lv_today_todo);
        todayListView.setEmptyView(view.findViewById(R.id.tv_today_empty));
        ListView tomorrowListView = (ListView) view.findViewById(R.id.lv_tomorrow_todo);
        tomorrowListView.setEmptyView(view.findViewById(R.id.tv_tomorrow_empty));
        todayListView.setAdapter(new SimpleAdapter(getActivity(), list, R.layout.todo_item, from, to));
        tomorrowListView.setAdapter(new SimpleAdapter(getActivity(), list, R.layout.todo_item, from, to));
    }
}
