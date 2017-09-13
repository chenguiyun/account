package chen.com.myaccount.util;

import android.content.Context;

import greendao.gen.DaoMaster;
import greendao.gen.DaoSession;

/**
 * Created by ios13 on 17/9/13.
 */

public class GreenDaoUtil {
    private  DaoMaster.DevOpenHelper helper;
    private  DaoMaster master;
    public DaoSession session;
    private Context context;
    private String dbName;

    public GreenDaoUtil(Context context, String dbName) {
        super();
        this.context = context;
        this.dbName = dbName.equals(".db")?dbName:dbName+".db";
        initDb();
    }
    /**
     *初始化数据库
     */
    private   void initDb(){
        helper = new DaoMaster.DevOpenHelper(context,dbName, null);
        master = new DaoMaster(helper.getWritableDatabase());
        session = master.newSession();
    }

    /**
     * 获取daosession
     * @return
     */
    public DaoSession getSession(){
        return session;
    }
}
