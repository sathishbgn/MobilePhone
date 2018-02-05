package scb.phone.com.mobilephone.presentation.adapter;


import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.zhanghai.android.materialratingbar.MaterialRatingBar;
import scb.phone.com.mobilephone.R;
import scb.phone.com.mobilephone.presentation.entity.PhoneListDisplayEntity;

public class FavoriteListAdapter extends RecyclerView.Adapter<FavoriteListAdapter.ViewHolder> {

    private Context context;
    private List<PhoneListDisplayEntity> list;

    public FavoriteListAdapter(List<PhoneListDisplayEntity> list) {
        this.list = list;
    }

    @Override
    public FavoriteListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mobile, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FavoriteListAdapter.ViewHolder holder, int position) {
        PhoneListDisplayEntity entity = list.get(position);
        holder.titleText.setText(entity.getName());
        holder.descriptionText.setText(String.format(Locale.getDefault(), "%.2f", entity.getPrice()));
        holder.ratingBar.setRating((float) entity.getRating());
        holder.favoriteImage.setVisibility(View.INVISIBLE);

        Picasso.with(context)
                .load(entity.getThumbImageURL())
                .placeholder(R.drawable.bankicon_scb)
                .error(R.mipmap.ic_launcher_round)
                .fit()
                .into(holder.thumbImage);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        View container;

        @BindView(R.id.title_text_view)
        TextView titleText;

        @BindView(R.id.description_text_view)
        TextView descriptionText;

        @BindView(R.id.favorite_image)
        ImageView favoriteImage;

        @BindView(R.id.mobile_card)
        CardView mobileCard;

        @BindView(R.id.rating_bar)
        MaterialRatingBar ratingBar;

        @BindView(R.id.thumb_image)
        ImageView thumbImage;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            container = itemView;
        }
    }

}
