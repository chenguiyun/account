package chen.com.myaccount;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import chen.com.myaccount.bean.Users;
import chen.com.myaccount.util.GreenDaoUtil;
import greendao.gen.DaoSession;
import greendao.gen.UsersDao;

public class Setpassword extends AppCompatActivity implements View.OnClickListener {
    private Button btn_set,btn_exit;
    private EditText oldpwd,newpwd,configpwd;

    private DaoSession session;

    private Users user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setpassword);
        bindviews();
        GreenDaoUtil util=new GreenDaoUtil(this,"account");
        session=util.session;
    }
    private void bindviews(){
        btn_set=(Button)findViewById(R.id.finish);
        btn_exit=(Button)findViewById(R.id.exit);
        btn_set.setOnClickListener(this);
        btn_exit.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.finish:
                oldpwd=(EditText)findViewById(R.id.oldpwd);
                newpwd=(EditText)findViewById(R.id.newpwd);
                configpwd=(EditText)findViewById(R.id.configpwd);
                if (oldpwd.getText().toString().equals("")){
                    Toast.makeText(this,"请输入旧密码",Toast.LENGTH_SHORT).show();
                    oldpwd.setText("");
                }
                else if (newpwd.getText().toString().equals("")){
                    Toast.makeText(this,"请输入新密码",Toast.LENGTH_SHORT).show();
                    oldpwd.setText("");
                    newpwd.setText("");
                }
                else if (configpwd.getText().toString().equals("")){
                    Toast.makeText(this,"请输入确认新密码",Toast.LENGTH_SHORT).show();
                    oldpwd.setText("");
                    newpwd.setText("");
                    configpwd.setText("");
                }
                else {
                    String oldpassword=oldpwd.getText().toString();
                    Users user = session.getUsersDao().queryBuilder()
                            .where(UsersDao.Properties.Password.eq(oldpassword)).unique();
                    String pwd=user.getPassword();
                    if (newpwd.getText().toString().equals(configpwd.getText().toString())){
                        if(oldpwd.getText().toString().equals(pwd)){
                            if(user != null){
                                user.setPassword(newpwd.getText().toString());
                            }
                            session.getUsersDao().update(user);
                            Toast.makeText(this,"密码修改成功",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(this,Home.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(this,"旧密码验证不对",Toast.LENGTH_SHORT).show();
                            oldpwd.setText("");
                            newpwd.setText("");
                            configpwd.setText("");
                        }
                    }
                    else{
                        Toast.makeText(this,"确认密码与新密码不匹配",Toast.LENGTH_SHORT).show();
                        oldpwd.setText("");
                        newpwd.setText("");
                        configpwd.setText("");
                    }
                }
                break;
            case R.id.exit:
                Intent intent=new Intent(this,Home.class);
                startActivity(intent);
                break;
        }

    }
}
