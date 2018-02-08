package scb.phone.com.mobilephone.presentation.adapter;


import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import scb.phone.com.mobilephone.R;
import scb.phone.com.mobilephone.presentation.entity.PhoneDetailDisplayEntity;

public class ImageSlideAdapter extends PagerAdapter {

    private PhoneDetailDisplayEntity entity;

    public ImageSlideAdapter(PhoneDetailDisplayEntity entity) {
        this.entity = entity;
    }

    @Override
    public int getCount() {
        return this.entity.getImageURL().size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_image, container, false);
        ViewHolder viewHolder = new ViewHolder(view);
        Picasso.with(container.getContext())
                .load(entity.getImageURL().get(position))
                .error(R.color.scb_purble)
                .into(viewHolder.imgDetail);
        viewHolder.priceText.setText("Price: $" + entity.getDetail().getPrice());
        viewHolder.ratingBar.setText("Rating: " + entity.getDetail().getRating());
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    static class ViewHolder {

        @BindView(R.id.rating_text)
        TextView ratingBar;
        @BindView(R.id.price_text)
        TextView priceText;
        @BindView(R.id.img_detail)
        ImageView imgDetail;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
