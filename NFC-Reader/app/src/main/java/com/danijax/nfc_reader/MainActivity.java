package com.danijax.nfc_reader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> messagesTosend;
    List<String> messagesToReceive;

    TextView sentmessage;
    TextView receivedMessage;
    EditText messageToSend;
    Button addMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    private void initComponents() {
        messagesTosend = new ArrayList<>();
        messagesToReceive = new ArrayList<>();
        sentmessage = (TextView) findViewById(R.id.message_sent);
        receivedMessage = (TextView) findViewById(R.id.message_received);
        messageToSend = (EditText) findViewById(R.id.textView);
        addMessage = (Button) findViewById(R.id.add_message_btn);
    }
    public void addMessage(View view) {
        String newMessage = messageToSend.getText().toString();
        messagesTosend.add(newMessage);

        messageToSend.setText("");
        updateTextViews();

        Toast.makeText(this, "Added Message", Toast.LENGTH_LONG).show();
    }

    private  void updateTextViews() {
        sentmessage.setText("Messages To Send:\n");
        //Populate Our list of messages we want to send
        if(messagesTosend.size() > 0) {
            for (int i = 0; i < messagesTosend.size(); i++) {
                sentmessage.append(messagesTosend.get(i));
                sentmessage.append("\n");
            }
        }

        receivedMessage.setText("Messages Received:\n");
        //Populate our list of messages we have received
        if (messagesToReceive.size() > 0) {
            for (int i = 0; i < messagesToReceive.size(); i++) {
                receivedMessage.append(messagesToReceive.get(i));
                receivedMessage.append("\n");
            }
        }
    }

}
