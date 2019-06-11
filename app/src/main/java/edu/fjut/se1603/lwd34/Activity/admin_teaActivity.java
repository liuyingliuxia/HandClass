package edu.fjut.se1603.lwd34.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myhandclass.R;

import java.util.List;

import edu.fjut.se1603.lwd34.Entity.Student;
import edu.fjut.se1603.lwd34.Entity.Teacher;
import edu.fjut.se1603.lwd34.Entity.allDAO;


public class admin_teaActivity extends AppCompatActivity {
    private List<Teacher> list;
    private allDAO dao;
    private EditText TNo;
    private EditText TName;
    private MyAdapter adapter;
    private ListView teaLV;
    private ImageView addIV;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_tea);
        initView();
        dao=new allDAO(this);
        list=dao.queryTeacher();
        adapter= new MyAdapter();
        teaLV.setAdapter(adapter);

    }

    private void initView(){

        teaLV = (ListView)findViewById(R.id.teaLV);
        TNo = (EditText ) findViewById(R.id.tno);
        TName = (EditText) findViewById(R.id.tname);
        addIV=(ImageView) findViewById(R.id.taddIV);
        teaLV.setOnItemClickListener(new MyOnItemClickListener());

    }


    public void add(View v){
        String tpwd=TName.getText().toString().trim();
        String tno =TNo.getText().toString().trim();
        if(tpwd.isEmpty()||tno.isEmpty())
            return;
        else {
            Teacher s = new Teacher(Integer.parseInt(tno), tpwd);
            dao.insertTea(s);
            list.add(s);
            adapter.notifyDataSetChanged();
            teaLV.setSelection(teaLV.getCount() - 1);
            TNo.setText("");
            TName.setText("");
        }
    }
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
            View item = convertView!=null?convertView:View.inflate(getApplicationContext(),R.layout.stu_item,null);
            TextView idTV= item.findViewById(R.id.idTV);
            TextView nameTV = item.findViewById(R.id.nameTV);
            final Teacher s = list.get(position);
            idTV.setText(s.getTno()+"");
            nameTV.setText(s.getTname());

            return item;
        }

    }
    public class MyOnItemClickListener implements AdapterView.OnItemClickListener {


        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Teacher s = (Teacher) parent.getItemAtPosition(position);
            Toast.makeText(getApplicationContext(), s.toString(), Toast.LENGTH_SHORT).show();
        }


    }
}

