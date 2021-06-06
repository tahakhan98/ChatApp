package com.example.chatapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MsgAdapter extends RecyclerView.Adapter<MsgViewHolder> {
    private List<MsgDTO> msgDtoList = null;

    public MsgAdapter(List<MsgDTO> msgDtoList) {
        this.msgDtoList = msgDtoList;
    }

    @Override
    public void onBindViewHolder(MsgViewHolder holder, int position) {

        DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
        String dateString = dateFormat.format(new Date()).toString();
        System.out.println("Current time in AM/PM: "+dateString);
        MsgDTO msgDto = this.msgDtoList.get(position);
        // If the message is a received message.
        if(msgDto.MSG_TYPE_RECEIVED.equals(msgDto.getMsgType()))
        {
            // Show received message in left linearlayout.
            holder.leftMsgLayout.setVisibility(LinearLayout.VISIBLE);
            holder.leftMsgTextView.setText(msgDto.getMsgContent());

            holder.leftMsgTextViewdate.setText(dateString.toString());
            holder.rightMsgTextView.setText(msgDto.getMsgContent());

            holder.rightMsgLayout.setVisibility(LinearLayout.GONE);
        }
        // If the message is a sent message.
        else if(msgDto.MSG_TYPE_SENT.equals(msgDto.getMsgType()))
        {
            holder.rightMsgLayout.setVisibility(LinearLayout.VISIBLE);
            holder.rightMsgTextView.setText(msgDto.getMsgContent());

            holder.rightMsgTextViewdate.setText(dateString.toString());
            holder.leftMsgTextView.setText(msgDto.getMsgContent());
            holder.leftMsgLayout.setVisibility(LinearLayout.GONE);

        }
    }

    @Override
    public MsgViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_chat_app_item_view, parent, false);
        return new MsgViewHolder(view);
    }

    @Override
    public int getItemCount() {
        if(msgDtoList==null)
        {
            msgDtoList = new ArrayList<MsgDTO>();
        }
        return msgDtoList.size();
    }
}
