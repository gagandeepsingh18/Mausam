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
     List<String> tempValue;
     List<Integer> mirage;
    Context context;

    public MyItemRecyclerViewAdapter(Context context,List<String> items,List<Integer> mimage,List<String> tempValue)
    {
      mValues = items;
      this.context=context;
      this.mirage =mimage;
      this.tempValue=tempValue;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_city_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.imageView2.setImageResource(mirage.get(position));
        holder.textView.setText(mValues.get(position));
        holder.textView2.setText((tempValue.get(position)));

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView2;
        TextView textView;
        TextView textView2;

        public ViewHolder(View view) {
            super(view);
            imageView2=view.findViewById(R.id.imageView2);
            textView=view.findViewById(R.id.textView);
            textView2=view.findViewById(R.id.textViewcitylist);

        }


    }
}