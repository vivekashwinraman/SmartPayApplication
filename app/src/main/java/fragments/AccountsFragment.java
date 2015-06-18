package fragments;

/**
 * Created by vraman on 5/29/15.
 */

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.vraman.smartpay.MainActivity;
import com.example.vraman.smartpay.R;

import java.util.ArrayList;

import adapters.AccountAdapter;
import modelObjects.AccountObject;

/**
 * A placeholder fragment containing a simple view.
 */
public class AccountsFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    private static final String ARG_ARRAYLIST = "data";

    private AccountAdapter accountAdapter;
    private ListView mainListView;

    private ArrayList<AccountObject> accountObjectList;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static AccountsFragment newInstance(int sectionNumber, ArrayList<AccountObject> accountNames) {
        AccountsFragment fragment = new AccountsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        args.putParcelableArrayList(ARG_ARRAYLIST, accountNames);
        fragment.setArguments(args);
        return fragment;
    }

    public AccountsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mainListView = (ListView) rootView.findViewById(R.id.main_list);

        accountObjectList = getArguments().getParcelableArrayList(ARG_ARRAYLIST);
        accountAdapter = new AccountAdapter(this.getActivity(),
                R.layout.main_list_row, R.id.row_text, accountObjectList);

        // Set the ArrayAdapter as the ListView's adapter.
        mainListView.setAdapter(accountAdapter);
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }
}