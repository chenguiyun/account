package chen.com.myaccount;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.Inflater;

import chen.com.myaccount.OutComeActivity;
import chen.com.myaccount.bean.Outaccount;
import chen.com.myaccount.util.GreenDaoUtil;
import greendao.gen.DaoSession;

import  android.support.v4.content.ContextCompat.*;

/**
 * Created by ios19 on 2017/9/13.
 */

public class outadapter extends BaseAdapter {


    public static List<Outaccount> outaccountList;
    public Context context;
    private  LayoutInflater layoutInflater;
    public outadapter(Context context) {
        super();
        this.context=context;
        util=new GreenDaoUtil(context,"account");
    }
    private DaoSession session;
    GreenDaoUtil util;

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
    ImageButton imageButton;
    HashMap<Integer,Boolean>map=new HashMap<Integer,Boolean>();
    HashMap<Integer,Boolean>maps(int id,boolean b)
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (map.size()==0) {
            map = maps(999999, false);
        }

        if (view==null)
        {
            view = view.inflate(context,R.layout.outcomelayout,null);;
             tvmoney=(TextView)view.findViewById(R.id.outmoney);
             tvdate=(TextView)view.findViewById(R.id.outdate);
             tvadd=(TextView)view.findViewById(R.id.outaddress);
            imageButton=(ImageButton)view.findViewById(R.id.outimageButton);
        }
        String money=""+outaccountList.get(i).getMoney();
        tvmoney.setText(" "+money);
        tvdate.setText(" "+outaccountList.get(i).getTime());
        tvadd.setText(" "+outaccountList.get(i).getAddress());
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
                        session.getOutaccountDao().deleteByKey(outaccountList.get(i+1).getId());
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

