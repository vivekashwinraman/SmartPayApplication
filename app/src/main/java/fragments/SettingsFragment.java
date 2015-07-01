package fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.vraman.smartpay.MainActivity;
import com.example.vraman.smartpay.R;

import java.util.ArrayList;

import adapters.SettingsAdapter;
import modelObjects.SettingsObject;

/**
 * Created by vraman on 7/1/15.
 */
public class SettingsFragment extends android.support.v4.app.Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    private static final String ARG_ARRAYLIST = "data";

    private SettingsAdapter settingsAdapter;
    private ListView mainListView;

    private ArrayList<SettingsObject> settingsObjectList;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static SettingsFragment newInstance(int sectionNumber, ArrayList<SettingsObject> settingsObjectList) {
        SettingsFragment fragment = new SettingsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        args.putParcelableArrayList(ARG_ARRAYLIST, settingsObjectList);
        fragment.setArguments(args);
        return fragment;
    }

    public SettingsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);
        mainListView = (ListView) rootView.findViewById(R.id.main_list);

        settingsObjectList = getArguments().getParcelableArrayList(ARG_ARRAYLIST);
        settingsAdapter = new SettingsAdapter(this.getActivity(),
                R.layout.main_list_row, R.id.row_text, settingsObjectList);

        // Set the ArrayAdapter as the ListView's adapter.
        mainListView.setAdapter(settingsAdapter);
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }
}
