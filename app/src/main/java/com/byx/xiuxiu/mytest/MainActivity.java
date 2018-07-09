package com.byx.xiuxiu.mytest;

import android.app.MediaRouteButton;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rec;
    private List<Bean> listdata =new ArrayList<>();
   RecyclerView recyclerView;
    private ImageView imgviews;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initAdapter();



    }

    private void initAdapter() {

        MyAdapter myAdapter =new MyAdapter(this,listdata);
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        rec.setLayoutManager(linearLayoutManager);
        rec.setAdapter(myAdapter);
        myAdapter.setItem(new MyAdapter.TestItem() {
            @Override
            public void Listener(int psoo) {
                Toast.makeText(MainActivity.this, "华三登记日日记和第三方每年的就是覅嫩肤淡斑福尔康", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initData() {
        Bean bean =new Bean("滴滴","15",null);
        for (int i = 0; i <20 ; i++) {
            listdata.add(bean);
        }

    }


    private void initView() {
        rec = (RecyclerView) findViewById(R.id.rec);

    }
}
