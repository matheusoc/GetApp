package br.com.getapp.structure.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.getapp.R;
import br.com.getapp.structure.view.EditAlarmActivity;
import br.com.getapp.structure.view.adapter.AlarmAdapter;

/**
 * Created by User on 21/04/2016.
 */
public class ListFragment extends Fragment {

    private  static Context context;
    private  static RecyclerView list;
    public static ListFragment newInstance(){
        ListFragment fragment = new ListFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity().getApplicationContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.listview_layout, container, false);
        list = (RecyclerView) v.findViewById(R.id.list);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        list.setLayoutManager(llm);

        list.setAdapter(new AlarmAdapter(context));
        return v;
    }

    public static void refresh(){
        list.setAdapter(new AlarmAdapter(context));
    }
}
