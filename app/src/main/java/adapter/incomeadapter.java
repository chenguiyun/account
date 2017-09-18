package adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import chen.com.myaccount.Home;
import chen.com.myaccount.R;
import chen.com.myaccount.bean.Inaccount;
import chen.com.myaccount.util.GreenDaoUtil;
import greendao.gen.DaoSession;

/**
 * Created by ios15 on 17/9/15.
 */

public class incomeadapter extends BaseAdapter {
    private Context context;
    public List<Inaccount> list=new ArrayList<Inaccount>();
    private DaoSession session;
    GreenDaoUtil util;

    public incomeadapter(Context context) {
        super();
        this.context=context;
        util=new GreenDaoUtil(context,"account");
    }
    public HashMap<Integer,Boolean> map=new HashMap<Integer,Boolean>();
    public HashMap<Integer,Boolean>maps(int id,boolean b)
    {
        if (id==999999) {
            for (int i = 0; i < getCount(); i++) {
                map.put(i, false);
            }
        }
        else {
            map.put(id, b);
        }
        return map;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    TextView tvincomemoney;
    TextView tvincometime;
    TextView tvincomeaddress;
    ImageButton imageButton;
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (map.size()==0) {
            map = maps(999999, false);
        }
        if(view==null){
            view=view.inflate(context, R.layout.activity_incomelist,null);
            tvincomemoney=(TextView)view.findViewById(R.id.tvincomemoney);
            tvincometime=(TextView)view.findViewById(R.id.tvincometime);
            tvincomeaddress=(TextView)view.findViewById(R.id.tvincomeaddress);
            imageButton=(ImageButton)view.findViewById(R.id.inimageButton);
        }
        tvincomemoney.setText(""+list.get(i).getMoney());
        tvincometime.setText(""+list.get(i).getTime());
        tvincomeaddress.setText(""+list.get(i).getHandler());
        String money=""+list.get(i).getMoney();
        if (map.get(i)==false) {
            imageButton.setVisibility(View.GONE);
        }
        else
        {
            imageButton.setVisibility(View.VISIBLE);
        }
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                new AlertDialog.Builder(context).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        session=util.getSession();
                        session.getInaccountDao().deleteByKey(list.get(i+1).getId());
                        Intent intent=new Intent();
                        intent.setClass((context),Home.class);
                        context.startActivity(intent);
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Fragment  o=(Fragment)view.getParent().getParent().getParent();
                        //o.getActivity();
                    }
                }).setTitle("确定删除？")
                        .setIcon(android.R.drawable.ic_menu_info_details)
                        .setMessage("删除后的数据无法恢复！")
                        .create().show();

            }
        });
        return view;
    }
}
