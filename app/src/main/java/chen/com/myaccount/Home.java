package chen.com.myaccount;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public  class Home extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,
        ViewPager.OnPageChangeListener,OutComeFragment.OnFragmentInteractionListener,BlankFragment.OnFragmentInteractionListener{
    private TextView txt_topbar;
    private RadioGroup rg_tab_bar;
    private RadioButton rb_channel;
    private RadioButton rb_message;
    private RadioButton rb_better;
    private RadioButton rb_setting;
    private ViewPager vpager;

    private MyFagementPagerAdapter mAdapter;

    public static final int page_one=0;
    public static final int page_two=1;
    public static final int page_three=2;
    public static final int page_four=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mAdapter=new MyFagementPagerAdapter(getSupportFragmentManager());
        bindViews();
        rb_channel.setChecked(true);
    }

    private void bindViews(){
        txt_topbar=(TextView)findViewById(R.id.txt_context);
        rg_tab_bar=(RadioGroup)findViewById(R.id.rg_tab_bar);
        rb_channel=(RadioButton)findViewById(R.id.rb_channel);
        rb_message=(RadioButton)findViewById(R.id.rb_message);
        rb_better=(RadioButton)findViewById(R.id.rb_better);
        rb_setting=(RadioButton)findViewById(R.id.rb_setting);
        rg_tab_bar.setOnCheckedChangeListener(this);

        vpager=(ViewPager)findViewById(R.id.vpager);
        vpager.setAdapter(mAdapter);
        vpager.setCurrentItem(0);
        vpager.addOnPageChangeListener(this);
    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {
    if (state==2){
        switch ((vpager.getCurrentItem())){
            case page_one:
                rb_channel.setChecked(true);
                break;
            case page_two:
                rb_message.setChecked(true);
                break;
            case page_three:
                rb_better.setChecked(true);
                break;
            case page_four:
                rb_setting.setChecked(true);
                break;
        }
    }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        switch (i){
            case R.id.rb_channel:
                vpager.setCurrentItem(page_one);
                break;
            case R.id.rb_message:
                vpager.setCurrentItem(page_two);
                break;
            case R.id.rb_better:
                vpager.setCurrentItem(page_three);
                break;
            case R.id.rb_setting:
                vpager.setCurrentItem(page_four);
                break;
        }
    }
    private FragmentManager fm = null;
    @Override
    public void onFragmentInteraction(Uri uri) {
    }
}
