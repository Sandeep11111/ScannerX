package com.example.sandeepkumarsingh.myapplication;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by sandeepkumarsingh on 1/15/18.
 */

    public class CountryViewHolder extends RecyclerView.ViewHolder {
        private ItemRecyclerViewBinding binding;

        public CountryViewHolder(View view) {
            super(view);
            binding = DataBindingUtil.bind(view);
        }

        public void bind(Country country) {
            binding.setCountry(country);
        }
}
