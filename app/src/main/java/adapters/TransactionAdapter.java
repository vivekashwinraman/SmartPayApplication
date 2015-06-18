package adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.vraman.smartpay.R;

import java.util.ArrayList;
import java.util.List;

import modelObjects.TransactionObject;

/**
 * Created by vraman on 6/2/15.
 */
public class TransactionAdapter extends ArrayAdapter<TransactionObject> {

    private final List<TransactionObject> transactions;
    private TextView transactionName;

    public TransactionAdapter(Context _context, int layout, int textView_id,
                          ArrayList<TransactionObject> list) {
        super(_context, layout, textView_id, list);
        transactions = list;
    }

    public static class ViewHolder {
        protected TextView transactionName;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View superView = super.getView(position, convertView, parent);
        transactionName = (TextView) superView.findViewById(R.id.row_text);
        transactionName.setText(transactions.get(position).getTransactionName());
        return superView;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return transactions.size();
    }

    @Override
    public TransactionObject getItem(int position) {
        // TODO Auto-generated method stub
        return transactions.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    public List<TransactionObject> getTransactions() {
        return transactions;
    }
}

