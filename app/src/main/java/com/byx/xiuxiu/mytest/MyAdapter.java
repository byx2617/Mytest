package com.byx.xiuxiu.mytest;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ASUS on 2018/7/5.
 */

public  class MyAdapter extends RecyclerView.Adapter implements RecyclerView.OnClickListener{



    private Context context;
    private List<Bean> listdata;

    private MyAdapter.TestItem testItem;
    private View view;
    private ViewHolder holder1;

    public MyAdapter(Context context, List<Bean> listdata) {
        this.context = context;
        this.listdata = listdata;

    }
    public void setItem(TestItem testItem){
        this.testItem=testItem;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        ViewHolder holder =new ViewHolder(view);
        view.setOnClickListener(this);

        return new ViewHolder(holder.myitemview);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

                if (position<6){
                    holder1 = (ViewHolder) holder;
                    holder1.item_name.setText(listdata.get(position).getName());
                    holder1.item_sex.setText(listdata.get(position).getSex());
                    holder1.myitemview.setTag(position);

                }else {
                    holder1 = (ViewHolder) holder;
                    holder1.item_img.setVisibility(view.getVisibility());
                    holder1.item_img.setImageResource(R.mipmap.ic_launcher);
                    holder1.myitemview.setTag(position);
                }

    }

    @Override
    public int getItemCount() {
        return 7;
    }

    @Override
    public void onClick(View view) {
        Integer integer = (Integer) view.getTag();


        if (testItem !=null){
            testItem.Listener(integer);
        }


    }

   private class ViewHolder extends RecyclerView.ViewHolder{

        private TextView item_name;
        private TextView item_sex;
        private View myitemview ;
        private ImageView item_img;
        public ViewHolder(View itemView) {
            super(itemView);
            myitemview=itemView;

            item_name= (TextView) itemView.findViewById(R.id.tv_name);
            item_sex= (TextView) itemView.findViewById(R.id.tv_sex);
           item_img = (ImageView)itemView.findViewById(R.id.imageView);

        }
    }

    public interface TestItem{
        void Listener(int psoo);
    }

/****

    public abstract class Listeners extends RecyclerView.OnScrollListener{

    // 用来标记是否正在向左滑动
    private boolean isSlidingToLeft = false;


    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
        // 当不滑动时
        if (newState == RecyclerView.SCROLL_STATE_IDLE) {
            // 获取最后一个完全显示的itemPosition
            int lastItemPosition = manager.findLastCompletelyVisibleItemPosition();
            int itemCount = manager.getItemCount();

            // 判断是否滑动到了最后一个item，并且是向左滑动
            if (lastItemPosition == (itemCount - 1) && isSlidingToLeft) {
                // 加载更多
          //      onLoadMore();
            }
        }
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        // dx值大于0表示正在向左滑动，小于或等于0表示向右滑动或停止
        isSlidingToLeft = dx > 0;
    }

         //加载更多回调


    }
*/

}


