package chen.com.myaccount.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by ios13 on 17/9/13.
 */
@Entity
public class Flag {
    @Id
    private long id;
    @NotNull
    private String flag;
    public String getFlag() {
        return this.flag;
    }
    public void setFlag(String flag) {
        this.flag = flag;
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    @Generated(hash = 1192702733)
    public Flag(long id, @NotNull String flag) {
        this.id = id;
        this.flag = flag;
    }
    @Generated(hash = 325057191)
    public Flag() {
    }
}
