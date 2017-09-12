package myapplication.example.com.botcontrol.Fragment;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.videolan.libvlc.IVLCVout;
import org.videolan.libvlc.LibVLC;
import org.videolan.libvlc.Media;
import org.videolan.libvlc.MediaPlayer;

import java.util.ArrayList;

import myapplication.example.com.botcontrol.R;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 * to handle interaction events.
 * Use the {@link VideoLive2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VideoLive2Fragment extends Fragment implements IVLCVout.Callback {

    private static final String TAG = "VideoLive2Fragment";
    private static final String VIDEO_URL = "http://blissbot:9090/";

    private IVLCVout vlcVout;
    private MediaPlayer mMediaPlayer;
    private LibVLC mLibVLC;
    private int mVideoWidth = 0;
    private int mVideoHeight = 0;
    private int mVideoVisibleHeight = 0;
    private int mVideoVisibleWidth = 0;
    private int mVideoSarNum = 0;
    private int mVideoSarDen = 0;

    private LinearLayoutCompat linearLayout;
    private SurfaceView mSurfaceView;
    private View.OnLayoutChangeListener mOnLayoutChangeListener;
    private Handler mHandler = new Handler();

    private ProgressBar prograssBar;

    public VideoLive2Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment.
     *
     * @return A new instance of fragment VideoLive2Fragment.
     */
    public static VideoLive2Fragment newInstance() {
        VideoLive2Fragment fragment = new VideoLive2Fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ArrayList<String> args = new ArrayList<>();
        args.add("-vvv");
        mLibVLC = new LibVLC(getContext(), args);
        mMediaPlayer = new MediaPlayer(mLibVLC);
        vlcVout = mMediaPlayer.getVLCVout();
        vlcVout.addCallback(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_video_live2, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        linearLayout = (LinearLayoutCompat) rootView.findViewById(R.id.linearLayout);
        mSurfaceView = (SurfaceView) rootView.findViewById(R.id.videoSurfaceView);
        prograssBar = (ProgressBar) rootView.findViewById(R.id.prograssBar);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    private void updateVideoSurfaces() {
//        int sw = getWindow().getDecorView().getWidth();
//        int sh = getWindow().getDecorView().getHeight();
        int sw = mSurfaceView.getWidth();
        int sh = mSurfaceView.getHeight();

        Log.d(TAG, "mVideoWidth: " + mVideoWidth + " , mVideoHeight: " + mVideoHeight);

        // sanity check
        if (sw * sh == 0) {
            Log.e(TAG, "Invalid surface size");
            return;
        }

        mMediaPlayer.getVLCVout().setWindowSize(sw, sh);

//        ViewGroup.LayoutParams lp = mSurfaceView.getLayoutParams();
        if (mVideoWidth * mVideoHeight == 0) {
            /* Case of OpenGL vouts: handles the placement of the video using MediaPlayer API */
//            lp.width  = ViewGroup.LayoutParams.MATCH_PARENT;
//            lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
//            mSurfaceView.setLayoutParams(lp);
//            lp = linearLayout.getLayoutParams();
//            lp.width  = ViewGroup.LayoutParams.MATCH_PARENT;
//            lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
//            linearLayout.setLayoutParams(lp);
//            changeMediaPlayerLayout(sw, sh);
            return;
        }

//        if (lp.width == lp.height && lp.width == ViewGroup.LayoutParams.MATCH_PARENT) {
//            /* We handle the placement of the video using Android View LayoutParams */
//            mMediaPlayer.setAspectRatio(null);
//            mMediaPlayer.setScale(0);
//        }

//        double dw = sw, dh = sh;
//        final boolean isPortrait = getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
//
//        if (sw > sh && isPortrait || sw < sh && !isPortrait) {
//            dw = sh;
//            dh = sw;
//        }
//
//        // compute the aspect ratio
//        double ar, vw;
//        if (mVideoSarDen == mVideoSarNum) {
//            /* No indication about the density, assuming 1:1 */
//            vw = mVideoVisibleWidth;
//            ar = (double)mVideoVisibleWidth / (double)mVideoVisibleHeight;
//        } else {
//            /* Use the specified aspect ratio */
//            vw = mVideoVisibleWidth * (double)mVideoSarNum / mVideoSarDen;
//            ar = vw / mVideoVisibleHeight;
//        }
//
//        // compute the display aspect ratio
//        double dar = dw / dh;
//
//        if (dar < ar)
//            dh = dw / ar;
//        else
//            dw = dh * ar;
//
//        // set display size
//        lp.width  = (int) Math.ceil(dw * mVideoWidth / mVideoVisibleWidth);
//        lp.height = (int) Math.ceil(dh * mVideoHeight / mVideoVisibleHeight);
//        mSurfaceView.setLayoutParams(lp);
//
//        // set frame size (crop if necessary)
//        lp = linearLayout.getLayoutParams();
//        lp.width = (int) Math.floor(dw);
//        lp.height = (int) Math.floor(dh);
//        linearLayout.setLayoutParams(lp);

        mSurfaceView.invalidate();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mMediaPlayer.release();
        mLibVLC.release();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMediaPlayer.release();
        mLibVLC.release();
    }

    public void sendStartStream() {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(getContext());
        String url ="http://blissbot:8888/start";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.d(TAG, "response = " + response);
                    if("start stream".equalsIgnoreCase(response.trim()) || "nothing".equalsIgnoreCase(response.trim())) {
                        Log.d(TAG, "start handler");
                        final Handler handler = new Handler(Looper.getMainLooper());
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 5s = 5000ms
                                Log.d(TAG, "start video");
                                startVideo();
                                prograssBar.setVisibility(View.GONE);
                            }
                        }, 5000);
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getContext(), "Error: Couldn't start video", Toast.LENGTH_LONG).show();
                }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);

        ObjectAnimator animation = ObjectAnimator.ofInt(prograssBar, "progress", 10);
        animation.setDuration(500); // 0.5 second
        animation.setInterpolator(new DecelerateInterpolator());
        animation.start();
    }

    private void startVideo() {
        vlcVout.setVideoView(mSurfaceView);
        vlcVout.attachViews();
        Media media = new Media(mLibVLC, Uri.parse(VIDEO_URL));
        mMediaPlayer.setMedia(media);
        media.release();
        mMediaPlayer.play();
        if (mOnLayoutChangeListener == null) {
            mOnLayoutChangeListener = new View.OnLayoutChangeListener() {
                private final Runnable mRunnable = new Runnable() {
                    @Override
                    public void run() {
                        updateVideoSurfaces();
                    }
                };
                @Override
                public void onLayoutChange(View v, int left, int top, int right,
                                           int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    if (left != oldLeft || top != oldTop || right != oldRight || bottom != oldBottom) {
                        mHandler.removeCallbacks(mRunnable);
                        mHandler.post(mRunnable);
                    }
                }
            };
        }
        linearLayout.addOnLayoutChangeListener(mOnLayoutChangeListener);
    }

    @Override
    public void onStart() {
        super.onStart();
        sendStartStream();
    }

    void sendStopStream() {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(getContext());
        String url ="http://blissbot:8888/stop";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Do nothing
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                sendStopStream();
            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    private void stopVideo() {
        if (mOnLayoutChangeListener != null) {
            linearLayout.removeOnLayoutChangeListener(mOnLayoutChangeListener);
            mOnLayoutChangeListener = null;
        }
        mMediaPlayer.stop();
        mMediaPlayer.getVLCVout().detachViews();
    }

    @Override
    public void onStop() {
        super.onStop();
        stopVideo();
        sendStopStream();
    }

    @Override
    public void onNewLayout(IVLCVout vlcVout, int width, int height, int visibleWidth, int visibleHeight, int sarNum, int sarDen) {
        mVideoWidth = width;
        mVideoHeight = height;
        mVideoVisibleWidth = visibleWidth;
        mVideoVisibleHeight = visibleHeight;
        mVideoSarNum = sarNum;
        mVideoSarDen = sarDen;
        updateVideoSurfaces();
    }

    @Override
    public void onSurfacesCreated(IVLCVout vlcVout) {

    }

    @Override
    public void onSurfacesDestroyed(IVLCVout vlcVout) {

    }

    @Override
    public void onHardwareAccelerationError(IVLCVout vlcVout) {

    }
}
