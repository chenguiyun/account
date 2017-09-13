package chen.com.myaccount.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by ios13 on 17/9/13.
 */
@Entity
public class Inaccount {
    @Id
    private long id;
    @NotNull
    private double money;
    @NotNull
    private String time;
    @NotNull
    private String type;
    private String handler;
    private String mark;
    public String getMark() {
        return this.mark;
    }
    public void setMark(String mark) {
        this.mark = mark;
    }
    public String getHandler() {
        return this.handler;
    }
    public void setHandler(String handler) {
        this.handler = handler;
    }
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public double getMoney() {
        return this.money;
    }
    public void setMoney(double money) {
        this.money = money;
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    @Generated(hash = 1408488047)
    public Inaccount(long id, double money, @NotNull String time,
            @NotNull String type, String handler, String mark) {
        this.id = id;
        this.money = money;
        this.time = time;
        this.type = type;
        this.handler = handler;
        this.mark = mark;
    }
    @Generated(hash = 118929655)
    public Inaccount() {
    }
}
