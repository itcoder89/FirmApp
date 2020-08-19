package adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.kodpartner.R;

import java.util.List;

import model.ServiceListForRateData;

/**
 * Created by sanjay on 15/1/18.
 */

public class CustomAdapter extends ArrayAdapter<ServiceListForRateData.DataBean> {

    Context context;
    List<ServiceListForRateData.DataBean> list;
    LayoutInflater inflater;
    int res;

    public CustomAdapter(Context context, List<ServiceListForRateData.DataBean> list, int resouceId) {
        super(context, resouceId, list);
        this.list = list;

    }

    @Override
    public int getCount() {
        int count = super.getCount();
        //return count > 0 ? count - 1 : count;
        return count;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        return getCustomview(position, convertView, parent);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        return getCustomview(position, convertView, parent);
    }


    public View getCustomview(int pos, View convertView, ViewGroup parent) {
        /********** Inflate spinner_rows.xml file for each row ( Defined below ) ************/
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.view_services_item_layout, null);
        TextView tvCategoryName = (TextView) row.findViewById(R.id.tvCategoryName);
        tvCategoryName.setText(list.get(pos).getName());

        return row;
    }

}
