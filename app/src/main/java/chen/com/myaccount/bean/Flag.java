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
    private Long id;
    @NotNull
    private String flag;

    public Flag(String flag) {
        this.flag = flag;
    }

    public String getFlag() {
        return this.flag;
    }
    public void setFlag(String flag) {
        this.flag = flag;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 1675495266)
    public Flag(Long id, @NotNull String flag) {
        this.id = id;
        this.flag = flag;
    }
    @Generated(hash = 325057191)
    public Flag() {
    }
}
