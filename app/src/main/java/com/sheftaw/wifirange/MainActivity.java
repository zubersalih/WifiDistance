package com.sheftaw.wifirange;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    WifiManager wifiManager;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        ListView lv = findViewById(R.id.listview);

        getList(lv);

    }

    private void getList(ListView lv) {
        String[] from = new String[]{"rowid", "ssid", "network_name", "level"};
        int[] to = new int[]{R.id.item1, R.id.item2, R.id.item3, R.id.item4};
        List<ScanResult> results = wifiManager.getScanResults();
        List<HashMap<String, String>> rssiList = new ArrayList<>();

        for (int i = 0; i < results.size(); i++) {
            HashMap<String, String> map = new HashMap<>();
            map.put("rowid", "" + i);
            map.put("ssid", results.get(i).SSID);
            map.put("network_name", String.format("%.2f", calculateDistance(results.get(i).level, results.get(i).frequency)) + "M");
            map.put("level", Double.toString(WifiManager.calculateSignalLevel(results.get(i).level, 5)));
            System.out.println(results.get(i).SSID + " : " + results.get(i).BSSID + "  hERE");
            rssiList.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, rssiList, R.layout.listview_row, from, to);
        lv.setAdapter(adapter);
    }


    public double calculateDistance(double signalLevelInDb, double freqInMHz) {
        double exp = (27.55 - (20 * Math.log10(freqInMHz)) + Math.abs(signalLevelInDb)) / 20.0;
        return Math.pow(10.0, exp);
    }

}