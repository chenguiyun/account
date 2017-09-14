package chen.com.myaccount;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import adapter.FlagAdapter;
import chen.com.myaccount.bean.Flag;
import chen.com.myaccount.util.GreenDaoUtil;
import greendao.gen.DaoSession;

/**
 * Created by ios21 on 17/9/13.
 */

public class ShowInfo extends Activity{

    private Button btnAddFlag;//新增便签按钮
    private ListView lvinfo;
    private DaoSession session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showinfo);

        GreenDaoUtil util=new GreenDaoUtil(this,"account");
        session=util.session;

        final List<Flag> flagList=session.getFlagDao().queryBuilder().list();
        /**
         * 显示所有便签信息
         */
        lvinfo=findViewById(R.id.lvinfo);
        lvinfo.setAdapter(new FlagAdapter(ShowInfo.this,flagList));

        /**
         * 点击显示某一条便签信息
         */
        lvinfo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ShowInfo.this,FlagManage.class);
                TextView textView=view.findViewById(R.id.flagid);
                Long strid=Long.parseLong(textView.getText().toString());
                Bundle bundle =new Bundle();
                bundle.putLong("flagid",strid);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        /**
         * 跳到添加页面
         */
        btnAddFlag =(Button)findViewById(R.id.btnAddFlag);
        btnAddFlag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= null;
                intent=new Intent(ShowInfo.this,AccountFlag.class);
                startActivity(intent);
            }
        });
    }
}
