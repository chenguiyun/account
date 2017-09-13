package chen.com.myaccount.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * Created by ios13 on 17/9/13.
 */
@Entity
public class Outaccount {
    @Id
    private long id;
    @NotNull
    private double money;
    @NotNull
    private String time;
    @NotNull
    private String type;
    private String address;
    private String mark;
    public String getMark() {
        return this.mark;
    }
    public void setMark(String mark) {
        this.mark = mark;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
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
    @Generated(hash = 25362077)
    public Outaccount(long id, double money, @NotNull String time,
            @NotNull String type, String address, String mark) {
        this.id = id;
        this.money = money;
        this.time = time;
        this.type = type;
        this.address = address;
        this.mark = mark;
    }
    @Generated(hash = 1970383699)
    public Outaccount() {
    }

}
