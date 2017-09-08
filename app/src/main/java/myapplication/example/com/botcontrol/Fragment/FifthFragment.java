package myapplication.example.com.botcontrol.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import myapplication.example.com.botcontrol.MainActivity;
import myapplication.example.com.botcontrol.R;



/**
 * Created by nuuneoi on 11/16/2014.
 */
@SuppressWarnings("unused")
public class FifthFragment extends Fragment implements View.OnClickListener {

    Button hello;
    Button niceToMeet;
    Button play;
    Button hry;
    Button correct;
    Button right1;
    Button good1;
    Button good2;
    Button excellence;
    Button incorrect;
    Button tryAgain1;
    Button wrong;
    Button tryAgain2;
    Button notRight;
    Button goodbye;
    Button seeLater;
    Button seeAgain;
    MainActivity activity;
    byte[] dataOut = {(byte)255, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0};



    public FifthFragment() {
        super();
    }

    @SuppressWarnings("unused")
    public static FifthFragment newInstance() {
        FifthFragment fragment = new FifthFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_fifth, container, false);
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
        hello = (Button) rootView.findViewById(R.id.hello);
        hello.setOnClickListener(FifthFragment.this);

        niceToMeet = (Button) rootView.findViewById(R.id.niceToMeet);
        niceToMeet.setOnClickListener(FifthFragment.this);

        play = (Button) rootView.findViewById(R.id.play);
        play.setOnClickListener(FifthFragment.this);

        hry = (Button) rootView.findViewById(R.id.hry);
        hry.setOnClickListener(FifthFragment.this);

        correct = (Button) rootView.findViewById(R.id.correct);
        correct.setOnClickListener(FifthFragment.this);

        right1 = (Button) rootView.findViewById(R.id.right1);
        right1.setOnClickListener(FifthFragment.this);

        good1 = (Button)rootView.findViewById(R.id.good1);
        good1.setOnClickListener(FifthFragment.this);

        good2 = (Button)rootView.findViewById(R.id.good2);
        good2.setOnClickListener(FifthFragment.this);

        excellence = (Button)rootView.findViewById(R.id.excellence);
        excellence.setOnClickListener(FifthFragment.this);

        incorrect = (Button)rootView.findViewById(R.id.incorrect);
        incorrect.setOnClickListener(FifthFragment.this);
        tryAgain1 = (Button)rootView.findViewById(R.id.tryAgain1);
        tryAgain1.setOnClickListener(FifthFragment.this);
        wrong = (Button)rootView.findViewById(R.id.wrong);
        wrong.setOnClickListener(FifthFragment.this);
        tryAgain2 = (Button)rootView.findViewById(R.id.tryAgain2);
        tryAgain2.setOnClickListener(FifthFragment.this);
        notRight = (Button)rootView.findViewById(R.id.notRight);
        notRight.setOnClickListener(FifthFragment.this);
        goodbye = (Button)rootView.findViewById(R.id.goodbye);
        goodbye.setOnClickListener(FifthFragment.this);
        seeLater = (Button)rootView.findViewById(R.id.seeLater);
        seeLater.setOnClickListener(FifthFragment.this);
        seeAgain = (Button)rootView.findViewById(R.id.seeAgain);
        seeAgain.setOnClickListener(FifthFragment.this);

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
        if(v == hello)
        {
            dataOut[6]=(byte)1;
            activity.sendMessage(dataOut);
            Toast.makeText(getContext(),"PassMessage",Toast.LENGTH_SHORT).show();
        }
        if(v == niceToMeet)
        {
            dataOut[6]= (byte)2;
            activity.sendMessage(dataOut);
        }
        if(v== play)
        {
            dataOut[6]=(byte)3;
            activity.sendMessage(dataOut);
        }
        if(v == hry)
        {
            dataOut[6] = (byte)4;
            activity.sendMessage(dataOut);
        }
        if(v == correct)
        {
            dataOut[6] = (byte)11;
            activity.sendMessage(dataOut);
        }
        if(v == right1)
        {
            dataOut[6] = (byte)12;
            activity.sendMessage(dataOut);
        }
        if(v == good1)
        {
            dataOut[6] = (byte)13;
            activity.sendMessage(dataOut);
        }
        if(v == good2)
        {
            dataOut[6]= (byte)14;
            activity.sendMessage(dataOut);
        }
        if(v == excellence)
        {
            dataOut[6] = (byte)15;
            activity.sendMessage(dataOut);
        }
        if(v == incorrect)
        {
            dataOut[6] = (byte)21;
            activity.sendMessage(dataOut);
        }
        if(v == tryAgain1)
        {
            dataOut[6] = (byte)22;
            activity.sendMessage(dataOut);
        }
        if(v == wrong)
        {
            dataOut[6] = (byte)23;
            activity.sendMessage(dataOut);
        }
        if(v == tryAgain2)
        {
            dataOut[6] = (byte)24;
            activity.sendMessage(dataOut);
        }
        if(v == notRight)
        {
            dataOut[6] = (byte)25;
            activity.sendMessage(dataOut);
        }
        if(v == goodbye)
        {
            dataOut[6] = (byte)31;
            activity.sendMessage(dataOut);
        }
        if(v == seeLater)
        {
            dataOut[6] = (byte)32;
            activity.sendMessage(dataOut);
        }
        if(v == seeAgain)
        {
            dataOut[6] = (byte)33;
            activity.sendMessage(dataOut);
        }

    }
}
