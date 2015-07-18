package fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.vraman.smartpay.MainActivity;
import com.example.vraman.smartpay.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddPayFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AddPayFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 *
 */
public class AddPayFragment extends android.support.v4.app.Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private static final String ARG_SECTION_NUMBER = "section_number";


    private OnFragmentInteractionListener mListener;

    private Button addPayMain;
    private RelativeLayout addMoneyLayout;
    private RelativeLayout addMoneyOverlayLayout;
    private EditText enterAmount;
    private TextView totalAmount;
    private TextView balance;
    private Button clear;
    private Button add;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param sectionNumber Parameter 1.
     * @return A new instance of fragment SettingsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddPayFragment newInstance(int sectionNumber) {
        AddPayFragment fragment = new AddPayFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public AddPayFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_addpay, container, false);
        addMoneyLayout = (RelativeLayout) layout.findViewById(R.id.add_money_layout);
        addMoneyOverlayLayout = (RelativeLayout) layout.findViewById(R.id.add_money_overlay);
        addPayMain = (Button) layout.findViewById(R.id.addMoney);
        enterAmount = (EditText) layout.findViewById(R.id.money_amount);
        addPayMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMoneyLayout.setVisibility(View.GONE);
                addMoneyOverlayLayout.setVisibility(View.VISIBLE);
            }
        });

        enterAmount.addTextChangedListener(amountWatcher);
        totalAmount = (TextView) layout.findViewById(R.id.total_money);
        balance = (TextView) layout.findViewById(R.id.balanceAmount);

       clear = (Button) layout.findViewById(R.id.cancel);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterAmount.setText("");
                totalAmount.setText("");
            }
        });

        add = (Button) layout.findViewById(R.id.add_done);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMoneyLayout.setVisibility(View.VISIBLE);
                addMoneyOverlayLayout.setVisibility(View.GONE);
                enterAmount.setText("");
                totalAmount.setText("");
                try {
                    double remBalance = Double.parseDouble(balance.getText().toString().substring(1));
                    double balanceNew = remBalance + Double.parseDouble(totalAmount.getText().toString().substring(1));
                    Log.d("HERE: ", remBalance +" "+balanceNew);
                    balance.setText("$" + balanceNew);
                } catch(NumberFormatException e){

                }
            }
        });



        return layout;
    }


    private final TextWatcher amountWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        public void afterTextChanged(Editable s) {
            if (s.length() == 0) {
                totalAmount.setText(""+0.0);
            } else{
                double total = 0.0;
                try {

                    double  fee = (Double.parseDouble(enterAmount.getText().toString())) * (0.029);
                    total += fee;
                } catch(NumberFormatException e){

                }
                totalAmount.setText("$"+total);
            }
        }
    };


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
