package chen.com.myaccount;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import adapter.FlagAdapter;
import chen.com.myaccount.bean.Flag;
import chen.com.myaccount.util.GreenDaoUtil;
import greendao.gen.DaoSession;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FlagshowinfoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FlagshowinfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FlagshowinfoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button btnAddFlag;//新增便签按钮
    private ListView lvinfo;
    private DaoSession session;

    private OnFragmentInteractionListener mListener;

    public FlagshowinfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FlagshowinfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FlagshowinfoFragment newInstance(String param1, String param2) {
        FlagshowinfoFragment fragment = new FlagshowinfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view= inflater.inflate(R.layout.fragment_flagshowinfo, container, false);

        GreenDaoUtil util=new GreenDaoUtil(getActivity(),"account");
        session=util.session;

        final List<Flag> flagList=session.getFlagDao().queryBuilder().list();
        /**
         * 显示所有便签信息
         */
        lvinfo=view.findViewById(R.id.lvinfo);
        lvinfo.setAdapter(new FlagAdapter(getActivity(),flagList));

        /**
         * 点击显示某一条便签信息
         */
        lvinfo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(),FlagManage.class);
                TextView textView=view.findViewById(R.id.flagid);
                Long strid=Long.parseLong(textView.getText().toString());
                Bundle bundle =new Bundle();
                bundle.putLong("flagid",strid);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        /**
         * 跳到添加页面
         */
        btnAddFlag =(Button)view.findViewById(R.id.btnAddFlag);
        btnAddFlag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= null;
                intent=new Intent(getActivity(),AccountFlag.class);
                startActivity(intent);
            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
