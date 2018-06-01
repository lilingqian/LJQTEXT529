package com.example.lenovo.ljq_text_529.ui.mobile;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.lenovo.ljq_text_529.Component.DaggerHttpComponent;
import com.example.lenovo.ljq_text_529.Module.HttpModule;
import com.example.lenovo.ljq_text_529.R;
import com.example.lenovo.ljq_text_529.bean.MobileBean;
import com.example.lenovo.ljq_text_529.ui.base.BaseFragment;
import com.example.lenovo.ljq_text_529.ui.mobile.Adapter.MyAdapter;
import com.example.lenovo.ljq_text_529.ui.mobile.Contract.MobileContract;
import com.example.lenovo.ljq_text_529.ui.mobile.Presenter.MobilePresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/28.
 */

public class MobileFragment extends BaseFragment<MobilePresenter> implements MobileContract.View {
    private View view;
    private XRecyclerView mXrlv;
    private boolean isRefresh = true;
    private MyAdapter adapter;

    @Override
    public int getContentLayout() {
        return R.layout.mobile_item;
    }

    @Override
    public void inject() {
        DaggerHttpComponent
                .builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);

    }

    @Override
    public void initView(View view) {

        mXrlv = (XRecyclerView) view.findViewById(R.id.xrlv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mXrlv.setLayoutManager(linearLayoutManager);
        mPresenter.getMobile();
        mXrlv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                isRefresh=true;
                mPresenter.getMobile();
            }

            @Override
            public void onLoadMore() {
                isRefresh=false;
                mPresenter.getMobile();
            }
        });
    }

    @Override
        public void onSuccess(MobileBean mobileBean) {

        List<MobileBean.NewslistBean> tlist=new ArrayList<>();
        tlist.addAll(mobileBean.getNewslist());
        if (isRefresh){
            adapter = new MyAdapter(getContext(), mobileBean.getNewslist());
            mXrlv.setAdapter(adapter);
            adapter.refresh(tlist);
            mXrlv.refreshComplete();

        }else {
            if (adapter!=null){
                adapter.loadMore(tlist);
                mXrlv.loadMoreComplete();
            }
        }
        if (adapter==null){
            return;
        }

    }

}
