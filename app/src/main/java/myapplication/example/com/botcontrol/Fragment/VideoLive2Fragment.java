package myapplication.example.com.botcontrol.Fragment;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.LinearLayoutCompat;

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

//    private void changeMediaPlayerLayout(int displayW, int displayH) {
//        /* Change the video placement using the MediaPlayer API */
//        switch (CURRENT_SIZE) {
//            case SURFACE_BEST_FIT:
//                mMediaPlayer.setAspectRatio(null);
//                mMediaPlayer.setScale(0);
//                break;
//            case SURFACE_FIT_SCREEN:
//            case SURFACE_FILL: {
//                Media.VideoTrack vtrack = mMediaPlayer.getCurrentVideoTrack();
//                if (vtrack == null)
//                    return;
//                final boolean videoSwapped = vtrack.orientation == Media.VideoTrack.Orientation.LeftBottom
//                        || vtrack.orientation == Media.VideoTrack.Orientation.RightTop;
//                if (CURRENT_SIZE == SURFACE_FIT_SCREEN) {
//                    int videoW = vtrack.width;
//                    int videoH = vtrack.height;
//
//                    if (videoSwapped) {
//                        int swap = videoW;
//                        videoW = videoH;
//                        videoH = swap;
//                    }
//                    if (vtrack.sarNum != vtrack.sarDen)
//                        videoW = videoW * vtrack.sarNum / vtrack.sarDen;
//
//                    float ar = videoW / (float) videoH;
//                    float dar = displayW / (float) displayH;
//
//                    float scale;
//                    if (dar >= ar)
//                        scale = displayW / (float) videoW; /* horizontal */
//                    else
//                        scale = displayH / (float) videoH; /* vertical */
//                    mMediaPlayer.setScale(scale);
//                    mMediaPlayer.setAspectRatio(null);
//                } else {
//                    mMediaPlayer.setScale(0);
//                    mMediaPlayer.setAspectRatio(!videoSwapped ? ""+displayW+":"+displayH
//                            : ""+displayH+":"+displayW);
//                }
//                break;
//            }
//            case SURFACE_16_9:
//                mMediaPlayer.setAspectRatio("16:9");
//                mMediaPlayer.setScale(0);
//                break;
//            case SURFACE_4_3:
//                mMediaPlayer.setAspectRatio("4:3");
//                mMediaPlayer.setScale(0);
//                break;
//            case SURFACE_ORIGINAL:
//                mMediaPlayer.setAspectRatio(null);
//                mMediaPlayer.setScale(1);
//                break;
//        }
//    }


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

    @Override
    public void onStart() {
        super.onStart();
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
    public void onStop() {
        super.onStop();
        if (mOnLayoutChangeListener != null) {
            linearLayout.removeOnLayoutChangeListener(mOnLayoutChangeListener);
            mOnLayoutChangeListener = null;
        }
        mMediaPlayer.stop();
        mMediaPlayer.getVLCVout().detachViews();
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
