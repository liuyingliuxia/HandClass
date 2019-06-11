package edu.fjut.se1603.lwd34.Activity;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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
import edu.fjut.se1603.lwd34.Entity.allDAO;


public class adminStuActivity extends AppCompatActivity {
    private List<Student> list;
    private allDAO dao;
    private EditText SNo;
    private EditText SName;
    private MyAdapter adapter;
    private ListView stuLV;
    private ImageView addIV;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_stu);
        initView();
        dao=new allDAO(this);
        list=dao.queryStu();
        adapter= new MyAdapter();
        stuLV.setAdapter(adapter);
        addIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add(v);
            }
        });
    }

private void initView(){

    stuLV = (ListView)findViewById(R.id.stuLV);
    SNo = (EditText ) findViewById(R.id.sno);
    SName = (EditText) findViewById(R.id.sname);
    addIV=(ImageView) findViewById(R.id.addIV);
    stuLV.setOnItemClickListener(new MyOnItemClickListener());

}

    public void add(View v){
        String sname=SName.getText().toString().trim();
        String sno =SNo.getText().toString().trim();
        if(sname.isEmpty()||sno.isEmpty())
            return;
        else {
            Student s = new Student(Integer.parseInt(sno), sname);
            dao.insertStu(s);
            list.add(s);
            adapter.notifyDataSetChanged();
            stuLV.setSelection(stuLV.getCount() - 1);
            SNo.setText("");
            SName.setText("");
        }
    }
    public class MyAdapter extends BaseAdapter {
        public int getCount() {
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
            View item = convertView != null ? convertView : View.inflate(getApplicationContext(), R.layout.stu_item, null);
            final Student s = list.get(position);

            TextView idTV = item.findViewById(R.id.idTV);
            TextView nameTV = item.findViewById(R.id.nameTV);
            idTV.setText(s.getSno() + "");
            nameTV.setText(s.getSname());
            ImageView deleteIV = item.findViewById(R.id.deleteIV);

            //删除
            deleteIV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    android.content.DialogInterface.OnClickListener listener=new android.content.DialogInterface.OnClickListener(){
                        public void onClick (DialogInterface dialog, int which){
                            list.remove(s);
                            dao.deletestu(s.getSno());
                            notifyDataSetChanged();
                        }
                    };

                    AlertDialog.Builder builder=new AlertDialog.Builder(adminStuActivity.this);
                    builder.setTitle("确定要删除吗？");
                    builder.setPositiveButton("确定",listener);
                    builder.setNegativeButton("取消",listener);
                    builder.show();
                }
            });

            return item;
        }

    }
    public class MyOnItemClickListener implements AdapterView.OnItemClickListener {


        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Student s = (Student) parent.getItemAtPosition(position);
            Toast.makeText(getApplicationContext(), s.toString(), Toast.LENGTH_SHORT).show();

        }


    }
}

