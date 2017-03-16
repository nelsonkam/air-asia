package io.airasia.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import io.airasia.R;
import io.airasia.utils.HighlightUtil;

/**
 * Created by nelson on 3/15/17.
 */

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.ViewHolder> {
    public final int LEFT = 0, RIGHT = 1;
    ArrayList<Boolean> colorStates;
    Activity context;

    public TripAdapter(ArrayList<Boolean> colorStates, Activity context) {
        this.colorStates = colorStates;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View tripView;
        if (viewType == LEFT) {
            tripView = inflater.inflate(R.layout.timeline_item_left, parent, false);
        } else /* RIGHT */ {
            tripView = inflater.inflate(R.layout.timeline_item_right, parent, false);
        }

        return new ViewHolder(tripView, this.context);
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return LEFT;
        } else {
            return RIGHT;
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        boolean state = colorStates.get(position);
        if (state) {
            holder.coloredCircle.setCardBackgroundColor(ContextCompat.getColor(context, R.color.topPink));
        } else {
            holder.coloredCircle.setCardBackgroundColor(ContextCompat.getColor(context, R.color.timelineGreen));
        }
        if (position == getItemCount() - 1) {
            holder.secondConnector.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return colorStates.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView coloredCircle;
        CardView tripView;
        View secondConnector;
        Activity ctx;

        public ViewHolder(View itemView, Activity ctx) {
            super(itemView);
            coloredCircle = (CardView) itemView.findViewById(R.id.colored_circle);
            secondConnector = itemView.findViewById(R.id.second_item_connector);
            tripView = (CardView) itemView.findViewById(R.id.trip_view);
            itemView.setOnClickListener(this);
            this.ctx = ctx;
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            // Check if an item was deleted, but the user clicked it before the UI removed it
            if (position != RecyclerView.NO_POSITION) {
                boolean state = colorStates.get(position);
                HighlightUtil.highlight(ctx, tripView);
            }
        }
    }
}
