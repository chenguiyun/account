package chen.com.myaccount;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import chen.com.myaccount.bean.Users;
import chen.com.myaccount.util.GreenDaoUtil;
import greendao.gen.DaoSession;
import greendao.gen.UsersDao;


public class MainActivity extends Activity implements View.OnClickListener {

    private Button btnAdd,btnDel,btnQuery,btnUpdate;
    private TextView tvMsg;
    /**
     * 与greendao数据操作相关的几个类
     */
    private DaoSession session;

    private Users user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();//初始化页面控件
        GreenDaoUtil util=new GreenDaoUtil(this,"account");
        session=util.session;
    }

    private void initView(){
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
        btnQuery = (Button) findViewById(R.id.btnQuery);
        btnQuery.setOnClickListener(this);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(this);
        btnDel = (Button) findViewById(R.id.btnDel);
        btnDel.setOnClickListener(this);
        tvMsg = (TextView)findViewById(R.id.tvMsg);
    }
    /**
     * 按钮点击相关处理
     */
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnAdd:{
                add();
                break;
            }
            case R.id.btnQuery:{
                query();
                break;
            }
            case R.id.btnUpdate:{
                update();
                break;
            }
            case R.id.btnDel:{
                break;
            }
        }
    }

    private void add(){
        Users userInfo = new Users();
        userInfo.setPassword("admin");
        long rawId = session.getUsersDao().insert(userInfo);
        Toast.makeText(MainActivity.this, rawId+"", Toast.LENGTH_LONG).show();
    }

    private void query(){
        List<Users> userList = session.getUsersDao().loadAll();
        user = userList.get(0);
        tvMsg.setText(user.getPassword());
        //tvMsg.setText(userList.size()>0?userList.get(0).getRealName():"无用户");
    }
    /**
     * 相等查询,where参数中可以添加多个相等的条件
     */
    private void queryEq(){
        Users user = session.getUsersDao().queryBuilder()
                .where(UsersDao.Properties.Password.eq("admin")).unique();
        tvMsg.setText(user.getPassword());
    }

    private void queryLike(){
        List<Users> userList = session.getUsersDao().queryBuilder().where(UsersDao.Properties.Password.like("%lihy%")).list();
    }


    private void queryBetween(){
        //List<UserInfo> userList = userInfoDao.queryBuilder().where(UserInfoDao.Properties.Age.between(0, 10)).list();
        List<Users> userList = session.getUsersDao().queryBuilder().where(UsersDao.Properties.Id.gt(10)).list();
        //gt:大于 lt:小于 ge:大于等于 le:小于等于

    }

    private void update(){
        if(user != null){
            user.setPassword("大星");
        }
        session.getUsersDao().update(user);

    }
}

