package com.example.mausam;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mausam.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

     List<String> mValues;
     List<Integer> mimage;
    Context context;

    public MyItemRecyclerViewAdapter(Context context,List<String> items,List<Integer> mimage)
    {
      mValues = items;
      this.context=context;
      this.mimage=mimage;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_city_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.imageView2.setImageResource(mimage.get(position));
        holder.textView.setText(mValues.get(position));


    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView2;
        TextView textView;

        public ViewHolder(View view) {
            super(view);
            imageView2=view.findViewById(R.id.imageView2);
            textView=view.findViewById(R.id.textView);

        }


    }
}