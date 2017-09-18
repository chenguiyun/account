package chen.com.myaccount;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import chen.com.myaccount.bean.Inaccount;
import chen.com.myaccount.bean.Outaccount;
import chen.com.myaccount.util.GreenDaoUtil;
import greendao.gen.DaoSession;
import greendao.gen.InaccountDao;
import greendao.gen.OutaccountDao;

public class IncomeeditActivity extends AppCompatActivity {

    private double money;
    private String date;
    private String type;
    private String handler;
    private String mark;

    private Button btnadincome;
    private DaoSession session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incomeedit);
        final GreenDaoUtil util = new GreenDaoUtil(this, "account");
        session=util.getSession();
        btnadincome=(Button)findViewById(R.id.btnaddincomes);
        Intent intent=getIntent();
        final Long id= Long.parseLong(intent.getStringExtra("id"));
        Inaccount o=session.getInaccountDao().queryBuilder().where(InaccountDao.Properties.Id.eq(id)).unique();
        ((TextView)findViewById(R.id.editinmoneys)).setText(""+o.getMoney());
        ((TextView)findViewById(R.id.editindates)).setText(""+o.getTime());
        ((TextView)findViewById(R.id.editintypes)).setText(""+o.getType());
        ((TextView)findViewById(R.id.autoCompleteTextViewhandlers)).setText(""+o.getHandler());
        ((TextView)findViewById(R.id.multiAutoCompleteTextViewinmarks)).setText(""+o.getMark());
        btnadincome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                money=Double.valueOf(((TextView)findViewById(R.id.editinmoneys)).getText().toString());
                date=((TextView)findViewById(R.id.editindates)).getText().toString();
                type=((TextView)findViewById(R.id.editintypes)).getText().toString();
                handler=((TextView)findViewById(R.id.autoCompleteTextViewhandlers)).getText().toString();
                mark=((TextView)findViewById(R.id.multiAutoCompleteTextViewinmarks)).getText().toString();

                session = util.getSession();
                Inaccount inaccount= new Inaccount(money, date, type, handler, mark);
                inaccount.setId(id);
                session.getInaccountDao().update(inaccount);
                Intent intent=new Intent();
                intent.setClass(IncomeeditActivity.this,Home.class);
                startActivity(intent);

            }
        });
    }
}
