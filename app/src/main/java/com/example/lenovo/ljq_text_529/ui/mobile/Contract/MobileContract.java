package com.example.lenovo.ljq_text_529.ui.mobile.Contract;

import android.view.View;

import com.example.lenovo.ljq_text_529.bean.MobileBean;
import com.example.lenovo.ljq_text_529.ui.base.Contract.BaseContract;


/**
 * Created by Administrator on 2018/5/28.
 */

public interface MobileContract {

    interface View extends BaseContract.BaseView{
        void onSuccess(MobileBean mobileBean);
    }
    interface Presenter extends BaseContract.BasePresenter<View> {
        void getMobile();
    }
}
