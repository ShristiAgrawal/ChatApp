package com.shristi.myapplication.todo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.shristi.myapplication.R;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class TodoAdapter extends BaseAdapter {

    private Activity mActivity;
    private DatabaseReference mDatabaseReference;
    private String creater,deadline,task;
    private ArrayList<DataSnapshot> mSnapshotList;

    private ChildEventListener mListener=new ChildEventListener() {
        @Override
        public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            mSnapshotList.add(dataSnapshot);
            notifyDataSetChanged();

        }

        @Override
        public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

        }

        @Override
        public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

        }

        @Override
        public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };

    public TodoAdapter(Activity activity,DatabaseReference ref,String c,String t,String d,String familycode){

        mActivity = activity;
        mDatabaseReference = ref.child(familycode).child("todo");
        mDatabaseReference.addChildEventListener(mListener);

        creater = c;
        task=t;
        deadline=d;
        mSnapshotList = new ArrayList<>();

    }

    static class ViewHolder{
        TextView creator;
        TextView task;
        LinearLayout.LayoutParams params;

    }


    @Override
    public int getCount() {

        return mSnapshotList.size();
    }

    @Override
    public todomodel getItem(int position) {

        DataSnapshot snapshot=mSnapshotList.get(position);
        return snapshot.getValue(todomodel.class);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){

            LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.todo_row, parent, false);

            final TodoAdapter.ViewHolder holder = new TodoAdapter.ViewHolder();
            holder.creator =(TextView) convertView.findViewById(R.id.creator);
            holder.task = (TextView) convertView.findViewById(R.id.task);
            holder.params =(LinearLayout.LayoutParams) holder.creator.getLayoutParams();
            convertView.setTag(holder);
        }

        final todomodel todo = getItem(position);
        final TodoAdapter.ViewHolder holder =(TodoAdapter.ViewHolder) convertView.getTag();



        String creator =todo.getCreator() ;
        holder.creator.setText(creator);

        String task = todo.getTask();
        holder.task.setText(task);

        return convertView;
    }


}
