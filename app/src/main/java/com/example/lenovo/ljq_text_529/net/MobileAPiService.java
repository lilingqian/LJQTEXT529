package com.example.lenovo.ljq_text_529.net;



import com.example.lenovo.ljq_text_529.bean.MobileBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2018/5/28.
 */

public interface MobileAPiService {
    @GET("mobile/?key=71e58b5b2f930eaf1f937407acde08fe&num=10")
    Observable<MobileBean> getMobile();
}
