package adapters;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.vraman.smartpay.R;

import modelObjects.AccountObject;

/**
 * Created by vraman on 5/29/15.
 */
public class AccountAdapter extends ArrayAdapter<AccountObject> {

    private final List<AccountObject> accountNames;
    private TextView accountName;

    public AccountAdapter(Context _context, int layout, int textView_id,
                            ArrayList<AccountObject> list) {
        super(_context, layout, textView_id, list);
        accountNames = list;
    }

    public static class ViewHolder {
        protected TextView accountName;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View superView = super.getView(position, convertView, parent);
        accountName = (TextView) superView.findViewById(R.id.row_text);
        accountName.setText(accountNames.get(position).getAccountName());
        return superView;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return accountNames.size();
    }

    @Override
    public AccountObject getItem(int position) {
        // TODO Auto-generated method stub
        return accountNames.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    public List<AccountObject> getAccountNames() {
        return accountNames;
    }
}
