package adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.vraman.smartpay.R;

import java.util.ArrayList;
import java.util.List;

import modelObjects.SettingsObject;

/**
 * Created by vraman on 7/1/15.
 */
public class SettingsAdapter extends ArrayAdapter<SettingsObject> {

    private final List<SettingsObject> settingsObjectList;
    private TextView settingName;

    public SettingsAdapter(Context _context, int layout, int textView_id,
                              ArrayList<SettingsObject> list) {
        super(_context, layout, textView_id, list);
        settingsObjectList = list;
    }

    public static class ViewHolder {
        protected TextView settingName;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View superView = super.getView(position, convertView, parent);
        settingName = (TextView) superView.findViewById(R.id.row_text);
        settingName.setText(settingsObjectList.get(position).getSettingName());
        return superView;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return settingsObjectList.size();
    }

    @Override
    public SettingsObject getItem(int position) {
        // TODO Auto-generated method stub
        return settingsObjectList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    public List<SettingsObject> getSettingsObjectList() {
        return settingsObjectList;
    }
}
