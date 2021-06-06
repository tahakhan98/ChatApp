package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView msgRecyclerView = (RecyclerView)findViewById(R.id.chat_recycler_view);

        setTitle("Taha's Chat Application ");
        // Set RecyclerView layout manager.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(linearLayoutManager);

        // Create the initial data list.
        final List<MsgDTO> msgDtoList = new ArrayList<MsgDTO>();

        //Dummy Message
        MsgDTO msgDto = new MsgDTO(MsgDTO.MSG_TYPE_RECEIVED, "Hey Dude what's up!!");

        MsgDTO msgDto1 = new MsgDTO(MsgDTO.MSG_TYPE_RECEIVED, "I am fine how are you??");
        msgDtoList.add(msgDto);
        msgDtoList.add(msgDto1);
        // Create the data adapter with above data list.
        final MsgAdapter chatAppMsgAdapter = new MsgAdapter(msgDtoList);

        // Set data adapter to RecyclerView.
        msgRecyclerView.setAdapter(chatAppMsgAdapter);

        final EditText msgInputText = (EditText)findViewById(R.id.chat_input_msg);

        Button msgSendButton = (Button)findViewById(R.id.chat_send_msg);

        msgSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msgContent = msgInputText.getText().toString();
                if(!TextUtils.isEmpty(msgContent))
                {
                    MsgDTO msgDto = new MsgDTO(MsgDTO.MSG_TYPE_SENT, msgContent);
                    msgDtoList.add(msgDto);

                    int newMsgPosition = msgDtoList.size() - 1;

                    chatAppMsgAdapter.notifyItemInserted(newMsgPosition);

                    msgRecyclerView.scrollToPosition(newMsgPosition);

                    msgInputText.setText("");
                }
            }
        });
    }
}