package net.morodomi.lecture2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Activity for Android Lecture 2
 * This class controls whole view of this app.
 * @author Masahiro Morodomi <morodomi at gmail.com>
 *
 */
public class ListViewActivity extends Activity {
	// countries list
	private static final String[] countries = { "Japan", "United States",
			"United Kingdom", "Australia", "Canada", "France", "Italy",
			"Spain", "Netherland", "Mexico", "Korea", "China", "New Zealand",
			"India", "Germany", "Ireland", "Brazil", "Denmark", "Russia",
			"Saudi Arabia", "Singapore", "Thailand", "Indonasia" };

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// Get the ListView instance
		ListView listView = (ListView) findViewById(R.id.list_view);
		// Create an Adapter for the ListView
		final ListViewAdapter adapter 
				= new ListViewAdapter(this, R.id.text_view2, countries);
		// Set the Adapter to the ListView
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				new AlertDialog.Builder(ListViewActivity.this)
						.setMessage(adapter.getItem(position))
						.setPositiveButton("OK", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								dialog.dismiss();
							}
						}).show();
				Toast.makeText(ListViewActivity.this, adapter.getItem(position), Toast.LENGTH_SHORT).show();
			}
		});
	}
}