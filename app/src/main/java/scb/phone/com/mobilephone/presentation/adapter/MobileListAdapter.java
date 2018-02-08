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

import butterknife.BindView;
import butterknife.ButterKnife;
import scb.phone.com.mobilephone.R;
import scb.phone.com.mobilephone.presentation.entity.PhoneListDisplayEntity;
import scb.phone.com.mobilephone.presentation.mobilelist.MobileListView;

public class MobileListAdapter extends RecyclerView.Adapter<MobileListAdapter.ViewHolder> {

    private Context context;
    private List<PhoneListDisplayEntity> list;
    private List<PhoneListDisplayEntity> favoriteIds;
    private MobileListView mobileListView;

    public MobileListAdapter(List<PhoneListDisplayEntity> list, MobileListView view, List<PhoneListDisplayEntity> favoriteIds) {
        this.list = list;
        this.mobileListView = view;
        this.favoriteIds = favoriteIds;
    }

    @Override
    public MobileListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mobile, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MobileListAdapter.ViewHolder holder, int position) {
        PhoneListDisplayEntity entity = list.get(position);
        holder.favoriteImage.setOnClickListener(view -> {
            mobileListView.onFavoriteClick(entity, position);
        });
        holder.mobileCard.setOnClickListener(view -> {
            mobileListView.onCardClick(entity);
        });
        holder.titleText.setText(entity.getName());
        holder.descriptionTextView.setText(entity.getDescription());
        holder.priceTextView.setText("Price: $" + entity.getPrice());
        holder.ratingTextView.setText("Rating: " + entity.getRating());
        holder.favoriteImage.setEnabled(!favoriteIds.contains(entity));
        Picasso.with(context)
                .load(favoriteIds.contains(entity) ? R.drawable.ic_favorite : R.drawable.ic_favorite_border)
                .fit()
                .into(holder.favoriteImage);

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
        TextView descriptionTextView;

        @BindView(R.id.price_text_view)
        TextView priceTextView;

        @BindView(R.id.favorite_image)
        ImageView favoriteImage;

        @BindView(R.id.mobile_card)
        CardView mobileCard;

        @BindView(R.id.rating_text_view)
        TextView ratingTextView;

        @BindView(R.id.thumb_image)
        ImageView thumbImage;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            container = itemView;
        }
    }

}
