package org.techtown.hackytalky.view;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.techtown.hackytalky.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private BluetoothAdapter bleAdapter;
    private BluetoothLeScanner bleScanner;
    private final ActivityResultLauncher<String> requestPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    // FCM SDK (and your app) can post notifications.
                } else {
                    // TODO: Inform user that that your app will not show notifications.
                }
            });

    private void askNotificationPermission() {
        // This is only necessary for API level >= 33 (TIRAMISU)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) ==
                    PackageManager.PERMISSION_GRANTED) {
                // FCM SDK (and your app) can post notifications.
            } else if (shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS)) {
                // TODO: display an educational UI explaining to the user the features that will be enabled
                //       by them granting the POST_NOTIFICATION permission. This UI should provide the user
                //       "OK" and "No thanks" buttons. If the user selects "OK," directly request the permission.
                //       If the user selects "No thanks," allow the user to continue without notifications.
            } else {
                // Directly ask for the permission
                requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startScan();

        Button mainButton = findViewById(R.id.main_button);

        mainButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, PuzzleActivity.class);
                startActivity(intent);
            }
        });

        
        BluetoothManager bleManager;
        bleManager= (BluetoothManager)getSystemService(Context.BLUETOOTH_SERVICE);
        bleAdapter = bleManager.getAdapter();
    }
    private void startScan() {
        if (bleAdapter == null || !bleAdapter.isEnabled()) {
            requestEnableBLE();
            return;
        }
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestLocationPermission();
            return;
        }

        ScanSettings settings= new ScanSettings.Builder()
                .setScanMode( ScanSettings.SCAN_MODE_LOW_POWER )
                .build();
        Map<String, BluetoothDevice> scanResults = new HashMap<>();
        ScanCallback scanCallback = new BLEScanCallback(scanResults);

        bleScanner.startScan(new ArrayList<>(), settings, scanCallback);
    }

    private static class BLEScanCallback extends ScanCallback {
        private final Map<String, BluetoothDevice> cbScanResults;
        BLEScanCallback( Map<String, BluetoothDevice> _scan_results ) {
            cbScanResults = _scan_results;
        }
        @Override
        public void onScanResult( int _callback_type, ScanResult _result ) {
            addScanResult( _result );
        }
        @Override
        public void onBatchScanResults( List<ScanResult> _results ) {
            for( ScanResult result: _results ) {
                addScanResult( result );
            }
        }
        private void addScanResult( ScanResult _result ) {
            BluetoothDevice device= _result.getDevice();
            String device_address= device.getAddress();
            cbScanResults.put( device_address, device );
            Log.d( "BLEEE", "scan results device: " + device );
        }
    }
    private void requestEnableBLE() {
        Intent ble_enable_intent= new Intent( BluetoothAdapter.ACTION_REQUEST_ENABLE );
    }
    private void requestLocationPermission() {
        requestPermissions( new String[]{ Manifest.permission.ACCESS_FINE_LOCATION}, 2 );
    }
}