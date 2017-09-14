package chen.com.myaccount;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ios20 on 17/9/13.
 */

public class Installment extends Fragment {
    public Installment(){}
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.activity_out_come,container,false);
        TextView txt_content=(TextView) view.findViewById(R.id.txt_context);
        Log.e("1","2");
        return view;

    }
}
