package chen.com.myaccount;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import chen.com.myaccount.bean.Outaccount;
import chen.com.myaccount.util.GreenDaoUtil;
import greendao.gen.DaoSession;
import greendao.gen.OutaccountDao;

public class OutcomeeditsActivity extends AppCompatActivity {
    private Button btnadoutcome;

    /*金额 时间 类型 地址 备注*/
    private double money;
    private String date;
    private String type;
    private String address;
    private String mark;

    private DaoSession session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outcomeedits);
        final GreenDaoUtil util = new GreenDaoUtil(this, "account");
        session=util.getSession();
        btnadoutcome=(Button)findViewById(R.id.btnaddoutcomes);
        Intent intent=getIntent();
        final Long id= Long.parseLong(intent.getStringExtra("id"));
        Outaccount o=session.getOutaccountDao().queryBuilder().where(OutaccountDao.Properties.Id.eq(id)).unique();
        ((TextView)findViewById(R.id.editTextmoneys)).setText(""+o.getMoney());
        ((TextView)findViewById(R.id.editTextdates)).setText(""+o.getTime());
        ((TextView)findViewById(R.id.editTexttypes)).setText(""+o.getType());
        ((TextView)findViewById(R.id.autoCompleteTextViewaddresss)).setText(""+o.getAddress());
        ((TextView)findViewById(R.id.multiAutoCompleteTextViewmarks)).setText(""+o.getMark());
        btnadoutcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                money=Double.valueOf(((TextView)findViewById(R.id.editTextmoneys)).getText().toString());
                date=((TextView)findViewById(R.id.editTextdates)).getText().toString();
                type=((TextView)findViewById(R.id.editTexttypes)).getText().toString();
                address=((TextView)findViewById(R.id.autoCompleteTextViewaddresss)).getText().toString();
                mark=((TextView)findViewById(R.id.multiAutoCompleteTextViewmarks)).getText().toString();

                session = util.getSession();
                Outaccount outaccount= new Outaccount(money, date, type, address, mark);
                outaccount.setId(id);
                session.getOutaccountDao().update(outaccount);
                Intent intent=new Intent();
                intent.setClass(OutcomeeditsActivity.this,Home.class);
                startActivity(intent);

            }
        });
    }
}
