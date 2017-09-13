package chen.com.myaccount;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import chen.com.myaccount.OutComeActivity;

/**
 * Created by ios19 on 2017/9/13.
 */

public class outadapter extends BaseAdapter {

    public List<OutComeActivity.tb_outaccount> outaccountList;
    public Context context;
    private  LayoutInflater layoutInflater;
    public outadapter(Context context) {
        super();
        this.context=context;
    }

    @Override
    public int getCount() {
        return outaccountList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    TextView tvmoney;
    TextView tvdate;
    TextView tvadd;
    CheckBox checkBox;
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view==null)
        {
            view = view.inflate(context,R.layout.outcomelayout,null);;
             tvmoney=(TextView)view.findViewById(R.id.outmoney);
             tvdate=(TextView)view.findViewById(R.id.outdate);
             tvadd=(TextView)view.findViewById(R.id.outaddress);
            checkBox=(CheckBox)view.findViewById(R.id.outcheckbox);
        }
        String money=""+outaccountList.get(i).getMoney();
        tvmoney.setText(" "+money);
        tvdate.setText(" "+outaccountList.get(i).getTime());
        tvadd.setText(" "+outaccountList.get(i).getAddress());
        checkBox.setChecked(false);
        checkBox.setVisibility(View.GONE);
        return view;
    }

}

