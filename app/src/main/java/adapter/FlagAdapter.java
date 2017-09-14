package adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import chen.com.myaccount.R;
import chen.com.myaccount.bean.Flag;

/**
 * Created by ios21 on 17/9/14.
 */

public class FlagAdapter extends BaseAdapter{
    private LayoutInflater layoutInflater;
    private List<Flag> list;

    public FlagAdapter(Context context, List<Flag> list) {
        this.layoutInflater = layoutInflater.from(context);
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if (convertView == null) {

            holder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.showinfo_flag, null);
            holder.flagid = (TextView) convertView.findViewById(R.id.flagid);
            holder.flaginfo = (TextView) convertView.findViewById(R.id.flaginfo);
            convertView.setTag(holder);


        } else {

            holder = (ViewHolder) convertView.getTag();

        }
        holder.flagid.setText((String) list.get(i).getId().toString());
        holder.flaginfo.setText((String) list.get(i).getFlag());


        return convertView;
    }
    class ViewHolder{
        public TextView flagid;

        public TextView flaginfo;
    }
}
