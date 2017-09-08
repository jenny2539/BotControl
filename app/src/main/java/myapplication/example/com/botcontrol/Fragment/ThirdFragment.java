package myapplication.example.com.botcontrol.Fragment;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ToggleButton;

import myapplication.example.com.botcontrol.MainActivity;
import myapplication.example.com.botcontrol.R;



/**
 * Created by nuuneoi on 11/16/2014.
 */
@SuppressWarnings("unused")
public class ThirdFragment extends Fragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    ImageButton b1;
    ImageButton b2;
    ImageButton b3;
    ImageButton eye01;
    ImageButton eye02;
    ImageButton eye03;
    ImageButton eye04;
    ImageButton eye05;
    ImageButton eye06;
    ImageButton eye07;
    ImageButton eye08;
    ToggleButton redButton;
    ToggleButton blueButton;
    ToggleButton greenButton;
    ToggleButton allLight;
    MainActivity activity;
    byte[] dataOut3 = {(byte)255, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0};

    public ThirdFragment() {
        super();
    }

    @SuppressWarnings("unused")
    public static ThirdFragment newInstance() {
        ThirdFragment fragment = new ThirdFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_third, container, false);
        initInstances(rootView, savedInstanceState);
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

    @SuppressWarnings("UnusedParameters")
    private void initInstances(View rootView, Bundle savedInstanceState) {
        // Init 'View' instance(s) with rootView.findViewById here
        b1 = (ImageButton) rootView.findViewById(R.id.b1);
        b1.setOnClickListener(ThirdFragment.this);
        b2 = (ImageButton) rootView.findViewById(R.id.b2);
        b2.setOnClickListener(ThirdFragment.this);
        b3 = (ImageButton) rootView.findViewById(R.id.b3);
        b3.setOnClickListener(ThirdFragment.this);
        eye01 = (ImageButton) rootView.findViewById(R.id.eye01);
        eye01.setOnClickListener(ThirdFragment.this);
        eye02 = (ImageButton) rootView.findViewById(R.id.eye02);
        eye02.setOnClickListener(ThirdFragment.this);
        eye03 = (ImageButton) rootView.findViewById(R.id.eye03);
        eye03.setOnClickListener(ThirdFragment.this);
        eye04 = (ImageButton) rootView.findViewById(R.id.eye04);
        eye04.setOnClickListener(ThirdFragment.this);
        eye05 = (ImageButton) rootView.findViewById(R.id.eye05);
        eye05.setOnClickListener(ThirdFragment.this);
        eye06 = (ImageButton) rootView.findViewById(R.id.eye06);
        eye06.setOnClickListener(ThirdFragment.this);
        eye07 = (ImageButton) rootView.findViewById(R.id.eye07);
        eye07.setOnClickListener(ThirdFragment.this);
        eye08 = (ImageButton) rootView.findViewById(R.id.eye08);
        eye08.setOnClickListener(ThirdFragment.this);
        redButton = (ToggleButton) rootView.findViewById(R.id.redButton);
        redButton.setOnCheckedChangeListener(ThirdFragment.this);
        blueButton = (ToggleButton) rootView.findViewById(R.id.blueButton);
        blueButton.setOnCheckedChangeListener(ThirdFragment.this);
        greenButton = (ToggleButton) rootView.findViewById(R.id.greenButton);
        greenButton.setOnCheckedChangeListener(ThirdFragment.this);
        allLight = (ToggleButton) rootView.findViewById(R.id.allLight);
        allLight.setOnCheckedChangeListener(ThirdFragment.this);
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
    public void onClick(View v) {
        byte[] dataOut3 = {(byte)255, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0};
        if(v == b1)
        {
            dataOut3[7] = (byte)2;
            activity.sendMessage(dataOut3);
        }
        else if(v == b2)
        {
            dataOut3[7] = (byte)1;
            activity.sendMessage(dataOut3);
        }
        else if(v == b3)
        {
            dataOut3[7] = (byte)3;
            activity.sendMessage(dataOut3);
        }


        if(v == eye01)
        {
            dataOut3[9] = (byte)1;
            activity.sendMessage(dataOut3);
        }
        else if(v == eye02)
        {
            dataOut3[9] = (byte)2;
            activity.sendMessage(dataOut3);
        }
        else if(v == eye03)
        {
            dataOut3[9] = (byte)3;
            activity.sendMessage(dataOut3);
        }
        else if(v == eye04)
        {
            dataOut3[9] = (byte)4;
            activity.sendMessage(dataOut3);
        }
        else if(v == eye05)
        {
            dataOut3[9] = (byte)5;
            activity.sendMessage(dataOut3);
        }
        else if(v == eye06)
        {
            dataOut3[9] = (byte)6;
            activity.sendMessage(dataOut3);
        }
        else if(v == eye07)
        {
            dataOut3[9] = (byte)7;
            activity.sendMessage(dataOut3);
        }
        else if(v == eye08)
        {
            dataOut3[9] = (byte)8;
            activity.sendMessage(dataOut3);
        }

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
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

        if(allLight.isPressed())
        {
            if(allLight.isChecked()== true)
            {
                dataOut3[11] = (byte)2;
                activity.sendMessage(dataOut3);
            }
            else if (allLight.isChecked()==false)
            {
                dataOut3[11] = (byte)1;
                activity.sendMessage(dataOut3);
            }
        }

    }
}
