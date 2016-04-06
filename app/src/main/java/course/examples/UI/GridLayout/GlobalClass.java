package course.examples.UI.GridLayout;

import android.app.Application;

/**
 * Created by macesarr on 06/04/16.
 */
public class GlobalClass extends Application {

    private float likes[] = {0,0,0,0,0,0,0,0,0,0,0,0};
    private float visits[] = {0,0,0,0,0,0,0,0,0,0,0,0};

    public void updateLikes(Integer pos, Integer value){ likes[pos] = (likes[pos]+value)/3; }
    public float getLikes(Integer pos){ return likes[pos]; }

    public void updateVisits(Integer pos, Integer value){ visits[pos] = (visits[pos]+value)/3; }
    public float getVisits(Integer pos){ return visits[pos]; }

    public float getGeneralLikes(){
        float totalLikes = 0;
        for(int i=0; i<likes.length; i++) totalLikes+=likes[0];
        return totalLikes;
    }

    public float getGeneralVisits(){
        float totalVisits = 0;
        for(int i=0; i<visits.length; i++) totalVisits+=visits[0];
        return totalVisits;
    }

}
