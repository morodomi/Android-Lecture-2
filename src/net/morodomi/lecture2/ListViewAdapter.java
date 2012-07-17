package net.morodomi.lecture2;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * ArrayAdapter which controls view of each rows in the ListView
 * @author Masahiro Morodomi <morodomi at gmail.com>
 */
public class ListViewAdapter extends ArrayAdapter<String> {

	private LayoutInflater inflater;

	// Holder which holds row elements in the view.
	private class ListViewHolder {
		TextView number;
		TextView name;
	}

	/**
	 * Constructor for ListViewAdapter
	 * @param context
	 * @param textViewResourceId
	 * @param objects
	 */
	public ListViewAdapter(Context context, int textViewResourceId,
			String[] objects) {
		super(context, textViewResourceId, objects);
		// save LayoutInflator as private instance.
		this.inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	/** Called when the row will appear in the ListView */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ListViewHolder holder;
		// if view is null
		if (convertView == null) {
			Log.d("morodomi", "convertView == null");
			// inflate row from LayoutInflator
			convertView = this.inflater.inflate(R.layout.list_item, null);
			// create view holder
			holder = new ListViewHolder();
			// set TextView from row view
			holder.number = (TextView) convertView
					.findViewById(R.id.text_view1);
			holder.name = (TextView) convertView.findViewById(R.id.text_view2);
			// set holder to view as Tag
			convertView.setTag(holder);
		} else {
			Log.d("morodomi", "convertView != null");
			// get view holder from row
			holder = (ListViewHolder) convertView.getTag();
		}	
		// set text to the view
		holder.number.setText(" " + position + " : ");
		holder.name.setText((String) getItem(position));
		holder.number.setTextColor(Color.RED);
		holder.name.setTextColor(Color.RED);
		convertView.setBackgroundColor(Color.BLUE);
		// output log
		Log.d("morodomi", "country:" + getItem(position));
		// return view
		return convertView;
	}
}
