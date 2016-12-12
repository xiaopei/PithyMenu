package com.hxp.pithymenu;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.hxp.pithymenu.pithyMenu.JumpAction;
import com.hxp.pithymenu.pithyMenu.TableMenuCell;

public class TableMenuActivity extends BaseActivity {
    GridView tableMenuGW;
    JumpAction[] actions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_menu);
        actions = new JumpAction[]{JumpAction.ACTION1,JumpAction.ACTION2,
                JumpAction.ACTION3,JumpAction.ACTION4,JumpAction.ACTION5,
                JumpAction.ACTION6,JumpAction.ACTION7,JumpAction.ACTION8};
        actions[3].setNotice(true);
        tableMenuGW = (GridView) findViewById(R.id.table_menu_gv);

        tableMenuGW.setAdapter(new BaseAdapter() {
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
                view = new TableMenuCell(TableMenuActivity.this);
                ((TableMenuCell)view).show(actions[i]);
                return view;
            }
        });
    }
}
