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

import edu.fjut.se1603.lwd34.Entity.Homework;
import edu.fjut.se1603.lwd34.Entity.allDAO;


public class homeworkActivity extends AppCompatActivity {
    private List<Homework> list;
    private allDAO dao;
    private EditText SNo;
    private EditText CName;
    private EditText title;
    private EditText grade;

    private MyAdapter adapter;
    private ListView homeworkLV;
    private ImageView addIV;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework);
        initView();
        dao=new allDAO(this);
        list=dao.queryHome();
        adapter= new MyAdapter();
        homeworkLV.setAdapter(adapter);
        addIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add(v);
            }
        });
    }

    private void initView(){

        homeworkLV = (ListView)findViewById(R.id.homeLV);
        SNo = (EditText ) findViewById(R.id.snoET);
        CName = (EditText) findViewById(R.id.cnameET);
        title = (EditText ) findViewById(R.id.titleET);
        grade = (EditText) findViewById(R.id.gradeET);
        addIV=(ImageView) findViewById(R.id.addHomework);
        homeworkLV.setOnItemClickListener(new MyOnItemClickListener());

    }

    public void add(View v){
        String cname1=CName.getText().toString().trim();
        String sno1 =SNo.getText().toString().trim();
        String title1=title.getText().toString().trim();
        String grade1 =grade.getText().toString().trim();
        if(cname1.isEmpty()||sno1.isEmpty()||title1.isEmpty()||grade1.isEmpty())
            return;
        else {
            Homework s = new Homework(Integer.parseInt(sno1), cname1,title1,Double.parseDouble(grade1));
            dao.insertHome(s);
            list.add(s);
            adapter.notifyDataSetChanged();
            homeworkLV.setSelection(homeworkLV.getCount() - 1);
            SNo.setText("");
            CName.setText("");
            title.setText("");
            grade.setText("");
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
            View item = convertView != null ? convertView : View.inflate(getApplicationContext(), R.layout.homework_item, null);
            final Homework s = list.get(position);

            TextView idTV2 = item.findViewById(R.id.snoTV);
            TextView cnameTV2 = item.findViewById(R.id.cnameTV);
            TextView title2 = item.findViewById(R.id.homeworkTitleTV);
            TextView grade2 = item.findViewById(R.id.gradeTV);

            idTV2.setText(s.getSno() + "");
            cnameTV2.setText(s.getCname());
            title2.setText(s.getTitle() );
            grade2.setText(s.getGrade()+"");

            return item;
        }

    }
    public class MyOnItemClickListener implements AdapterView.OnItemClickListener {


        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Homework s = (Homework) parent.getItemAtPosition(position);
            Toast.makeText(getApplicationContext(), s.toString(), Toast.LENGTH_SHORT).show();

        }


    }
}

