package chen.com.myaccount;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by ios20 on 17/9/13.
 */

public class Installment extends Fragment {
    private ListView mylistview;
    private ArrayList<String> list = new ArrayList<String>();
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public static OutComeFragment newInstance(String param1, String param2) {
        OutComeFragment fragment = new OutComeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    View view;
    public Installment(){}
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.activity_install,container,false);
        mylistview = (ListView)view.findViewById(R.id.list_item);
        list.add("密码设置");
        list.add("退出");
        //ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.activity_install, list);
        //mylistview.setAdapter(myArrayAdapter);
        mylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                // TODO Auto-generated method stub
                if (list.get(arg2).equals("密码设置")) {
                    Intent intent = new Intent(getActivity(),Setpassword.class);
                    startActivity(intent);
                }
                if (list.get(arg2).equals("退出")) {

                }
            }

        });
        return view;

    }
}
