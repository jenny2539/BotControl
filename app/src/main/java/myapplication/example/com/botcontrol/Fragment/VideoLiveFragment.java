package myapplication.example.com.botcontrol.Fragment;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import myapplication.example.com.botcontrol.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VideoLiveFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VideoLiveFragment extends Fragment {

//    Button playButton;
    VideoView rtspVideo;

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
        rtspVideo = (VideoView) rootView.findViewById(R.id.rtspVideo);
        rtspVideo.setMediaController(new MediaController(getActivity()));
        rtspVideo.requestFocus();
//        rtspVideo.setVideoURI(Uri.parse("rtsp://192.168.1.149:8554/"));
        rtspVideo.setVideoURI(Uri.parse("rtsp://184.72.239.149/vod/mp4:BigBuckBunny_175k.mov"));
//        rtspVideo.seekTo(0);
        rtspVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        rtspVideo.start();
//    }

//    @Override
//    public void onDetach() {
//        super.onDetach();
//        rtspVideo.stopPlayback();
//    }
    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
//        rtspVideo.start();
        super.onPause();
    }
}
