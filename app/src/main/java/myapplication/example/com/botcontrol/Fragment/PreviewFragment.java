package myapplication.example.com.botcontrol.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


import myapplication.example.com.botcontrol.MainActivity;
import myapplication.example.com.botcontrol.R;



/**
 * Created by nuuneoi on 11/16/2014.
 */
public class PreviewFragment extends Fragment implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, CompoundButton.OnCheckedChangeListener {

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
    ImageButton b1;
    ImageButton b2;
    ImageButton b3;
    ImageButton eye02;
    ImageButton eye05;
    ImageButton eye06;
    ToggleButton redButton;
    ToggleButton blueButton;
    ToggleButton greenButton;
    Button hello;
    Button niceToMeet;
    Button play;
    Button good1;
    Button good2;
    Button Motivate1;
    Button Motivate2;
    Button Motivate3;

    byte[] dataOut = {(byte)255, 0, 2, 1, 80, 80, 0, 0, 0, 0, 0, 0, 0, 0 ,0};
    byte[] dataOut4 = {(byte)255, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0};
    byte[] dataOutM = {(byte)255, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0};
    byte[] dataOut3 = {(byte)255, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0};



    String s;

    public PreviewFragment() {
        super();
    }

    public static PreviewFragment newInstance() {
        PreviewFragment fragment = new PreviewFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_preview, container, false);
        initInstances(rootView);
        return rootView;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (MainActivity) getActivity();
    }

    private void init(Bundle savedInstanceState) {
        // Init Fragment level's variable(s) here
    }

    private void initInstances(View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here
        Forward = (Button) rootView.findViewById(R.id.Forward);
        Forward.setOnClickListener(PreviewFragment.this);

        Back = (Button)rootView.findViewById(R.id.Back);
        Back.setOnClickListener(PreviewFragment.this);

        Right = (Button)rootView.findViewById(R.id.Right);
        Right.setOnClickListener(PreviewFragment.this);

        Left = (Button)rootView.findViewById(R.id.Left);
        Left.setOnClickListener(PreviewFragment.this);

        Stop = (Button)rootView.findViewById(R.id.Stop);
        Stop.setOnClickListener(PreviewFragment.this);

        seekBarLeft = (SeekBar)rootView.findViewById(R.id.seekBarLeft);
        seekBarLeft.setOnSeekBarChangeListener(PreviewFragment.this);

        seekBarRight = (SeekBar)rootView.findViewById(R.id.seekBarRight);
        seekBarRight.setOnSeekBarChangeListener(PreviewFragment.this);

        speedLeft = (TextView)rootView.findViewById(R.id.speedLeft);
        speedRight = (TextView)rootView.findViewById(R.id.speedRight);

        checkDefault = (CheckBox)rootView.findViewById(R.id.checkDefault);
        checkDefault.setOnCheckedChangeListener(PreviewFragment.this);

        b1 = (ImageButton) rootView.findViewById(R.id.b1);
        b1.setOnClickListener(PreviewFragment.this);
        b2 = (ImageButton) rootView.findViewById(R.id.b2);
        b2.setOnClickListener(PreviewFragment.this);
        b3 = (ImageButton) rootView.findViewById(R.id.b3);
        b3.setOnClickListener(PreviewFragment.this);
        eye02 = (ImageButton) rootView.findViewById(R.id.eye02);
        eye02.setOnClickListener(PreviewFragment.this);
        eye05 = (ImageButton) rootView.findViewById(R.id.eye05);
        eye05.setOnClickListener(PreviewFragment.this);
        eye06 = (ImageButton) rootView.findViewById(R.id.eye06);
        eye06.setOnClickListener(PreviewFragment.this);
        redButton = (ToggleButton) rootView.findViewById(R.id.redButton);
        redButton.setOnCheckedChangeListener(PreviewFragment.this);
        blueButton = (ToggleButton) rootView.findViewById(R.id.blueButton);
        blueButton.setOnCheckedChangeListener(PreviewFragment.this);
        greenButton = (ToggleButton) rootView.findViewById(R.id.greenButton);
        greenButton.setOnCheckedChangeListener(PreviewFragment.this);
        hello = (Button) rootView.findViewById(R.id.hello);
        hello.setOnClickListener(PreviewFragment.this);

        niceToMeet = (Button) rootView.findViewById(R.id.niceToMeet);
        niceToMeet.setOnClickListener(PreviewFragment.this);

        play = (Button) rootView.findViewById(R.id.play);
        play.setOnClickListener(PreviewFragment.this);
        good1 = (Button)rootView.findViewById(R.id.good1);
        good1.setOnClickListener(PreviewFragment.this);
        good2 = (Button)rootView.findViewById(R.id.good2);
        good2.setOnClickListener(PreviewFragment.this);

        Motivate1 = (Button)rootView.findViewById(R.id.Motivate1);
        Motivate1.setOnClickListener(PreviewFragment.this);
        Motivate2 = (Button)rootView.findViewById(R.id.Movivate2);
        Motivate2.setOnClickListener(PreviewFragment.this);
        Motivate3 = (Button)rootView.findViewById(R.id.Motivate3);
        Motivate3.setOnClickListener(PreviewFragment.this);

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
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore Instance State here
        }
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

        if(v == b1)
        {
            dataOut3[7] = (byte)2;
            activity.sendMessage(dataOut3);
        }
        if(v == b2)
        {
            dataOut3[7] = (byte)1;
            activity.sendMessage(dataOut3);
        }
        if(v == b3)
        {
            dataOut3[7] = (byte)3;
            activity.sendMessage(dataOut3);
        }
        if(v == eye02)
        {
            dataOut3[9] = (byte)2;
            activity.sendMessage(dataOut3);
        }
        if(v == eye05)
        {
            dataOut3[9] = (byte)5;
            activity.sendMessage(dataOut3);
        }
        if(v == eye06)
        {
            dataOut3[9] = (byte)6;
            activity.sendMessage(dataOut3);
        }
        if(v == hello)
        {
            dataOut4[6]=(byte)1;
            activity.sendMessage(dataOut4);
            Toast.makeText(getContext(),"PassMessage",Toast.LENGTH_SHORT).show();
        }
        if(v == niceToMeet)
        {
            dataOut4[6]= (byte)2;
            activity.sendMessage(dataOut4);
        }
        if(v== play)
        {
            dataOut4[6]=(byte)3;
            activity.sendMessage(dataOut4);
        }
        if(v == good1)
        {
            dataOut4[6] = (byte)13;
            activity.sendMessage(dataOut4);
        }
        if(v == good2)
        {
            dataOut4[6]= (byte)14;
            activity.sendMessage(dataOut4);
        }

        if(v== Motivate1)
        {
            dataOutM[3]=(byte)1;
            dataOutM[4]=(byte)19;
            activity.sendMessage(dataOutM);
        }
        if(v== Motivate2)
        {
            dataOutM[3] = (byte)2;
            activity.sendMessage(dataOutM);
        }
        if(v== Motivate3)
        {
            dataOutM[3] = (byte)3;
            activity.sendMessage(dataOutM);
        }


    }

    public void ByteToString(String[] argv)
    {
        String example = ("FORWARD");
        byte[] bytes = example.getBytes();
        //activity.sendMessage(""+bytes.toString());
        //("Text [Byte Format] : " + bytes.toString());


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
        byte[] dataOut3 = {(byte)255, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0};

        if (redButton.isPressed() == true)
        {
            if(redButton.isChecked()== true)
            {
                dataOut3[11] = (byte)8;
                activity.sendMessage(dataOut3);
            }
            else if (redButton.isChecked() == false)
            {
                dataOut3[11] = (byte)7;
                activity.sendMessage(dataOut3);
            }

        }
        if(greenButton.isPressed() == true)
        {
            if(greenButton.isChecked() == true)
            {
                dataOut3[11] = (byte)6;
                activity.sendMessage(dataOut3);
            }
            else if(greenButton.isChecked() == false)
            {
                dataOut3[11] = (byte)5;
                activity.sendMessage(dataOut3);
            }
        }

        if (blueButton.isPressed()==true)
        {
            if(blueButton.isChecked()== true)
            {
                dataOut3[11] = (byte)4;
                activity.sendMessage(dataOut3);
            }
            else if (blueButton.isChecked()==false)
            {
                dataOut3[11] = (byte)3;
                activity.sendMessage(dataOut3);
            }
        }

    }
}
