package course.examples.UI.GridLayout;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class GridLayoutActivity extends Activity {

    public static final String PREFS_NAME = "DATA";

	protected static final String EXTRA_RES_ID = "POS";

    private ArrayList<Integer> mThumbIdsFlags = new ArrayList<Integer>(
            Arrays.asList(R.drawable.argentina, R.drawable.australia,
                    R.drawable.bolivia, R.drawable.brazil, R.drawable.canada,
                    R.drawable.china, R.drawable.colombia, R.drawable.cuba,
                    R.drawable.ecuador, R.drawable.france, R.drawable.macedonia,
                    R.drawable.mexico));

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		GridView gridview = (GridView) findViewById(R.id.gridview);

		gridview.setAdapter(new GalleryAdapter(this, mThumbIdsFlags));

        // Capture GridView item click
        gridview.setOnItemClickListener(new OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                // Launch ViewImage.java using intent
                Intent intent = new Intent(GridLayoutActivity.this, SummaryActivity.class);

                // Send captured position to ViewImage.java
                intent.putExtra("id", position);

                // Start ViewImage.java
                startActivity(intent);
            }
        });

		// open new activity

		final Button statisticButton = (Button) findViewById(R.id.btnStatitic);

		statisticButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent helloAndroidIntent = new Intent(GridLayoutActivity.this,
						StatisticActivity.class);
				startActivity(helloAndroidIntent);
			}
		});

	}
}