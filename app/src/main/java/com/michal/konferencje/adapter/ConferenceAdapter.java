package com.michal.konferencje.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.michal.konferencje.R;
import com.michal.konferencje.object.Conference;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by michal on 15.08.17.
 */

public class ConferenceAdapter extends RecyclerView.Adapter<ConferenceAdapter.MyViewHolder> {
    private final View.OnClickListener onClickListener;
    private List<Conference> conferenceList = new ArrayList<>();

    public ConferenceAdapter(List<Conference> conferenceList, View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        this.conferenceList = conferenceList;
    }

    @Override
    public ConferenceAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.conference_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ConferenceAdapter.MyViewHolder holder, int position) {
        Conference conference = conferenceList.get(position);
        holder.conferenceName.setText(conference.getNameConference());
        Date date = conference.getDateConference();
        DateFormat df = new SimpleDateFormat("d MMM, yyyy");
        String now = df.format(date);
        holder.conferenceDate.setText(now);
       // Glide.with(holder.conferenceImage.getContext()).load(conference.getPhotoConference()).into(holder.conferenceImage);
        holder.itemView.setTag(conference);
    }

    @Override
    public int getItemCount() {
        return conferenceList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.conferenceDate)
        TextView conferenceDate;
        @BindView(R.id.conferenceName)
        TextView conferenceName;
        @BindView(R.id.conferenceImage)
        ImageView conferenceImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            itemView.setTag(this);
        }

        @Override
        public void onClick(View view) {
            onClickListener.onClick(view);
        }
    }
}
