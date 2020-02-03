package com.example.musicpractice.ui.music;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.musicpractice.R;

public class MusicFragment extends Fragment implements View.OnClickListener {

    private MusicViewModel musicViewModel;
    private static final String TAG = "MusicFragment";
    Button addButton;
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





        addButton = root.findViewById(R.id.addButton);

        search = root.findViewById(R.id.search_bar);
        search.setQueryHint("SearchView Fragment");


        addButton .setOnClickListener(this);
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
        if (!(search.getQuery().toString().trim().isEmpty())) {
            Log.i(TAG, "addMusicButton clicked");

            Button myButton = new Button(getActivity());
            Log.i(TAG, "New button created: " + search.getQuery().toString());
            myButton.setTransformationMethod(null);
            myButton.setText(search.getQuery().toString());
            myButton.setGravity(Gravity.START);
            myButton.setGravity(Gravity.CENTER_VERTICAL);
            myButton.setId(i);
            i++;
            getMusicLayout.addView(myButton);
            search.setQuery("", true);
        }
    }
}