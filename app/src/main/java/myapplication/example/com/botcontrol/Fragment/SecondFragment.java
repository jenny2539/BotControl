package myapplication.example.com.botcontrol.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.BundleCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;
import myapplication.example.com.botcontrol.MainActivity;
import myapplication.example.com.botcontrol.R;



/**
 * Created by nuuneoi on 11/16/2014.
 */
@SuppressWarnings("unused")
public class SecondFragment extends Fragment implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, CompoundButton.OnCheckedChangeListener {

    MainActivity activity;
    Button Forward;
    Button Back;
    Button Right;
    Button Left;
    Button Stop;
    SeekBar seekBarRight;
    SeekBar seekBarLeft;
    TextView speedRight;
    TextView speedLeft;
    CheckBox checkDefault;
    String s;
    byte[] dataOut = {(byte)255, 0, 2, 1, 80, 80, 0, 0, 0, 0, 0, 0, 0, 0 ,0};
    public SecondFragment() {
        super();
    }

    @SuppressWarnings("unused")
    public static SecondFragment newInstance() {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);

        if (savedInstanceState != null)
            onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_second, container, false);
        initInstances(rootView, savedInstanceState);
        return rootView;
    }

    private void init(Bundle savedInstanceState) {
        // Init Fragment level's variable(s) here

    }

    @SuppressWarnings("UnusedParameters")
    private void initInstances(View rootView, Bundle savedInstanceState) {
        // Init 'View' instance(s) with rootView.findViewById here
        Forward = (Button) rootView.findViewById(R.id.Forward);
        Forward.setOnClickListener(SecondFragment.this);

        Back = (Button)rootView.findViewById(R.id.Back);
        Back.setOnClickListener(SecondFragment.this);

        Right = (Button)rootView.findViewById(R.id.Right);
        Right.setOnClickListener(SecondFragment.this);

        Left = (Button)rootView.findViewById(R.id.Left);
        Left.setOnClickListener(SecondFragment.this);

        Stop = (Button)rootView.findViewById(R.id.Stop);
        Stop.setOnClickListener(SecondFragment.this);

        seekBarLeft = (SeekBar)rootView.findViewById(R.id.seekBarLeft);
        seekBarLeft.setOnSeekBarChangeListener(SecondFragment.this);

        seekBarRight = (SeekBar)rootView.findViewById(R.id.seekBarRight);
        seekBarRight.setOnSeekBarChangeListener(SecondFragment.this);

        speedLeft = (TextView)rootView.findViewById(R.id.speedLeft);
        speedRight = (TextView)rootView.findViewById(R.id.speedRight);

        checkDefault = (CheckBox)rootView.findViewById(R.id.checkDefault);
        checkDefault.setOnCheckedChangeListener(SecondFragment.this);

    }

    public void ByteToString(String[] argv)
    {
        String example = ("FORWARD");
        byte[] bytes = example.getBytes();
        //activity.sendMessage(""+bytes.toString());
        //("Text [Byte Format] : " + bytes.toString());


    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    /*
     * Save Instance State Here
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance State here
    }

    /*
     * Restore Instance State Here
     */
    @SuppressWarnings("UnusedParameters")
    private void onRestoreInstanceState(Bundle savedInstanceState) {
        // Restore Instance State here
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (MainActivity) getActivity();
    }


    @Override
    public void onClick(View v) {
        if(v == Forward)
        {
            Toast.makeText(getContext(), "Forward", Toast.LENGTH_SHORT).show();

            dataOut[3] = (byte)1;
            dataOut[4] = (byte)seekBarLeft.getProgress();
            dataOut[5] = (byte)seekBarRight.getProgress();
            activity.sendMessage(dataOut);

        }
        if(v == Back)
        {
            dataOut[3] = (byte)4;
            dataOut[4] = (byte)seekBarLeft.getProgress();
            dataOut[5] = (byte)seekBarRight.getProgress();

            activity.sendMessage(dataOut);
            Toast.makeText(getContext(), "Back", Toast.LENGTH_SHORT).show();
        }
        if(v == Right)
        {
            dataOut[3] = (byte)2;
            dataOut[4] = (byte)seekBarLeft.getProgress();
            dataOut[5] = (byte)seekBarRight.getProgress();

            activity.sendMessage(dataOut);
            Toast.makeText(getContext(), "Right", Toast.LENGTH_SHORT).show();
        }
        if(v == Left)
        {

            dataOut[3] = (byte)3;
            dataOut[4] = (byte)seekBarLeft.getProgress();
            dataOut[5] = (byte)seekBarRight.getProgress();

            activity.sendMessage(dataOut);
            Toast.makeText(getContext(), "Left", Toast.LENGTH_SHORT).show();
        }
        if(v == Stop)
        {
            dataOut[3] = (byte)1;
            dataOut[4] = (byte)0;
            dataOut[5] = (byte)0;
            activity.sendMessage(dataOut);

        }
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        speedLeft.setText(""+seekBarLeft.getProgress());
        speedRight.setText(""+seekBarRight.getProgress());
        if(checkDefault.isChecked()== true)
        {
            if(seekBarLeft.isPressed()== true)
            {
                seekBarRight.setProgress(seekBarLeft.getProgress());
                dataOut[4] = (byte)seekBarLeft.getProgress();
                dataOut[5] = (byte)seekBarRight.getProgress();
            }
            else if (seekBarRight.isPressed() == true)
            {
                seekBarLeft.setProgress(seekBarRight.getProgress());
                dataOut[4] = (byte)seekBarLeft.getProgress();
                dataOut[5] = (byte)seekBarRight.getProgress();
            }
        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

        Toast.makeText(getContext(),"Set Speed",Toast.LENGTH_SHORT).show();
        dataOut[4] = (byte)seekBarLeft.getProgress();
        dataOut[5] = (byte)seekBarRight.getProgress();

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked == true)
        {
            seekBarRight.setProgress(seekBarLeft.getProgress());
        }
    }


}
