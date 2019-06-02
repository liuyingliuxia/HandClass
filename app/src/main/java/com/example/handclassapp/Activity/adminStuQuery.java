package com.example.handclassapp.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.handclassapp.DAO.MyDb;
import com.example.handclassapp.R;
import com.example.handclassapp.DAO.StudentDao;

import java.util.List;

public class adminStuQuery extends AppCompatActivity {
    private MyDb dbHelper;
    private StudentDao dao;
    private EditText nameT;
    private MyAdapter adapter;
    private ListView studentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_query);
        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(adminStuQuery.this,R.layout.item,data);
        ListView listView = findViewById(R.id.list_view);
        //listView.setAdapter(adapter);
    }

}
//数据适配器类：
 class MyAdapter extends BaseAdapter {

    private List<Student> mlist;

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}


   /* public View getView(int position, View convertView, ViewGroup parent) {
        View item = convertView != null ? convertView : View.inflate(null, R.layout.item, null);
        TextView sname = (TextView) item.findViewById(R.id.stuName1);
        TextView sNo = (TextView) item.findViewById(R.id.stuNo1);
        TextView spro = (TextView) item.findViewById(R.id.profession1);
        TextView scollege = (TextView) item.findViewById(R.id.college1);
        ImageView delete = (ImageView) item.findViewById(R.id.imageView);
        delete.setOnClickListener(new onClickListener()) {
            public void onClick (View v){
                android.content.DialogInterface.onClickListener listener =
                        new android.content.DialogInterface.onClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                list.remove(a);
                                dao.delete(a.getId());
                            }
                        };
                Builder builder = new Builder(adminStuQuery.this);
                builder.setTitle("确定删除吗？");
            }
        });
        return item;
    }
    }



private class MyOnItemClickListener implements AdapterView.OnItemClickListener {
    public void onItemClick(AdapterView<?>) parent,View view ,int position, long id ){
      Student a = (Student) parent.getItemAtPosition(Position);
        Toast.makeText(getAppcationContext(),a.toString()),Toast.LENGTH_SHORT).show();
        }
    }
}
*/