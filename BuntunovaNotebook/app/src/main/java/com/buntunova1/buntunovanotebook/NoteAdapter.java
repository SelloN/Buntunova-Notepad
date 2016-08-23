package com.buntunova1.buntunovanotebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sello on 2016/08/21.
 */
public class NoteAdapter extends ArrayAdapter<Note>{

    public static class ViewHolder{
        TextView title;
        TextView noteText;
        ImageView imageIcon;
    }

    //constructor
    public NoteAdapter(Context context, ArrayList<Note> notes){
        super(context, 0, notes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //This basically gets the position of the view of type Note
        Note note = getItem(position);

        ViewHolder viewHolder;

        //This line checks if the custom view has been saved or otherwise inflates it
        if(convertView == null){
            //If we don't have a view then create one and a view holder to save our view references to

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_row, parent, false);

            viewHolder = new ViewHolder();

            //Set our variables to the view group so that we dont have to always fetch the findByValueId

            viewHolder.title = (TextView) convertView.findViewById(R.id.ListItemNoteTitle);
            viewHolder.noteText = (TextView) convertView.findViewById(R.id.ListItemBody);
            viewHolder.imageIcon = (ImageView) convertView.findViewById(R.id.ListItemNoteImg);
            convertView.setTag(viewHolder);
        }else{

            viewHolder = (ViewHolder) convertView.getTag();
        }

        //Populate the data using the object
        viewHolder.title.setText(note.getTitle());
        viewHolder.noteText.setText(note.getMessage());
        viewHolder.imageIcon.setImageResource(note.getAssociatedDrawable());

        //Now that we've modified the view to return appropriate data, return it
        return convertView;

    }

}
