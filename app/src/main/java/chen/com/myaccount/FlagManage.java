package chen.com.myaccount;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import chen.com.myaccount.bean.Flag;
import chen.com.myaccount.util.GreenDaoUtil;
import greendao.gen.DaoSession;
import greendao.gen.FlagDao;

/**
 * Created by ios21 on 17/9/14.
 */

public class FlagManage extends Activity{

    private EditText edAFlag;
    private Button btnupFlag,btndelFlag;
    Long strid; //便签id
    private DaoSession session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flagmanage);

        edAFlag=(EditText)findViewById(R.id.edAflag);
        btndelFlag=(Button)findViewById(R.id.btndelFlag);
        btnupFlag=(Button)findViewById(R.id.btnupFlag);

        /**
         *获取便签id
         * 显示便签信息
         */
        Intent intent=getIntent();
        Bundle bundle= intent.getExtras();
        strid=bundle.getLong("flagid");

        GreenDaoUtil util=new GreenDaoUtil(this,"account");
        session=util.session;

        edAFlag.setText(session.getFlagDao().queryBuilder().where(FlagDao.Properties.Id.eq(strid)).unique().getFlag());
        /**
         * 修改便签信息
         */
        btnupFlag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Flag flag=new Flag();
                flag.setId(strid);
                flag.setFlag(edAFlag.getText().toString());
                session.getFlagDao().update(flag);
                Toast.makeText(FlagManage.this,"修改成功",Toast.LENGTH_SHORT).show();
                Intent intent= null;
                intent=new Intent(FlagManage.this,Home.class);
                startActivity(intent);
            }
        });

        /**
         * 删除便签信息
         */
        btndelFlag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                session.getFlagDao().deleteByKey(strid);
                Toast.makeText(FlagManage.this,"删除成功！",Toast.LENGTH_SHORT).show();
                Intent intent= null;
                intent=new Intent(FlagManage.this,Home.class);
                startActivity(intent);
            }
        });

    }
}
