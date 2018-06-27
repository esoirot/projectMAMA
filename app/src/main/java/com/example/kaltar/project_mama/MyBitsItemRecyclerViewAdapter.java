package com.example.kaltar.project_mama;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kaltar.project_mama.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link BitsList_tab_bits_list_item} and makes a call to the
 * TODO: Replace the implementation with code for your data type.
 */
public class MyBitsItemRecyclerViewAdapter extends RecyclerView.Adapter<MyBitsItemRecyclerViewAdapter.ViewHolder> {

    //private String[] mDataSet;
    protected List<BitsList_tab_bits_list_item> user_bits_list_items;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView bit_item_name;
        private final TextView bit_item_quantity;
        //private final TextView bit_item_logo_faction;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
                }
            });
            bit_item_name = (TextView) v.findViewById(R.id.bit_name);
            bit_item_quantity = (TextView) v.findViewById(R.id.bit_quantity);
        }

        public TextView getBit_item_name() {
            return bit_item_name;
        }
        public TextView getBit_item_quantity() {
            return bit_item_quantity;
        }
    }

    public MyBitsItemRecyclerViewAdapter(List<BitsList_tab_bits_list_item> list) {
        user_bits_list_items = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_bitsitem, parent, false);

        return new ViewHolder(v);
        //return viewHolder.getTextView().setText(mDataSet[position]);

    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        //Log.d(TAG, "Element " + position + " set.");

        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        viewHolder.getBit_item_name().setText(user_bits_list_items.get(position).get_name());
        viewHolder.getBit_item_quantity().setText(""+user_bits_list_items.get(position).get_quantity());
    }

   /* @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).content);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }*/

    @Override
    public int getItemCount() {
        return user_bits_list_items.size();
    }

    /*public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.item_number);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }*/
}
