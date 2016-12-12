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
import com.hxp.pithymenu.TableMenuActivity;

/**
 * Created by HXP on 2016/12/12.
 */

public class TableMenuCell extends RelativeLayout {
    private ImageView imageIcon;
    private ImageView imageHot;
    private TextView name;
    private View notice;
    private Context context;

    public TableMenuCell(Context context) {
        super(context);
        init(context);
    }

    public TableMenuCell(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TableMenuCell(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TableMenuCell(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context){
        this.context = context;
        View view = inflate(context, R.layout.table_menu_cell, this);
        imageIcon = (ImageView) view.findViewById(R.id.icon);
        name = (TextView) view.findViewById(R.id.name);
        imageHot = (ImageView) view.findViewById(R.id.image_hot);
        notice =  view.findViewById(R.id.notice);
    }
    
    public void show(final JumpAction action){
        imageIcon.setImageResource(action.getIconImgRes());
        name.setText(context.getString(action.getStringRes()));
        if (action.isHot()){
            imageHot.setVisibility(VISIBLE);
        }else{
            imageHot.setVisibility(GONE);
        }
        if(action.isNotice()){
            notice();
        }else{
            removeNotice();
        }
        setOnClickListener(new View.OnClickListener() {
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
