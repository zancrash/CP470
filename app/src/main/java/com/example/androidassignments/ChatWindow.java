package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatWindow extends AppCompatActivity {

    private ListView chatView;
    private EditText chatInput;
    private Button sendButton;
    private ArrayList<String> chatArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);

        chatView = (ListView)findViewById(R.id.chatView);
        chatInput = (EditText)findViewById(R.id.chat_input);
        sendButton = (Button)findViewById(R.id.sendButton);
        chatArray = new ArrayList<>();

        //in this case, “this” is the ChatWindow, which is-A Context object
        ChatAdapter messageAdapter =new ChatAdapter( this );
        chatView.setAdapter (messageAdapter);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = chatInput.getText().toString();
                chatArray.add(msg);
                messageAdapter.notifyDataSetChanged();
                chatInput.setText("");
            }
        });


    }

    private class ChatAdapter extends ArrayAdapter<String> {
        public ChatAdapter(Context ctx) {
            super(ctx, 0);
        }

        public int getCount(){
            return chatArray.size();
        }

        public String getItem(int position){
            return chatArray.get(position);
        }

        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = ChatWindow.this.getLayoutInflater();
            View result = null ;
            if(position%2 == 0) {
                result = inflater.inflate(R.layout.chat_row_outgoing, null);
            }
            else {
                result = inflater.inflate(R.layout.chat_row_incoming, null);
            }

            TextView message = (TextView)result.findViewById(R.id.message_text);
            message.setText(getItem(position));
            return result;

        }
    }
}