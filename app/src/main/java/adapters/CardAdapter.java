package adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.vraman.smartpay.R;

import java.util.ArrayList;
import java.util.List;

import modelObjects.CardObject;

/**
 * Created by vraman on 5/29/15.
 */
public class CardAdapter extends ArrayAdapter<CardObject> {

    private final List<CardObject> cards;
    private TextView cardName;

    public CardAdapter(Context _context, int layout, int textView_id,
                       ArrayList<CardObject> list) {
        super(_context, layout, textView_id, list);
        cards = list;
    }

    public static class ViewHolder {
        protected TextView accountName;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View superView = super.getView(position, convertView, parent);
        cardName = (TextView) superView.findViewById(R.id.row_text);
        cardName.setText(cards.get(position).getCardName());
        return superView;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return cards.size();
    }

    @Override
    public CardObject getItem(int position) {
        // TODO Auto-generated method stub
        return cards.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    public List<CardObject> getCards() {
        return cards;
    }
}
