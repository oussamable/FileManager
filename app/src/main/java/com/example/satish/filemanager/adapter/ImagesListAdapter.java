package com.example.satish.filemanager.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.satish.filemanager.R;
import com.example.satish.filemanager.activity.ImagesListActivity;
import com.example.satish.filemanager.model.MediaFileListModel;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Satish on 30-12-2015.
 */
public class ImagesListAdapter extends BaseAdapter {
    private ArrayList<MediaFileListModel> mediaFileListModelsArray;
    private Activity activity;
    private LayoutInflater layoutInflater;

    public ImagesListAdapter(ImagesListActivity audiosListActivity, ArrayList<MediaFileListModel> mediaFileListModelsArray) {
        this.activity = audiosListActivity;
        this.mediaFileListModelsArray = mediaFileListModelsArray;
    }

    @Override
    public int getCount() {
        return mediaFileListModelsArray.size();
    }

    @Override
    public Object getItem(int position) {
        return mediaFileListModelsArray.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null)
            layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            view = layoutInflater.inflate(R.layout.media_list_item_view, null);
        TextView lblFileName = (TextView) view.findViewById(R.id.file_name);
        ImageView imgItemIcon = (ImageView) view.findViewById(R.id.icon);
        MediaFileListModel mediaFileListModel = mediaFileListModelsArray.get(position);
        lblFileName.setText(mediaFileListModel.getFileName());
        File imgFile = new File(mediaFileListModel.getFilePath());
        if (imgFile.exists()) {
            Log.d("action", mediaFileListModel.getFilePath());
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            imgItemIcon.setImageBitmap(myBitmap);
        }
        return view;
    }
}
