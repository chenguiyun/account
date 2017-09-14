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
 * Created by ios21 on 17/9/13.
 */

public class AccountFlag extends Activity{

    private Button btnCancelFlag;//取消按钮
    private Button btnOkFlag;//确定按钮
    private EditText edflag;//文本编辑
    private DaoSession session;
    Intent intent= null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accountflag);
        GreenDaoUtil util=new GreenDaoUtil(this,"account");
        session=util.session;
        btnCancelFlag=(Button)findViewById(R.id.btnCancelFlag);
        btnOkFlag=(Button)findViewById(R.id.btnOkFlag);
        edflag=(EditText)findViewById(R.id.etFlag);

        /**
         *添加按钮
         */
        btnOkFlag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strFlag = edflag.getText().toString();
                if (strFlag.isEmpty()){
                    Toast.makeText(AccountFlag.this,"便签内容为空！",Toast.LENGTH_SHORT).show();
                    return;
                }
                long id= session.getFlagDao().insert(new Flag(strFlag));
                Toast.makeText(AccountFlag.this,id>0?"添加成功":"添加失败",Toast.LENGTH_SHORT).show();
                intent=new Intent(AccountFlag.this,ShowInfo.class);
                startActivity(intent);
            }
        });

        /**
         * 取消按钮
         */
        btnCancelFlag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             edflag.setText("");
            /**
             * 跳到添加页面
             */
            intent=new Intent(AccountFlag.this,ShowInfo.class);
            startActivity(intent);

            }
        });
    }
}
