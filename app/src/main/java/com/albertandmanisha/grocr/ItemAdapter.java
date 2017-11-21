package com.albertandmanisha.grocr;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.albertandmanisha.grocr.tools.ImageViewCircleTransform;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * @author albertyang
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private static ArrayList<ItemModel> dataList;
    private LayoutInflater mInflater;
    private Context context;
    private GalleryStyle9ClickListener clicklistener = null;

    public ItemAdapter(Context ctx, ArrayList<ItemModel> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView image;
        private TextView title;
        private TextView category;
        private TextView price;

        public ItemViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            image = itemView.findViewById(R.id.iimageMain);
            title = itemView.findViewById(R.id.ititle);
            category = itemView.findViewById(R.id.icategory);
            price = itemView.findViewById(R.id.iprice);
        }

        @Override
        public void onClick(View v) {

            if (clicklistener != null) {
                clicklistener.itemClicked(v, getAdapterPosition());
            }
        }
    }

    public void setClickListener(GalleryStyle9ClickListener listener) {
        this.clicklistener = listener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Glide.with(context)
                .load("https://s3.ca-central-1.amazonaws.com/grocr-albertyang/" + dataList.get(position).getImageUrl())
                .transform(new ImageViewCircleTransform(context))
                .thumbnail(0.01f)
                .centerCrop()
                .into(holder.image);
        holder.title.setText(dataList.get(position).getTitle());
        holder.category.setText(dataList.get(position).getCategory());
        holder.price.setText('$'+Double.toString(dataList.get(position).getPrice()));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
