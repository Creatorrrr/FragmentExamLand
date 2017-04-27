package com.example.kosta.fragmentexamland;

import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by kosta on 2017-04-21.
 */

public class TitlesFragment extends ListFragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                ImageInfo.TITLES));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        DetailFragment df = (DetailFragment)getFragmentManager().findFragmentById(R.id.detail);

        if(df == null || df.getPosition() != position) {
            df = DetailFragment.newInstance(position);

            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.detail, df);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }
    }
}
