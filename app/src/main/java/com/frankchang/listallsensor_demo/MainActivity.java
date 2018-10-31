package com.frankchang.listallsensor_demo;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ListView list;
    private SensorManager managers;
    private List<Sensor> sensorList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.list);

        // 取得傳感器物件
        managers = (SensorManager) getSystemService(SENSOR_SERVICE);
        if (managers != null) {
            sensorList = managers.getSensorList(Sensor.TYPE_ALL);
        }

        ArrayList<String> arrayList = new ArrayList<>();

        for (Sensor sensor : sensorList) {
            arrayList.add(sensor.getName() + " : " + sensor.getVendor());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, arrayList);
        list.setAdapter(adapter);
    }

}
