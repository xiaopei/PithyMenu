package com.hxp.pithymenu.pithyMenu;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hxp.pithymenu.R;

/**
 * Created by HXP on 2016/12/12.
 */

public class ListMenuCell extends RelativeLayout {
    private ImageView imageIcon;
    private ImageView imageHot;
    private TextView name;
    private View notice;
    private Context context;

    public ListMenuCell(Context context) {
        super(context);
        init(context);
    }

    public ListMenuCell(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ListMenuCell(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ListMenuCell(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context){
        this.context = context;
        View view = inflate(context, R.layout.list_menu_cell, this);
        imageIcon = (ImageView) view.findViewById(R.id.list_icon);
        name = (TextView) view.findViewById(R.id.list_name);
        imageHot = (ImageView) view.findViewById(R.id.list_image_hot);
        notice =  view.findViewById(R.id.list_notice);
    }

    public void show(final JumpAction action){
        imageIcon.setImageResource(action.getIconImgRes());
        name.setText(context.getString(action.getStringRes()));
        if(action.isNotice()){
            notice();
        }else{
            removeNotice();
        }
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                action.jump();
            }
        });
    }

    public void notice(){
        notice.setVisibility(VISIBLE);
    }

    public void removeNotice(){
        notice.setVisibility(GONE);
    }
}
