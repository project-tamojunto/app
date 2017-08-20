package com.ambev.tamojunto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.ambev.tamojunto.adapter.ScheduleCustomAdapter;
import com.ambev.tamojunto.model.Data;

import java.util.ArrayList;

public class MySchedulesActivity extends AppCompatActivity {


    private ScheduleCustomAdapter schedulesCustomAdapter;
    private ArrayList<Data> schedules;
    private ListView listViewSchedules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_schedules);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listViewSchedules = (ListView) findViewById(R.id.listSchedules);

        schedules = new ArrayList<Data>();
        schedules.add(new Data(1,"22/04/17", "18:00", "22:00", 5));
        schedules.add(new Data(1,"22/04/17", "18:00", "22:00", 5));
        schedules.add(new Data(1,"22/04/17", "18:00", "22:00", 5));
        schedules.add(new Data(1,"22/04/17", "18:00", "22:00", 5));
        schedules.add(new Data(1,"22/04/17", "18:00", "22:00", 5));
        schedules.add(new Data(1,"22/04/17", "18:00", "22:00", 5));
        schedules.add(new Data(1,"22/04/17", "18:00", "22:00", 5));
        schedules.add(new Data(1,"22/04/17", "18:00", "22:00", 5));
        schedules.add(new Data(1,"22/04/17", "18:00", "22:00", 5));

        schedulesCustomAdapter = new ScheduleCustomAdapter(schedules, getBaseContext());

        if (schedulesCustomAdapter != null) {
            listViewSchedules.setAdapter(schedulesCustomAdapter);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}
