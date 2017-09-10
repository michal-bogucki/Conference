package com.michal.konferencje.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.michal.konferencje.R;
import com.michal.konferencje.object.Category;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by michal on 16.08.17.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {
    private final View.OnClickListener onClickListener;
    private List<Category> categoryList = new ArrayList<>();


    public CategoryAdapter(List<Category> categoryList, View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        this.categoryList = categoryList;

    }

    @Override
    public CategoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryAdapter.MyViewHolder holder, int position) {
        Category category = categoryList.get(position);
        String name = category.getName();
        (holder).categoryName.setText(name);
        ColorGenerator generator = ColorGenerator.MATERIAL;
        int color = generator.getColor(category.getName());
        TextDrawable drawable = TextDrawable.builder()
                .buildRound(String.valueOf(name.charAt(0)), color);
        holder.imageView.setImageDrawable(drawable);
        holder.itemView.setTag(category);

    }


    @Override
    public int getItemCount() {
        return categoryList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.iconCategory)
        ImageView imageView;
        @BindView(R.id.categoryName)
        TextView categoryName;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            itemView.setTag(this);

        }

        @Override
        public void onClick(View v) {
            onClickListener.onClick(v);
        }
    }
}
