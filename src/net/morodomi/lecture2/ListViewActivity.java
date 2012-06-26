package net.morodomi.lecture2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

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
		ListViewAdapter adapter 
				= new ListViewAdapter(this, R.id.text_view2, countries);
		// Set the Adapter to the ListView
		listView.setAdapter(adapter);
	}
}