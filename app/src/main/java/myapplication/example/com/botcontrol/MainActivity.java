package myapplication.example.com.botcontrol;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import android.bluetooth.BluetoothAdapter;
import app.akexorcist.bluetotohspp.library.BluetoothSPP;
import app.akexorcist.bluetotohspp.library.BluetoothState;
import app.akexorcist.bluetotohspp.library.DeviceList;


import myapplication.example.com.botcontrol.Fragment.FifthFragment;
import myapplication.example.com.botcontrol.Fragment.FourthFragment;
import myapplication.example.com.botcontrol.Fragment.MainFragment;
import myapplication.example.com.botcontrol.Fragment.MyAdapter;
import myapplication.example.com.botcontrol.Fragment.PreviewFragment;
import myapplication.example.com.botcontrol.Fragment.SecondFragment;
import myapplication.example.com.botcontrol.Fragment.SixFragment;
import myapplication.example.com.botcontrol.Fragment.ThirdFragment;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Button ToPage1;
    Button ToPage2;
    Button ToPage3;
    Button ToPage4;
    Button ToPage5;
    Button ToPage6;
    Button ToPage7;
    BluetoothSPP bt;
    int keep = 0;
    byte[] dataOut2 = {(byte)255, 0, (byte)10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0};



    FourthFragment fourthFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInstances();
        if (savedInstanceState == null){
             getSupportFragmentManager().beginTransaction()
                     .add(R.id.contentContainer,new MainFragment())
                     .commit();
        }
        bt = new BluetoothSPP(this);
        if(!bt.isBluetoothAvailable()) {
            Toast.makeText(getApplicationContext(), "Bluetooth is not available", Toast.LENGTH_SHORT).show();
            finish();

        }
        bt.setOnDataReceivedListener(new BluetoothSPP.OnDataReceivedListener() {
            public void onDataReceived(byte[] data, String message) {

                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "Showed message", Toast.LENGTH_SHORT).show();

            }
        });

        bt.setBluetoothConnectionListener(new BluetoothSPP.BluetoothConnectionListener() {
            public void onDeviceConnected(String name, String address) {
                Toast.makeText(getApplicationContext(), "Connected to " + name + "\n" + address
                        , Toast.LENGTH_SHORT).show();
            }

            public void onDeviceDisconnected() {
                Toast.makeText(getApplicationContext(), "Connection lost", Toast.LENGTH_SHORT).show();
            }

            public void onDeviceConnectionFailed() {
                Toast.makeText(getApplicationContext(), "Unable to connect", Toast.LENGTH_SHORT).show();
            }
        });




    }
    public  void connect()
    {
        if(bt.getServiceState() == BluetoothState.STATE_CONNECTED) {
            bt.disconnect();
        } else {
            Intent intent = new Intent(getApplicationContext(), DeviceList.class);
            startActivityForResult(intent, BluetoothState.REQUEST_CONNECT_DEVICE);
        }
    }

    public void onStart() {
        super.onStart();
        if(!bt.isBluetoothEnabled()) {
            Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(intent, BluetoothState.REQUEST_ENABLE_BT);
        } else {
            if(!bt.isServiceAvailable()) {
                bt.setupService();
                bt.startService(BluetoothState.DEVICE_OTHER);
                setup();
            }
        }
    }
    public void setup() {
                bt.send("1", true);
                Toast.makeText(MainActivity.this,"Already sent", Toast.LENGTH_SHORT).show();
    }

    public void onDestroy() {
        super.onDestroy();
        bt.stopService();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == BluetoothState.REQUEST_CONNECT_DEVICE) {
            if(resultCode == Activity.RESULT_OK)
                bt.connect(data);
        } else if(requestCode == BluetoothState.REQUEST_ENABLE_BT) {
            if(resultCode == Activity.RESULT_OK) {
                bt.setupService();
                bt.startService(BluetoothState.DEVICE_OTHER);
                setup();
            } else {
                Toast.makeText(getApplicationContext(), "Bluetooth was not enabled."
                        , Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    public void sendMessage(String msg)
    {
        bt.send(msg,false);

    }
    public void sendMessage(byte[] msg)
    {

        bt.send(msg,false);
        Toast.makeText(getApplicationContext(),"SendDone",Toast.LENGTH_SHORT).show();

    }
    public void sendTypeGame(int check)
    {
        keep = check;
    }


    private void initInstances() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(
                MainActivity.this, drawerLayout, R.string.open_drawer, R.string.close_drawer
        );

        fourthFragment = FourthFragment.newInstance();




        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ToPage1 = (Button) findViewById(R.id.ToPage1);
        ToPage1.setOnClickListener(this);
        ToPage2 = (Button) findViewById(R.id.ToPage2);
        ToPage2.setOnClickListener(this);
        ToPage3 = (Button) findViewById(R.id.ToPage3);
        ToPage3.setOnClickListener(this);
        ToPage4 = (Button) findViewById(R.id.ToPage4);
        ToPage4.setOnClickListener(this);
        ToPage5 = (Button) findViewById(R.id.ToPage5);
        ToPage5.setOnClickListener(this);
        ToPage6 = (Button) findViewById(R.id.ToPage6);
        ToPage6.setOnClickListener(this);
        ToPage7 = (Button) findViewById(R.id.ToPage7);
        ToPage7.setOnClickListener(this);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);

    }

    public void onAdapterDone()
    {
        fourthFragment.getMyAdapter().setOnImageClickListener(new MyAdapter.OnImageClickListener() {
            @Override
            public void onImageClick(int i) {
                if( i< 28)
                {
                    dataOut2[2] = (byte)keep;
                    dataOut2[8] = (byte)1;
                    int j = 0;
                    j = i + 1;
                    dataOut2[9] = (byte)j;

                    dataOut2[12] = (byte)1;
                    dataOut2[13] = (byte)1;
                    dataOut2[14] = (byte)j;
                    sendMessage(dataOut2);
                }
                Toast.makeText(getApplicationContext(),"PassImage"+i,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v == ToPage1) {
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.contentContainer);

            if (fragment instanceof MainFragment == false) {

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentContainer,
                                MainFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(MainActivity.this, "FirstPage", Toast.LENGTH_SHORT).show();
        }
        if (v == ToPage2) {
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.contentContainer);

            if (fragment instanceof SecondFragment == false) {

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentContainer,
                                SecondFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(MainActivity.this, "SecondPage", Toast.LENGTH_SHORT).show();
        }
        if (v == ToPage3) {
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.contentContainer);

            if (fragment instanceof ThirdFragment == false) {

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentContainer,
                                ThirdFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(MainActivity.this, "ThirdPage", Toast.LENGTH_SHORT).show();
        }
        if (v == ToPage4) {
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.contentContainer);

            if (fragment instanceof FourthFragment == false) {

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentContainer,
                                fourthFragment)
                        .addToBackStack(null)
                        .commit();

            }
            drawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(MainActivity.this, "FourthPage", Toast.LENGTH_SHORT).show();

        }
        if (v == ToPage5) {
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.contentContainer);

            if (fragment instanceof FifthFragment == false) {

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentContainer,
                                FifthFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(MainActivity.this, "FifthPage", Toast.LENGTH_SHORT).show();

        }
        if (v == ToPage6) {
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.contentContainer);

            if (fragment instanceof SixFragment == false) {

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentContainer,
                                SixFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(MainActivity.this, "SixPage", Toast.LENGTH_SHORT).show();
        }

        if (v == ToPage7) {
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.contentContainer);

            if (fragment instanceof PreviewFragment == false) {

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentContainer,
                                PreviewFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(MainActivity.this, "SevenPage", Toast.LENGTH_SHORT).show();
        }

    }
}
