package myapplication.example.com.botcontrol.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;


import java.util.ArrayList;

import myapplication.example.com.botcontrol.MainActivity;
import myapplication.example.com.botcontrol.R;


/**
 * Created by nuuneoi on 11/16/2014.
 */
@SuppressWarnings("unused")
public class FourthFragment extends Fragment implements View.OnClickListener {

    MainActivity activity;
    MyAdapter myAdapter;
    RecyclerView recyclerView;
    RadioButton first;
    RadioButton second;
    RadioButton third;
    RadioButton fourth;


    public MyAdapter getMyAdapter(){
        if(myAdapter == null)
            Log.e("CheckNULL","IN22 NULLLL");
        return myAdapter;
    }




    private final String image_titles[] = {
            "มด",
            "ผึ้ง",
            "นก",
            "ควาย",
            "ผีเสื้อ",
            "แมว",
            "ไก่",
            "ปู",
            "สุนัข",
            "เป็ด",
            "ช้าง",
            "ปลา",
            "กบ",
            "ม้า",
            "ลิง",
            "หมู",
            "กระต่าย",
            "งู",
            "เสือ",
            "เต่า","กวาง","ยีราฟ","สิงโต","กระรอก","ฉลาม","หนู","หอยทาก"
            //,"Img28","Img29",
            //"Img30","Img31","Img32","Img33","Img34","Img35","Im36","Img37","Img38","Img39",
            //"Img40","Img41","Img42","Img43","Img44","Img45","Img46","Img47","Img48","Img49","Img50","Img51","Img52","Img53"
    };

    private final Integer image_ids[] = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7,
            R.drawable.img8,
            R.drawable.img9,
            R.drawable.img10,
            R.drawable.img11,
            R.drawable.img12,
            R.drawable.img13,R.drawable.img14,R.drawable.img15,R.drawable.img16,R.drawable.img17,R.drawable.img18,R.drawable.img19,R.drawable.img20,
            R.drawable.img21,R.drawable.img22,R.drawable.img23,R.drawable.img24,R.drawable.img25,R.drawable.img26,R.drawable.img27,
            //R.drawable.img28,
            //R.drawable.img29,R.drawable.img30,R.drawable.img31,R.drawable.img32,R.drawable.img33,R.drawable.img34,R.drawable.img35,R.drawable.img36,
            //R.drawable.img37,R.drawable.img38,R.drawable.img39,R.drawable.img40,R.drawable.img41,R.drawable.img42,R.drawable.img43,R.drawable.img44,
            //R.drawable.img45,R.drawable.img46,R.drawable.img47,R.drawable.img48,R.drawable.img49,R.drawable.img50,R.drawable.img51,R.drawable.img52,R.drawable.img53

    };
    private FragmentManager supportFragmentManager;

    public FourthFragment() {
        super();
    }

    @SuppressWarnings("unused")
    public static FourthFragment newInstance() {
        FourthFragment fragment = new FourthFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (MainActivity) getActivity();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);

        if (savedInstanceState != null)
            onRestoreInstanceState(savedInstanceState);

    }



    private ArrayList<CreateList> prepareData(){

        ArrayList<CreateList> theimage = new ArrayList<>();
        for(int i = 0; i< image_titles.length; i++){
            CreateList createList = new CreateList();
            createList.setImage_title(image_titles[i]);
            createList.setImage_ID(image_ids[i]);
            theimage.add(createList);
        }
        return theimage;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fourth, container, false);
        initInstances(rootView, savedInstanceState);
        return rootView;
    }

    private void init(Bundle savedInstanceState) {
        // Init Fragment level's variable(s) here
    }

    @SuppressWarnings("UnusedParameters")
    private void initInstances(View rootView, Bundle savedInstanceState) {
        // Init 'View' instance(s) with rootView.findViewById here
        first = (RadioButton)rootView.findViewById(R.id.first);
        first.setOnClickListener(FourthFragment.this);
        second = (RadioButton)rootView.findViewById(R.id.second);
        second.setOnClickListener(FourthFragment.this);
        third = (RadioButton)rootView.findViewById(R.id.third);
        third.setOnClickListener(FourthFragment.this);
        fourth = (RadioButton)rootView.findViewById(R.id.fourth);
        fourth.setOnClickListener(FourthFragment.this);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.imageGallery);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<CreateList> createLists = prepareData();
        myAdapter = new MyAdapter(getContext(), createLists);
        recyclerView.setAdapter(myAdapter);

        try{
            activity.onAdapterDone();
        }catch (NullPointerException e){
            Log.e("Check error","error: " + e.getMessage());
        }

    }

    public void imgSend2()
    {
       // activity.sendMessage(dataOut2);

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
        if(v == first){
            Toast.makeText(getContext(), "1", Toast.LENGTH_SHORT).show();

            activity.sendTypeGame(10);

        }

        else if(v == second){
            Toast.makeText(getContext(), "2", Toast.LENGTH_SHORT).show();
            activity.sendTypeGame(20);
        }
        else if(v == third){
            Toast.makeText(getContext(), "3", Toast.LENGTH_SHORT).show();
            activity.sendTypeGame(21);

        }
        else if(v == fourth){
            Toast.makeText(getContext(), "4", Toast.LENGTH_SHORT).show();
            activity.sendTypeGame(30);

        }
    }
}
