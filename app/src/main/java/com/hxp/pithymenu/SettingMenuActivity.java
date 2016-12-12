package com.hxp.pithymenu;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.hxp.pithymenu.pithyMenu.JumpAction;
import com.hxp.pithymenu.pithyMenu.ListMenuCell;

public class SettingMenuActivity extends BaseActivity {
    ListView listMenuGW;
    JumpAction[] actions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_menu);
        actions = new JumpAction[]{JumpAction.ACTION1,JumpAction.ACTION2,
                JumpAction.ACTION3,JumpAction.ACTION4,JumpAction.ACTION5,
                JumpAction.ACTION6,JumpAction.ACTION7,JumpAction.ACTION8};
        actions[3].setNotice(true);
        listMenuGW = (ListView) findViewById(R.id.list_menu_lv);

        listMenuGW.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return actions.length;
            }

            @Override
            public Object getItem(int i) {
                return actions[i];
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(final int i, View view, ViewGroup viewGroup) {
                view = new ListMenuCell(SettingMenuActivity.this);
                ((ListMenuCell)view).show(actions[i]);
                return view;
            }
        });
    }
}
