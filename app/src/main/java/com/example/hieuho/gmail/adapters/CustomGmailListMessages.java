package com.example.hieuho.gmail.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hieuho.gmail.R;
import com.example.hieuho.gmail.models.Inbox;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by HieuHo on 12/03/2017.
 */

public class CustomGmailListMessages extends RecyclerView.Adapter<CustomGmailListMessages.Holder> {
    private Context mContext;
    private List<Inbox> messages;
    private SparseBooleanArray selectedItems;


    public CustomGmailListMessages(Context mContext, List<Inbox> messages){
        this.mContext = mContext;
        this.messages = messages;
        selectedItems = new SparseBooleanArray();

    }


    @Override
    public CustomGmailListMessages.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);

        return new Holder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomGmailListMessages.Holder holder, int position) {
        Inbox inbox = messages.get(position);
        holder.from.setText(inbox.getFrom());
        holder.subject.setText(inbox.getSubject());
        holder.message.setText(inbox.getMessage());
        holder.timestamp.setText(FomatDate(inbox.getTimestamp()));
        holder.iconText.setText(inbox.getFrom().substring(0, 1));
        holder.itemView.setActivated(selectedItems.get(position, false));

        if(inbox.getType() == 0){
            holder.txtType.setText("Inbox");
        }else if(inbox.getType() == 1){
            holder.txtType.setText("");
        }else {
            holder.txtType.setText("Drafts");
        }

        Glide.with(mContext).load(inbox.getPicture()).into(holder.imgProfile);
          }

    public class Holder extends RecyclerView.ViewHolder {
        public TextView from, subject, message, iconText, timestamp,txtType;
        public ImageView iconImp;
        public CircleImageView imgProfile;
        public LinearLayout messageContainer;
        public RelativeLayout iconContainer, iconBack, iconFront;
        public Holder(View itemView) {
            super(itemView);
            from = (TextView) itemView.findViewById(R.id.from);
            subject = (TextView) itemView.findViewById(R.id.txt_primary);
            message = (TextView) itemView.findViewById(R.id.txt_secondary);
            iconText = (TextView) itemView.findViewById(R.id.icon_text);
            timestamp = (TextView) itemView.findViewById(R.id.timestamp);
            iconBack = (RelativeLayout) itemView.findViewById(R.id.icon_back);
            iconFront = (RelativeLayout) itemView.findViewById(R.id.icon_front);
            iconImp = (ImageView) itemView.findViewById(R.id.icon_star);
            imgProfile = (CircleImageView) itemView.findViewById(R.id.icon_profile);
            messageContainer = (LinearLayout) itemView.findViewById(R.id.message_container);
            iconContainer = (RelativeLayout) itemView.findViewById(R.id.icon_container);
            txtType = (TextView) itemView.findViewById(R.id.txt_type);
        }


    }


    @Override
    public long getItemId(int position) {
        return messages.get(position).getId();
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }


    private String FomatDate(String Dates){
        SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd");
        Date date = null;
        try {
            date = dt.parse(Dates);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM");
        return dt1.format(date);
    }
}
