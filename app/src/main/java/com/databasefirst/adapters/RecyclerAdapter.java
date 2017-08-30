package com.databasefirst.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.databasefirst.R;
import com.databasefirst.beans.ContactBean;
import com.databasefirst.database.DBHolder;

import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CustomViewHolder> {

    DBHolder dbHolder;
    Context context;
    List<ContactBean> list;
    public RecyclerAdapter(Context context,List<ContactBean> contactsList)
    {
        this.context  = context;
        dbHolder = new DBHolder(context);
        list = contactsList;
    }
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_view,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        ContactBean contact = list.get(position);
        holder.contactName.setText(contact.getContactName());
        holder.contactNumber.setText(contact.getContactNumber());
    }

    @Override
    public int getItemCount() {
        return list.size();
        //return 0;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView contactName,contactNumber;
        public CustomViewHolder(View itemView) {
            super(itemView);
            contactName = (TextView) itemView.findViewById(R.id.tv_rv_contactName);
            contactNumber = (TextView) itemView.findViewById(R.id.tv_rv_contactNumber);
        }
    }
}
