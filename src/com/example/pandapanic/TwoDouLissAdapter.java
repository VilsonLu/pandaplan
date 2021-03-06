package com.example.pandapanic;

import model.ChecklistItem;
import model.ToDoListItem;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class TwoDouLissAdapter extends ArrayAdapter<ToDoListItem>{
	/**
	 * Adapter context
	 */
	Context mContext;

	/**
	 * Adapter View layout
	 */
	int mLayoutResourceId;
	
	public TwoDouLissAdapter(Context context, int layoutResourceId){
		
		super(context, layoutResourceId);

		mContext = context;
		mLayoutResourceId = layoutResourceId;
	}
	
	/**
	 * Returns the view for a specific item on the list
	 */
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;

		final ToDoListItem currentItem = getItem(position);

		if (row == null) {
			LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
			row = inflater.inflate(mLayoutResourceId, parent, false);
		}

		row.setTag(currentItem);
		final CheckBox checkBox = (CheckBox) row.findViewById(R.id.checkToDoComplete);
		final TextView  textDescription = (TextView) row.findViewById(R.id.textDescription);
		checkBox.setChecked(false);
		checkBox.setEnabled(true);
		textDescription.setText(currentItem.getItemName());
		

		return row;
	}
}
