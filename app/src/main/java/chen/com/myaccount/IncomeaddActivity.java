package chen.com.myaccount;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import chen.com.myaccount.bean.Inaccount;
import chen.com.myaccount.bean.Outaccount;
import chen.com.myaccount.util.GreenDaoUtil;
import greendao.gen.DaoSession;

public class IncomeaddActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_incomeadd);
        final GreenDaoUtil util = new GreenDaoUtil(this, "account");
        btnadincome=(Button)findViewById(R.id.btnaddincome);
        btnadincome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                money=Double.valueOf(((TextView)findViewById(R.id.editinmoney)).getText().toString());
                date=((TextView)findViewById(R.id.editindate)).getText().toString();
                type=((TextView)findViewById(R.id.editintype)).getText().toString();
                handler=((TextView)findViewById(R.id.autoCompleteTextViewhandler)).getText().toString();
                mark=((TextView)findViewById(R.id.multiAutoCompleteTextViewinmark)).getText().toString();

                session = util.getSession();
                Inaccount inaccount= new Inaccount(money, date, type, handler, mark);
                long s=session.getInaccountDao().insert(inaccount);
                Intent intent=new Intent();
                intent.setClass(IncomeaddActivity.this,Home.class);
                startActivity(intent);
                if ((int)s>0)
                {
                    Toast.makeText(IncomeaddActivity.this,"添加成功",Toast.LENGTH_SHORT);
                }

            }
        });
    }
}
