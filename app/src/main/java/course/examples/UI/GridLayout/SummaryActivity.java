package course.examples.UI.GridLayout;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by macesarr on 05/04/16.
 */
public class SummaryActivity extends Activity {

    public static final String PREFS_NAME = "DATASET";

    private ArrayList<Integer> mThumbIdsFlags = new ArrayList<Integer>(
            Arrays.asList(R.drawable.argentina, R.drawable.australia,
                    R.drawable.bolivia, R.drawable.brazil, R.drawable.canada,
                    R.drawable.china, R.drawable.colombia, R.drawable.cuba,
                    R.drawable.ecuador, R.drawable.france, R.drawable.macedonia,
                    R.drawable.mexico));

    private ArrayList<Integer> mIdsSummaies = new ArrayList<Integer>(
            Arrays.asList(R.string.summ_argentina, R.string.summ_australia));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summary);

        Intent intent = getIntent();
        int position = intent.getExtras().getInt("id");

        // Open the Image adapter
        GalleryAdapter imageAdapter = new GalleryAdapter(this, mThumbIdsFlags);

        // Locate the ImageView and Summary
        final ImageView imageView = (ImageView) findViewById(R.id.ivSummary);
        final TextView textView = (TextView) findViewById(R.id.tvSummary);
        final Spinner spinnerVisits = (Spinner) findViewById(R.id.spVisits);
        final Spinner spinnerLikes = (Spinner) findViewById(R.id.spLikes);
        final Button sendButton = (Button) findViewById(R.id.btnSend);

        // Get image and position from ImageAdapter.java and set into ImageView
        imageView.setImageResource(imageAdapter.getmThumbIds().get(position));
        textView.setText(mIdsSummaies.get(position));

        // Load Spinner Visits
        ArrayAdapter<CharSequence> adapterV = ArrayAdapter.createFromResource(this,
                R.array.visits_array, android.R.layout.simple_spinner_item);
        adapterV.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerVisits.setAdapter(adapterV);

        // Load Spinner Likes
        ArrayAdapter<CharSequence> adapterL = ArrayAdapter.createFromResource(this,
                R.array.likes_array, android.R.layout.simple_spinner_item);
        adapterL.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLikes.setAdapter(adapterL);

        sendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                Intent intent = new Intent(SummaryActivity.this, GridLayoutActivity.class);
                startActivity(intent);

            }
        });
    }
}
