package com.hxp.pithymenu.pithyMenu;

import android.app.Application;
import android.content.Intent;

import com.hxp.pithymenu.Activity1;
import com.hxp.pithymenu.Activity2;
import com.hxp.pithymenu.Activity3;
import com.hxp.pithymenu.Activity4;
import com.hxp.pithymenu.Activity5;
import com.hxp.pithymenu.Activity6;
import com.hxp.pithymenu.MainActivity;
import com.hxp.pithymenu.PithyApp;
import com.hxp.pithymenu.R;
import com.hxp.pithymenu.SettingMenuActivity;

/**
 * Created by HXP on 2016/12/11.
 */

public enum JumpAction {
    ACTION1(R.mipmap.ic_launcher,R.string.action1, Activity1.class,true),
    ACTION2(R.mipmap.ic_launcher,R.string.action2, Activity2.class),
    ACTION3(R.mipmap.ic_launcher,R.string.action3, Activity3.class),
    ACTION4(R.mipmap.ic_launcher,R.string.action4, Activity4.class),
    ACTION5(R.mipmap.ic_launcher,R.string.action5, Activity5.class),
    ACTION6(R.mipmap.ic_launcher,R.string.action6, Activity6.class),
    ACTION7(R.mipmap.ic_launcher,R.string.action7, MainActivity.class),
    ACTION8(R.mipmap.ic_launcher,R.string.action8, SettingMenuActivity.class);

    private int iconImgRes;
    private int stringRes;
    private boolean hot;
    private Class clz;
    private boolean notice;

    public boolean isNotice() {
        return notice;
    }

    public void setNotice(boolean notice) {
        this.notice = notice;
    }

    public boolean isHot() {
        return hot;
    }
    JumpAction() {
    }

    JumpAction(int iconImgRes, int stringRes,Class clz) {
        this.iconImgRes = iconImgRes;
        this.stringRes = stringRes;
        this.clz = clz;

    }

    JumpAction(int iconImgRes, int stringRes,Class clz,boolean hot) {
        this.iconImgRes = iconImgRes;
        this.stringRes = stringRes;
        this.clz = clz;
        this.hot = hot;
    }

    public int getIconImgRes() {
        return iconImgRes;
    }

    public int getStringRes() {
        return stringRes;
    }

    public Class getClz() {
        return clz;
    }

    public void jump(){
        Intent intent = new Intent(PithyApp.getAppContext(),clz);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PithyApp.getAppContext().startActivity(intent);
    }
}
