package com.example.chatapp;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MsgViewHolder extends RecyclerView.ViewHolder {

    LinearLayout leftMsgLayout;

    LinearLayout rightMsgLayout;

    TextView leftMsgTextView;

    TextView rightMsgTextView;
    TextView rightMsgTextViewdate;
    TextView leftMsgTextViewdate;

    public MsgViewHolder(View itemView) {
        super(itemView);

        if (itemView != null)
        {
            leftMsgLayout = (LinearLayout) itemView.findViewById(R.id.chat_left_msg_layout);
            rightMsgLayout = (LinearLayout) itemView.findViewById(R.id.chat_right_msg_layout);
            leftMsgTextView = (TextView) itemView.findViewById(R.id.chat_left_msg_text_view);
            rightMsgTextView = (TextView) itemView.findViewById(R.id.chat_right_msg_text_view);
            rightMsgTextViewdate = (TextView) itemView.findViewById(R.id.show_date);
            leftMsgTextViewdate = (TextView) itemView.findViewById(R.id.show_recevied_date);
        }
    }
}
