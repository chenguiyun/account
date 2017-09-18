package chen.com.myaccount;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import chen.com.myaccount.bean.Users;
import chen.com.myaccount.util.GreenDaoUtil;
import greendao.gen.DaoSession;

public class login extends AppCompatActivity implements View.OnClickListener{
    private Users user;
    private Button btn_login;
    private EditText edit_login;

    private DaoSession session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindviews();
        GreenDaoUtil util=new GreenDaoUtil(this,"account");
        session=util.session;
    }

    private void bindviews() {
        btn_login = (Button) findViewById(R.id.subBtn);
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.subBtn:
                edit_login = (EditText) findViewById(R.id.pwdEt);
                String password=edit_login.getText().toString();
                if (edit_login.getText().toString().equals("")) {
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                }
                else {
                    List<Users> userList = session.getUsersDao().loadAll();
                    user = userList.get(0);
                    String pwd=user.getPassword();
                    if (password.equals(pwd)){
                        Intent intent=new Intent(this,Home.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(this,"密码输入错误",Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
    }
}
