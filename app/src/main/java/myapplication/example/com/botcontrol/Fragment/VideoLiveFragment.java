package myapplication.example.com.botcontrol.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import myapplication.example.com.botcontrol.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VideoLiveFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VideoLiveFragment extends Fragment {

    public VideoLiveFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment VideoLiveFragment.
     */
    public static VideoLiveFragment newInstance() {
        VideoLiveFragment fragment = new VideoLiveFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_video_live, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
