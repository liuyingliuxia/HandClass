package edu.fjut.se1603.lwd34.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.myhandclass.R;


public class teaInforFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private EditText TSname;
    private EditText TSno;
    private EditText TSex;
    private EditText TDate;
    private EditText TProfess;
    private EditText TClass;
    private String[] textString={"林老师","12","男","1977-01-02","通信工程","123"};
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_tea_infor, null);
        // Inflate the layout for this fragment
        TSname =view.findViewById(R.id.et_tea_name);
        TSno = view.findViewById(R.id.et_tea_no);
        TDate =view.findViewById(R.id.et_tea_date);
        TProfess = view.findViewById(R.id.et_tea_profess);
        TSex =view.findViewById(R.id.et_tea_sex);
        TClass = view.findViewById(R.id.et_tea_class);

        TSname.setText(textString[0]);
        TSno.setText(textString[1]);
        // querStuById(stuid);
        TSex.setText(textString[2]);
        TDate.setText(textString[3]);
        TProfess.setText(textString[4]);
        TClass.setText(textString[5]);
        return view;
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
