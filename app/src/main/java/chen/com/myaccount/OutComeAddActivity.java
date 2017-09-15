package chen.com.myaccount;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import chen.com.myaccount.bean.Outaccount;
import chen.com.myaccount.util.GreenDaoUtil;
import greendao.gen.DaoSession;

public class OutComeAddActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_out_come_add);
        final GreenDaoUtil util = new GreenDaoUtil(this, "account");
        btnadoutcome=(Button)findViewById(R.id.btnaddoutcome);
        btnadoutcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                money=Double.valueOf(((TextView)findViewById(R.id.editTextmoney)).getText().toString());
                date=((TextView)findViewById(R.id.editTextdate)).getText().toString();
                type=((TextView)findViewById(R.id.editTexttype)).getText().toString();
                address=((TextView)findViewById(R.id.autoCompleteTextViewaddress)).getText().toString();
                mark=((TextView)findViewById(R.id.multiAutoCompleteTextViewmark)).getText().toString();

                session = util.getSession();
                Outaccount outaccount= new Outaccount(money, date, type, address, mark);
                long s=session.getOutaccountDao().insert(outaccount);
                Intent intent=new Intent();
                intent.setClass(OutComeAddActivity.this,Home.class);
                startActivity(intent);
                if ((int)s>0)
                {
                    Toast.makeText(OutComeAddActivity.this,"添加成功",Toast.LENGTH_SHORT);
                }

            }
        });
    }
}
