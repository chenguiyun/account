package chen.com.myaccount.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * Created by ios13 on 17/9/13.
 */
@Entity
public class Users {
    @Id
    private long id;
    @NotNull
    private String password;
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    @Generated(hash = 580271639)
    public Users(long id, @NotNull String password) {
        this.id = id;
        this.password = password;
    }
    @Generated(hash = 2146996206)
    public Users() {
    }
}
