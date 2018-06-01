package com.example.lenovo.ljq_text_529.Component;


import com.example.lenovo.ljq_text_529.Module.HttpModule;
import com.example.lenovo.ljq_text_529.ui.mobile.MobileFragment;

import dagger.Component;

/**
 * Created by Administrator on 2018/5/28.
 */
@Component(modules = HttpModule.class)
public interface HttpComponent {

    void inject(MobileFragment mobileFragment);
}
