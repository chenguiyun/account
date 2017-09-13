package chen.com.myaccount;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class OutComeActivity extends AppCompatActivity {
    public List<tb_outaccount> outaccountList=new ArrayList<tb_outaccount>();
    public class tb_outaccount {
        int _id;
        double money;
        String time;
        String type;
        String address;
        String mark;

        public int get_id() {
            return _id;
        }

        public void set_id(int _id) {
            this._id = _id;
        }

        public double getMoney() {
            return money;
        }

        public void setMoney(float money) {
            this.money = money;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getMark() {
            return mark;
        }

        public void setMark(String mark) {
            this.mark = mark;
        }

        public tb_outaccount(int _id, float money, String time, String type, String address, String mark) {
            this._id = _id;
            this.money = money;
            this.time = time;
            this.type = type;
            this.address = address;
            this.mark = mark;
        }
    }

    ImageView imgbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_come);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        outadapter outadapter=new outadapter(this);
        tb_outaccount tb1=new tb_outaccount(1,100,"2017-8-1","旅游","昆明","花钱多");
        tb_outaccount tb2=new tb_outaccount(2,200,"2017-8-1","旅游","昆明","花钱多");
        tb_outaccount tb3=new tb_outaccount(3,300,"2017-8-1","旅游","昆明","花钱多");
        tb_outaccount tb4=new tb_outaccount(4,400,"2017-8-1","旅游","昆明","花钱多");
        tb_outaccount tb5=new tb_outaccount(5,500,"2017-8-1","旅游","昆明","花钱多");
        outaccountList.add(tb1);
        outaccountList.add(tb2);
        outaccountList.add(tb3);
        outaccountList.add(tb4);
        outaccountList.add(tb5);
        outadapter.outaccountList=outaccountList;
        ListView lv=(ListView)findViewById(R.id.outcomelv);
        lv.setAdapter(outadapter);

        imgbtn=(ImageView)findViewById(R.id.imageButton);
        final Intent intent=new Intent();
        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.setClass(OutComeActivity.this,OutComeAddActivity.class);
                startActivity(intent);
            }
        });

    }

}
