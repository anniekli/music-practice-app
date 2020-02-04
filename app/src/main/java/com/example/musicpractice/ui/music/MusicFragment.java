package com.example.musicpractice.ui.music;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.musicpractice.R;

import java.util.ArrayList;
import java.util.Comparator;

public class MusicFragment extends Fragment implements View.OnClickListener {

    private MusicViewModel musicViewModel;
    private static final String TAG = "MusicFragment";
    Button addButton;
    private ListView musicList;
    private SearchView search;
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> listViewAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "Creating");

        musicViewModel =
                ViewModelProviders.of(this).get(MusicViewModel.class);


        View root = inflater.inflate(R.layout.fragment_music, container, false);



        addButton = root.findViewById(R.id.addButton);
        musicList = root.findViewById(R.id.listMode);

        search = root.findViewById(R.id.search_bar);


        addButton.setOnClickListener(this);
        arrayList = new ArrayList<>();

        listViewAdapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                arrayList);
        musicList.setAdapter(listViewAdapter);

        return root;
    }


    @Override
    public void onClick(View view) {
        if (!(search.getQuery().toString().trim().isEmpty())) {
            Log.i(TAG, "New button created: " + search.getQuery().toString());

            arrayList.add(search.getQuery().toString());
            musicList.setAdapter(listViewAdapter);
            musicList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    Log.i(TAG, "Item clicked: " + musicList.getItemAtPosition(position).toString());
                }
            });
            listViewAdapter.sort(new Comparator<String>() {
                @Override
                public int compare(String one, String two) {
                    return one.compareTo(two);
                }
            });
            search.setQuery("", true);
        }
    }
}