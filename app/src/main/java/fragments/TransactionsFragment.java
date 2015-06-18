package fragments;

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
import adapters.TransactionAdapter;
import modelObjects.TransactionObject;

public class TransactionsFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    private static final String ARG_ARRAYLIST = "data";

    private TransactionAdapter transactionAdapter;
    private ListView mainListView;

    private ArrayList<TransactionObject> transactionObjectList;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static TransactionsFragment newInstance(int sectionNumber, ArrayList<TransactionObject> transactions) {
        TransactionsFragment fragment = new TransactionsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        args.putParcelableArrayList(ARG_ARRAYLIST, transactions);
        fragment.setArguments(args);
        return fragment;
    }

    public TransactionsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_transactions, container, false);
        mainListView = (ListView) rootView.findViewById(R.id.main_list);

        transactionObjectList = getArguments().getParcelableArrayList(ARG_ARRAYLIST);
        transactionAdapter = new TransactionAdapter(this.getActivity(),
                R.layout.main_list_row, R.id.row_text, transactionObjectList);

        // Set the ArrayAdapter as the ListView's adapter.
        mainListView.setAdapter(transactionAdapter);
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }

}
