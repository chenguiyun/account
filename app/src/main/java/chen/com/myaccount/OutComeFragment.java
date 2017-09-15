package chen.com.myaccount;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import chen.com.myaccount.bean.Outaccount;
import chen.com.myaccount.util.GreenDaoUtil;
import greendao.gen.DaoSession;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OutComeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OutComeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OutComeFragment extends Fragment  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public List<OutComeActivity.tb_outaccount> outaccountList=new ArrayList<OutComeActivity.tb_outaccount>();
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private DaoSession session;
    ImageView imgbtn;

    public OutComeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OutComeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OutComeFragment newInstance(String param1, String param2) {
        OutComeFragment fragment = new OutComeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        //getView().findViewById(R.id.outcomelv);
        /*
        GreenDaoUtil util = new GreenDaoUtil(this.getActivity(), "account");
        session = util.getSession();

        outadapter outadapter = new outadapter(this.getActivity());
        /*
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
        */
        /*
        Outaccount outaccount = new Outaccount(100, "2017-8-1", "旅游", "昆明", "花钱多");
        session.getOutaccountDao().insert(outaccount);
        List<Outaccount> list = session.getOutaccountDao().queryBuilder().list();
        outadapter.outaccountList = list;
        //ListView lv=(ListView)getView().findViewById(R.id.outcomelv);
        //lv.setAdapter(outadapter);

        imgbtn=(ImageView)getView().findViewById(R.id.imageButton);
        final Intent intent=new Intent(getActivity(),OutComeAddActivity.class);
        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
        */


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_out_come, container, false);

        this.view=view;
        GreenDaoUtil util = new GreenDaoUtil(this.getActivity(), "account");
        session = util.getSession();


        /*
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
        */

        //Outaccount outaccount = new Outaccount(100, "2017-8-1", "旅游", "昆明", "花钱多");
        //session.getOutaccountDao().insert(outaccount);
        //session.getOutaccountDao().deleteAll();
        final outadapter outadapter= new outadapter(this.getActivity());
        final List<Outaccount> list = session.getOutaccountDao().queryBuilder().list();
        outadapter.outaccountList = list;
        final ListView lv=(ListView)view.findViewById(R.id.outcomelv);
        lv.setAdapter(outadapter);
        int as=100;
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, final View view, int i, long l) {

                outadapter.maps(i,true);
                outadapter.getView(i,view,null);
                lv.setAdapter(outadapter);
                return false;
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent();
                intent.setClass(getActivity(),OutcomeeditsActivity.class);
                intent.putExtra("id",""+list.get(i).getId());
                startActivity(intent);
            }
        });
        if (outadapter.map.size()==0)
        {
            lv.setAdapter(outadapter);
        }
        imgbtn=(ImageView)view.findViewById(R.id.outimageButton);
        final Intent intent=new Intent(getActivity(),OutComeAddActivity.class);
        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
    /*
    @Override
    public void onFragmentInteraction(Uri uri) {
    }
    *

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
