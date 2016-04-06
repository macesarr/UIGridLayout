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
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

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

        // Calling Application class (see application tag in AndroidManifest.xml)
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();

		final GridView gridview = (GridView) findViewById(R.id.gridview);
        final TextView textView = (TextView) findViewById(R.id.tvGeneralStatistics);

		gridview.setAdapter(new GalleryAdapter(this, mThumbIdsFlags));

        textView.setText("TOTAL LIKES: " + globalVariable.getGeneralLikes() + " TOTAL VISITS: " + globalVariable.getGeneralVisits());

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

	}
}