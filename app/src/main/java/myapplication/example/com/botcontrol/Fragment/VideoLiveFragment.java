package myapplication.example.com.botcontrol.Fragment;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.Toast;
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
        rtspVideo.requestFocus();
//        rtspVideo.setOnErrorListener(new MediaPlayer.OnErrorListener() {
//            @Override
//            public boolean onError(MediaPlayer mediaPlayer, int what, int extra) {
//                handleError(what);
//                return true;
//            }
//        });
//        rtspVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mediaPlayer) {
//                mediaPlayer.start();
//            }
//        });
        rtspVideo.setVideoURI(Uri.parse("http://192.168.1.149:9090/"));
        rtspVideo.start();
    }

    private void handleError(int code) {
        if(code == MediaPlayer.MEDIA_ERROR_IO) {
            Toast.makeText(getContext(), "Error IO", Toast.LENGTH_SHORT).show();
        }
        else if(code == MediaPlayer.MEDIA_ERROR_MALFORMED) {
            Toast.makeText(getContext(), "Error Malformed", Toast.LENGTH_SHORT).show();
        }
        else if(code == MediaPlayer.MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK) {
            Toast.makeText(getContext(), "Error not valid for progressive playback", Toast.LENGTH_SHORT).show();
        }
        else if(code == MediaPlayer.MEDIA_ERROR_SERVER_DIED) {
            Toast.makeText(getContext(), "Error Server died", Toast.LENGTH_SHORT).show();
        }
        else if(code == MediaPlayer.MEDIA_ERROR_TIMED_OUT) {
            Toast.makeText(getContext(), "Error Timed Out", Toast.LENGTH_SHORT).show();
        }
        else if(code == MediaPlayer.MEDIA_ERROR_UNKNOWN) {
            Toast.makeText(getContext(), "Error Unknown", Toast.LENGTH_SHORT).show();
        }
        else if(code == MediaPlayer.MEDIA_ERROR_UNSUPPORTED) {
            Toast.makeText(getContext(), "Error Unsupported", Toast.LENGTH_SHORT).show();
        }
    }
}
