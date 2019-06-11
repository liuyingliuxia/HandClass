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

import edu.fjut.se1603.lwd34.Entity.Attend;
import edu.fjut.se1603.lwd34.Entity.Student;
import edu.fjut.se1603.lwd34.Entity.allDAO;


public class stu_attendActivity extends AppCompatActivity {
    private List<Attend> list;
    private allDAO dao;
    private MyAdapter adapter;
    private ListView stuAttendLV;
    private Attend attend;
    private int status;//出勤状态
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_attend);
        initView();
        dao=new allDAO(this);
        list=dao.queryAttend();
        adapter= new MyAdapter();
        stuAttendLV.setAdapter(adapter);

    }

    private void initView(){

        stuAttendLV = (ListView)findViewById(R.id.attendLV);
        stuAttendLV.setOnItemClickListener(new MyOnItemClickListener());

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
            View item = convertView!=null?convertView:View.inflate(getApplicationContext(),R.layout.attend_item,null);
            TextView ano= item.findViewById(R.id.ano);
            TextView date = item.findViewById(R.id.adate);
            TextView classname = item.findViewById(R.id.aclassname);
            final Attend s = list.get(position);

            ano.setText(s.getSno()+"");
            date.setText(s.getAttenddate());
            classname.setText(s.getClassname());
            ImageView lateIV = (ImageView) item.findViewById(R.id.lateIV);
            ImageView leaveIV = (ImageView) item.findViewById(R.id.leaveIV);
            ImageView geIV =(ImageView) item.findViewById(R.id.geIV);
            //设置迟到状态 值为1
            lateIV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    status =1;
                    attend.setStatus(status);
                    notifyDataSetChanged();
                    dao.updateAttend(attend);
                }
            });
            //设置请假状态 值为2
            leaveIV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    status =2;
                    attend.setStatus(status);
                    notifyDataSetChanged();
                    dao.updateAttend(attend);
                }
            });
            //设置旷课状态 值为0
            geIV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    status =0;
                    attend.setStatus(status);
                    notifyDataSetChanged();
                    dao.updateAttend(attend);
                }
            });
            return item;
        }

    }
    public class MyOnItemClickListener implements AdapterView.OnItemClickListener {


        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Attend a = (Attend) parent.getItemAtPosition(position);
            Toast.makeText(getApplicationContext(), a.toString(), Toast.LENGTH_SHORT).show();
        }


    }
}

