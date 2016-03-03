package com.nightonke.wowoviewpagerexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;

public class SetEaseTypeActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener{

    private ListView listView;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_ease_type);

        listView = (ListView)findViewById(R.id.listview);
        listView.setAdapter(new SetEaseTypeAdapter(this));
        listView.setOnItemClickListener(this);

        checkBox = (CheckBox)findViewById(R.id.checkbox);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.listview:
                Intent intent = new Intent(this, WoWoTranslationAnimationActivity.class);
                intent.putExtra("easeType", position);
                intent.putExtra("useSameEaseTypeBack", checkBox.isChecked());
                startActivity(intent);
                break;
        }
    }
}