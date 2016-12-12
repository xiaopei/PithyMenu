package com.hxp.pithymenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showMenu(View view){
        switch (view.getId()){
            case R.id.table_menu:
                startActivity(new Intent(this,TableMenuActivity.class));
                break;
            case R.id.list_menu:
                startActivity(new Intent(this,SettingMenuActivity.class));
                break;
        }
    }
}
