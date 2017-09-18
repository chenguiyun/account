package chen.com.myaccount;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

/**
 * Created by ios20 on 17/9/13.
 */

public class MyFagementPagerAdapter extends FragmentPagerAdapter {
    private final  int PAGER_COUNT = 4;
    private OutComeFragment payment=null;
    private Revenuement revenuement=null;
    private Installment installment=null;
    private FlagshowinfoFragment notement=null;

    public MyFagementPagerAdapter(FragmentManager fm) {
        super(fm);
        payment=new OutComeFragment();
        revenuement=new Revenuement();
        notement=new FlagshowinfoFragment();
        installment=new Installment();
    }

    public Object instantiateItem(ViewGroup vg,int position){
        return super.instantiateItem(vg,position);
    }

    public  void destoryItem(ViewGroup viewGroup,int position,Object object){
        System.out.println("position"+position);
        //super.destroyItem(viewGroup,position,object);
    }
    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        switch (position){
            case Home.page_one:
                fragment = payment;
                break;
            case Home.page_two:
                fragment=revenuement;
                break;
            case Home.page_three:
                fragment=notement;
                break;
            case Home.page_four:
                fragment=installment;
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return PAGER_COUNT;
    }
}
