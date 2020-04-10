package com.strong.qlu_studenthelper.attractions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ms.square.android.expandabletextview.ExpandableTextView;
import com.strong.qlu_studenthelper.R;

import java.util.List;

public class ScenicAdapter extends RecyclerView.Adapter<ScenicAdapter.ViewHolder> {

    private Context mContext ;

    private List<Scenic> mScenicList ;

    static class ViewHolder extends RecyclerView.ViewHolder{

        CardView cardView ;
        ImageView scenicImage ;
        TextView scenicName ;
        ExpandableTextView scenicIfo ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            scenicImage = (ImageView) itemView.findViewById(R.id.scenic_photo);
            scenicName = (TextView) itemView.findViewById(R.id.scenic_name);
            scenicIfo = (ExpandableTextView) itemView.findViewById(R.id.expand_text_view);
        }
    }

    public ScenicAdapter(List<Scenic> mScenicList) {
        this.mScenicList = mScenicList;
    }

    @NonNull
    @Override
    public ScenicAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (mContext == null){
            mContext = viewGroup.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.scenic_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScenicAdapter.ViewHolder viewHolder, int i) {
        Scenic scenic = mScenicList.get(i);
        viewHolder.scenicName.setText(scenic.getName());
        viewHolder.scenicIfo.setText(scenic.getIntroduce());
        Glide.with(mContext).load(scenic.getImageId()).into(viewHolder.scenicImage);
    }

    @Override
    public int getItemCount() {
        return mScenicList.size();
    }


}
