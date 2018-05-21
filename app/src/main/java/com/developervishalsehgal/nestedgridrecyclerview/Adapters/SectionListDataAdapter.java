package com.developervishalsehgal.nestedgridrecyclerview.Adapters;

/**
 * Created by Vishal Sehgal 10-21-2017.
 */

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.developervishalsehgal.nestedgridrecyclerview.R;
import com.developervishalsehgal.nestedgridrecyclerview.models.SingleItemModel;

import java.util.ArrayList;


public class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.SingleItemRowHolder> {

    private ArrayList<SingleItemModel> itemsList;
    private Context mContext;

    public SectionListDataAdapter(Context context, ArrayList<SingleItemModel> itemsList) {
        this.itemsList = itemsList;
        this.mContext = context;
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_single_card, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(final SingleItemRowHolder holder, int i) {

        SingleItemModel singleItem = itemsList.get(i);

        holder.tvTitle.setText(singleItem.getName());

    }

    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);
    }


    public class SingleItemRowHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        protected TextView tvTitle;
        protected CardView cardView;
        protected LinearLayout linearLayout;

        public SingleItemRowHolder(View view) {
            super(view);
            this.tvTitle = view.findViewById(R.id.tvTitle);
            this.cardView = view.findViewById(R.id.card_item);
            this.linearLayout = view.findViewById(R.id.card_item_box);
            cardView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Toast.makeText(mContext,tvTitle.getText().toString(),Toast.LENGTH_SHORT).show();
        }
    }
}