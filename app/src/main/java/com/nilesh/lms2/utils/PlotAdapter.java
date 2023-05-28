package com.nilesh.lms2.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.nilesh.lms2.R;
import com.nilesh.lms2.models.PlotModel;

public class PlotAdapter extends FirebaseRecyclerAdapter<PlotModel,PlotAdapter.ViewHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public PlotAdapter(@NonNull FirebaseRecyclerOptions<PlotModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull PlotAdapter.ViewHolder holder, int position, @NonNull PlotModel model) {

//  TODO:      Glide.with().load(uploadCurrent.getmImageUrl()).into(holder.postImageView);
        holder.title_txt.setText(model.getTitle());
//        holder.locate_txt.setText(model.getAd3());
        String url = model.getImg1_url();

        Glide.with(holder.itemView.getContext())
                .load(url)
                .into(holder.plot_images);

    }

    @NonNull
    @Override
    public PlotAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view

                = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyler_plot, parent, false);

        return new PlotAdapter.ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        Context context;
        ImageView plot_images;
        TextView title_txt,locate_txt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);



            plot_images = itemView.findViewById(R.id.plot_image);

            title_txt = itemView.findViewById(R.id.title_txt_plot);
            locate_txt =itemView.findViewById(R.id.location_txt_plot);




        }
    }
}
