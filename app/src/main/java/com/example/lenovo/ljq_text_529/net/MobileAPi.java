package com.example.lenovo.ljq_text_529.net;



import com.example.lenovo.ljq_text_529.bean.MobileBean;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/5/28.
 */

public class MobileAPi {
    private static MobileAPi mobileAPi;
    private MobileAPiService mobileAPiService;

    public MobileAPi(MobileAPiService mobileAPiService) {
        this.mobileAPiService = mobileAPiService;
    }
    public static MobileAPi getMobileAPi(MobileAPiService mobileAPiService){
        if (mobileAPi==null){
            mobileAPi=new MobileAPi(mobileAPiService);

        }
        return mobileAPi;
    }
    public Observable<MobileBean> getMobile(){
        return mobileAPiService.getMobile();
    }
}
