package edu.fjut.se1603.lwd34.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myhandclass.R;

import java.util.List;

import edu.fjut.se1603.lwd34.Entity.Student;
import edu.fjut.se1603.lwd34.Entity.allDAO;


public class teaAttendFragment extends Fragment {
   private List<Student> list;
   private allDAO dao;
   private EditText SNo;
   private EditText SName;
 //  private MyAdapter adapter;
   private ListView stuLV;

    public teaAttendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tea_attend, null);
        stuLV = (ListView)view.findViewById(R.id.stuLV);
        SNo = (EditText ) view.findViewById(R.id.sno);
        SName = (EditText) view.findViewById(R.id.sname);
     //   stuLV.setOnItemClickListener(new MyOnItemClickListener());
        // Inflate the layout for this fragment
        dao=new allDAO(getContext());
        list=dao.queryStu();
//        adapter= new MyAdapter();
//        stuLV.setAdapter(adapter);
        return view;
    }

/*

    public class MyAdapter extends BaseAdapter{
        public int getCount(){
            return list.size();
        }


        @Override
        public Object getItem(int position) {
            return list.get(position);
        }


        @Override
        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View item = convertView!=null?convertView:View.inflate(getActivity(),R.layout.stu_item,null);
            TextView idTV= item.findViewById(R.id.idTV);
            TextView nameTV = item.findViewById(R.id.nameTV);
            final Student s = list.get(position);
            idTV.setText(s.getSno()+"");
            nameTV.setText(s.getSname());
            return null;
        }

    }
    public class MyOnItemClickListener implements AdapterView.OnItemClickListener{
        /**
         * Callback method to be invoked when an item in this AdapterView has
         * been clicked.
         * <p>
         * Implementers can call getItemAtPosition(position) if they need
         * to access the data associated with the selected item.
         *
         * @param parent   The AdapterView where the click happened.
         * @param view     The view within the AdapterView that was clicked (this
         *                 will be a view provided by the adapter)
         * @param position The position of the view in the adapter.
         * @param id       The row id of the item that was clicked.
         */

        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Student s= (Student) parent.getItemAtPosition(position);
            Toast.makeText(getActivity(),s.toString(),Toast.LENGTH_SHORT).show();

        }



    }

