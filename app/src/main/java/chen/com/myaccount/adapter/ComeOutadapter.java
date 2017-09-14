package chen.com.myaccount.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import chen.com.myaccount.R;
import chen.com.myaccount.bean.Outaccount;

public class ComeOutadapter extends BaseAdapter {

    private List<Outaccount> outaccountList;
    private Context context;
    private LayoutInflater layoutInflater;

    public ComeOutadapter(Context context, List<Outaccount> outaccountList) {
        this.outaccountList = outaccountList;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return outaccountList.size();
    }

    @Override
    public Object getItem(int i) {
        return outaccountList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        OutItems outItem;
        if (view == null) {
            outItem = new OutItems();
            view = layoutInflater.inflate(R.layout.out_item, null);
            outItem.delbtn = view.findViewById(R.id.delbtn);
            outItem.money = view.findViewById(R.id.money);
            outItem.time = view.findViewById(R.id.times);
            outItem.type = view.findViewById(R.id.type);
            view.setTag(outItem);
        } else {
            outItem = (OutItems) view.getTag();
        }
        final Outaccount outaccount = outaccountList.get(i);
        outItem.money.setText(outaccount.getMoney() + "");
        outItem.type.setText(outaccount.getType());
        outItem.time.setText(outaccount.getTime());
        outItem.type.setHint("" + outaccount.getId());
        outItem.delbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("delete", "onClick: " + outaccount.getId());
                new AlertDialog.Builder(context).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).setTitle("确定删除？")
                        .setIcon(android.R.drawable.ic_menu_info_details)
                        .setMessage("删除后的数据无法恢复！")
                        .create().show();

            }
        });
        return view;
    }

    class OutItems {
        public ImageButton delbtn;
        public TextView money, time, type;
    }
}

