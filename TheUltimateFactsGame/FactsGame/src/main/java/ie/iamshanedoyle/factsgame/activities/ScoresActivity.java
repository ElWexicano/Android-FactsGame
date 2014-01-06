package ie.iamshanedoyle.factsgame.activities;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ie.iamshanedoyle.factsgame.R;
import ie.iamshanedoyle.factsgame.adapters.ScoresAdapter;
import ie.iamshanedoyle.factsgame.models.Score;

public class ScoresActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        private List<Score> mScores;
        private ScoresAdapter mScoresAdapter;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_scores, container, false);
            return rootView;
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            mScores = new ArrayList<Score>();

            for (int i = 0; i < 30; i++) {
                Score score = new Score("User "+i, 2*200-i);
                mScores.add(score);
            }

            mScoresAdapter = new ScoresAdapter(getActivity(), mScores);

            ListView scoresList = (ListView) getView().findViewById(R.id.listViewScores);

            scoresList.setAdapter(mScoresAdapter);
        }
    }

}
