package com.example.musicpractice.ui.music;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.musicpractice.MusicInfoFragment;
import com.example.musicpractice.R;

import java.util.ArrayList;
import java.util.Comparator;

public class MusicFragment extends Fragment implements View.OnClickListener {

    private MusicViewModel musicViewModel;
    private static final String TAG = "MusicFragment";
    Button addButton;
    private ListView musicList;
    private SearchView search;
    private ArrayList<String> musicArrayList;
    private ArrayAdapter<String> listViewAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "Creating");

        musicViewModel =
                ViewModelProviders.of(this).get(MusicViewModel.class);

        View root = inflater.inflate(R.layout.fragment_music, container, false);
        addButton = root.findViewById(R.id.addButton);
        musicList = root.findViewById(R.id.musicList);
        search = root.findViewById(R.id.search_bar);

        addButton.setOnClickListener(this);
        musicArrayList = new ArrayList<>();
        listViewAdapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                musicArrayList);

        musicList.setAdapter(listViewAdapter);
        return root;
    }


    @Override
    public void onClick(View view) {
        if (!(search.getQuery().toString().trim().isEmpty())) {
            Log.i(TAG, "New button created: " + search.getQuery().toString());

            // adds button to screen and list
            musicArrayList.add(search.getQuery().toString().trim());

            // creates new fragment
            Fragment newFragment = new MusicInfoFragment();
            Bundle args = new Bundle();
            args.putString("title", search.getQuery().toString());
            newFragment.setArguments(args);

            musicList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    Log.i(TAG, "Item clicked: " + musicList.getItemAtPosition(position).toString());
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.yay, newFragment, "newFragment");
                    ft.addToBackStack(null);
                    ft.commit();

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