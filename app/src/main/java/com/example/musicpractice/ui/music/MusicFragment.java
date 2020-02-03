package com.example.musicpractice.ui.music;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.musicpractice.R;

public class MusicFragment extends Fragment implements View.OnClickListener {

    private MusicViewModel musicViewModel;
    private static final String TAG = "MusicFragment";
    Button addMusicButton, confirmAddButton ;
    static int i = 1;
    LinearLayout getMusicLayout;
    private SearchView search;
//    private static final int NUM_PAGES = 4;
//    private ViewPager mPager;
//
//    /**
//     * The pager adapter, which provides the pages to the view pager widget.
//     */
//    private PagerAdapter pagerAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "Creating");

        musicViewModel =
                ViewModelProviders.of(this).get(MusicViewModel.class);


        View root = inflater.inflate(R.layout.fragment_music, container, false);





        addMusicButton = root.findViewById(R.id.addMusicButton);
        confirmAddButton = root.findViewById(R.id.confirmAddButton);


        search = root.findViewById(R.id.search);
        search.setQueryHint("SearchView Fragment");


        search.setVisibility(View.GONE);
        confirmAddButton.setVisibility(View.GONE);

        addMusicButton.setOnClickListener(this);
        confirmAddButton.setOnClickListener(this);
        getMusicLayout = root.findViewById(R.id.musicLayout);

//        ViewPager mViewPager = root.findViewById(R.id.pager);
//        mViewPager.setOffscreenPageLimit(4);

//        if (savedInstanceState == null) {
//            //Launch HomeFragment onStart...
//            Fragment fragment = new MusicFragment();
//            FragmentTransaction ft = getFragmentManager().beginTransaction();
//            ft.replace(R.id.linearLayoutId, fragment).commit();
//        }



        return root;
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.addMusicButton:
                Log.i(TAG, "addMusicButton clicked");
                confirmAddButton.setVisibility(View.VISIBLE);
                search.setVisibility(View.VISIBLE);
                addMusicButton.setVisibility(View.GONE);
                search.setQuery("", true);

                break;
            case R.id.confirmAddButton:
                if (!(search.getQuery().toString().trim().isEmpty())) {
                    Log.i(TAG, "confirmAddButton clicked");

                    search.setVisibility(View.GONE);
                    confirmAddButton.setVisibility(View.GONE);
                    addMusicButton.setVisibility(View.VISIBLE);

                    Button myButton = new Button(getActivity());
                    myButton.setText(search.getQuery());
                    myButton.setId(i);
                    i++;
                    getMusicLayout.addView(myButton);
                }

                break;
            // Do this for all buttons.
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }


    }
}