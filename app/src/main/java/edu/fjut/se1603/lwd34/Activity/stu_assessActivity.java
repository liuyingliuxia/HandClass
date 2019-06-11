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

import edu.fjut.se1603.lwd34.Entity.Assess;
import edu.fjut.se1603.lwd34.Entity.Student;
import edu.fjut.se1603.lwd34.Entity.allDAO;


public class stu_assessActivity extends AppCompatActivity {
    private List<Assess> list;
    private allDAO dao;
    private MyAdapter adapter;
    private ListView stuassessLV;
    private EditText snoET;
    private EditText classET;
    private EditText scoreET;
    private ImageView addassessIV;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_assess);
        initView();
        dao=new allDAO(this);
        list=dao.queryassess();
        adapter= new MyAdapter();
        stuassessLV.setAdapter(adapter);
        addassessIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add(v);
            }
        });
    }

    private void initView(){

        snoET = findViewById(R.id.assesssno);
        classET = findViewById(R.id.assessclassname);
        scoreET =findViewById(R.id.assessScore);
        stuassessLV = (ListView)findViewById(R.id.assessLV);
        addassessIV = findViewById(R.id.addassessIV);
        stuassessLV.setOnItemClickListener(new MyOnItemClickListener());

    }
    public void add(View v){
        String classname=classET.getText().toString().trim();
        String sno =snoET.getText().toString().trim();
        String score =scoreET.getText().toString().trim();
        if(classname.isEmpty()||sno.isEmpty()||score.isEmpty())
            return;
        else {
            Assess s = new Assess(Integer.parseInt(sno), classname,Double.parseDouble(score));
            dao.insertAssess(s);
            list.add(s);
            adapter.notifyDataSetChanged();
            stuassessLV.setSelection(stuassessLV.getCount() - 1);
            classET.setText("");
            snoET.setText("");
            scoreET.setText("");
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
            View item = convertView!=null?convertView:View.inflate(getApplicationContext(),R.layout.assess_item,null);
            TextView sno= item.findViewById(R.id.snoTV);
            TextView classname = item.findViewById(R.id.cnameTV);
            TextView score = item.findViewById(R.id.scoreTV);
            final Assess s = list.get(position);

            sno.setText(s.getSno()+"");
            classname.setText(s.getClassname());
            score.setText(s.getScore()+"");

            return item;
        }

    }
    public class MyOnItemClickListener implements AdapterView.OnItemClickListener {


        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Assess a = (Assess) parent.getItemAtPosition(position);
            Toast.makeText(getApplicationContext(), a.toString(), Toast.LENGTH_SHORT).show();
        }


    }
}

