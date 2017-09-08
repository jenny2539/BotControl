package myapplication.example.com.botcontrol.Fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.BundleCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import myapplication.example.com.botcontrol.MainActivity;
import myapplication.example.com.botcontrol.R;

/**
 * Created by Admin on 1/13/17 AD.
 */
    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    MainActivity _activity;
    Fragment FourthFragment;
    FourthFragment fourthfragment = new FourthFragment();

    private OnImageClickListener mOnImageClickListener;
    public void setOnImageClickListener(OnImageClickListener l){
        mOnImageClickListener = l;
    }

    private ArrayList<CreateList> galleryList;
        private Context context;



    public MyAdapter(Context context, ArrayList<CreateList> galleryList) {
            this.galleryList = galleryList;
            this.context = context;

        }

        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_layout, viewGroup, false);
            return new ViewHolder(view);
        }


    public interface OnImageClickListener
    {
        void onImageClick(int i);
    }


    @Override
        public void onBindViewHolder(MyAdapter.ViewHolder viewHolder, final int i) {
            viewHolder.title.setText(galleryList.get(i).getImage_title());
            viewHolder.img.setScaleType(ImageView.ScaleType.CENTER_CROP);
            viewHolder.img.setImageResource((galleryList.get(i).getImage_ID()));

        viewHolder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
                    builder1.setMessage("Are you sure you want to send this "+ galleryList.get(i).getImage_title());
                    builder1.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(context,"Yes",Toast.LENGTH_SHORT).show();

                            if(mOnImageClickListener != null)
                            {
                                mOnImageClickListener.onImageClick(i);
                            }
                        }
                    });
                    builder1.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(context,"No",Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder1.show();
                    Toast.makeText(context,"Image", Toast.LENGTH_SHORT).show();
                }
            });
        }






    @Override
        public int getItemCount() {
            return galleryList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            private TextView title;
            private ImageView img;
            public ViewHolder(View view) {
                super(view);

                title = (TextView)view.findViewById(R.id.title);
                img = (ImageView) view.findViewById(R.id.img);
            }
        }
    }

