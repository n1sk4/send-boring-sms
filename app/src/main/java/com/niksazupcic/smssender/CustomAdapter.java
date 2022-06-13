package com.niksazupcic.smssender;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private final Context context;
    private final ArrayList<SMSItems> smsItems;


    CustomAdapter(Context context,
                  ArrayList<SMSItems> smsItems){

        this.context = context;
        this.smsItems = smsItems;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_sms_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        if(holder.title.getEditText().getText() != null && holder.title != null && holder.title.getEditText() != null){
            holder.title.getEditText().setText(String.valueOf(smsItems.get(position).getTitle()));
        }
        if(holder.phone.getEditText().getText() != null){
            holder.phone.getEditText().setText(String.valueOf(smsItems.get(position).getPhone()));
        }
        if(holder.message.getEditText().getText() != null){
            holder.message.getEditText().setText(String.valueOf(smsItems.get(position).getMessage()));
        }
        holder.notification.setText(String.valueOf(smsItems.get(position).getNotification()));
        if(holder.notification.getText() == null){
            holder.notification.setVisibility(View.GONE);
        }

        holder.expand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(smsItems.get(position).isExpanded()){
                    smsItems.get(position).setExpanded(false);
                    holder.phone.setVisibility(View.GONE);
                    holder.message.setVisibility(View.GONE);
                    holder.notification.setVisibility(View.GONE);
                    holder.expand.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
                }else {
                    smsItems.get(position).setExpanded(true);
                    holder.phone.setVisibility(View.VISIBLE);
                    holder.message.setVisibility(View.VISIBLE);
                    holder.notification.setVisibility(View.VISIBLE);
                    holder.expand.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
                }
                if(holder.notification.getText() == null || smsItems.get(position).getNotification() == null){
                    holder.notification.setText("Set notifications");
                }
            }
        });

        holder.notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startNewActivity(position);
            }
        });

        holder.send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                smsItems.get(position).setTitle(String.valueOf(holder.title.getEditText().getText()));
                smsItems.get(position).setPhone(String.valueOf(holder.phone.getEditText().getText()));
                smsItems.get(position).setMessage(String.valueOf(holder.message.getEditText().getText()));
                if(holder.message != null && holder.message.getEditText().getText().length() > 0){
                    sendSMS(smsItems.get(position).getPhone(), smsItems.get(position).getMessage());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return smsItems.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextInputLayout title;
        TextInputLayout phone;
        TextInputLayout message;
        ImageButton send;
        ImageButton expand;
        TextView notification;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_inputText);
            phone = itemView.findViewById(R.id.phone_inputText);
            message = itemView.findViewById(R.id.message_textView);
            send = itemView.findViewById(R.id.send_button);
            expand = itemView.findViewById(R.id.expand_imageButton);
            notification = itemView.findViewById(R.id.notificationTime_textView);
        }
    }

    private void startNewActivity(int position){
        Intent intent = new Intent(context, SetupActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    private void sendSMS(String phone, String message){
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phone, null, message, null, null);
        Toast.makeText(context, "SMS sent.",
                Toast.LENGTH_LONG).show();
    }
}
