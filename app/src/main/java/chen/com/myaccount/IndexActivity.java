package chen.com.myaccount;

import android.app.ActivityGroup;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.Toast;

public class IndexActivity extends ActivityGroup {
    private TabHost tabhost;
    private FrameLayout tabcontent;
    private TabWidget tabs;
    private RadioGroup mainRadiogroup;
    private RadioButton tabIconWeixin;
    private RadioButton tabIconAddress;
    private RadioButton tabIconFriend;
    private RadioButton tabIconSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        /**
         * 继承tabactivity
         */
        /*tabhost = getTabHost();
        tabhost.setup();*/
        /**
         * 继承activitygroup
         */
        tabhost=findViewById(R.id.tabhost1);
        tabhost.setup(this.getLocalActivityManager());
        //tabhost.setup(this.getLoaderManager());  //必须要又这个语句，如果继承TabActivity可不要
        tabhost.addTab(tabhost.newTabSpec("shouru")
                .setContent(new Intent(this, OutActivity.class)).setIndicator("shouru"));
        tabhost.addTab(tabhost.newTabSpec("zhichu")
                .setContent(new Intent(this, OutActivity.class)).setIndicator("zhichu"));
        tabhost.addTab(tabhost.newTabSpec("bianqing")
                .setContent(new Intent(this,OutActivity.class)).setIndicator("bianqing"));
        tabhost.addTab(tabhost.newTabSpec("shezhi")
                .setContent(new Intent(this,OutActivity.class)).setIndicator("shezhi"));
        mainRadiogroup=findViewById(R.id.tabGroup);
        mainRadiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                RadioButton radioButton=findViewById(i);

                if(radioButton.getId()==R.id.shouru){
                    tabhost.setCurrentTabByTag("shouru");  //显示与隐藏的标记
                }
                else if(radioButton.getId()==R.id.zhichu) {
                    tabhost.setCurrentTabByTag("zhichu");
                }
                else  if(radioButton.getId()==R.id.bianqing){
                    tabhost.setCurrentTabByTag("bianqing");
                }
                else {
                    tabhost.setCurrentTabByTag("shezhi");
                }
            }
        });
    }

    //右上角图标－－start//
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.item1:
                Toast.makeText(IndexActivity.this, "添加收入", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Toast.makeText(IndexActivity.this, "添加支出", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                Toast.makeText(IndexActivity.this, "添加便签", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    //右上角菜单－－end//
}
