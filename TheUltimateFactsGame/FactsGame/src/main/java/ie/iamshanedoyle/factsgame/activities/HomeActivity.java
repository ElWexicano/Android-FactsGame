package ie.iamshanedoyle.factsgame.activities;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.Toast;

import ie.iamshanedoyle.factsgame.R;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements View.OnClickListener {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_home, container, false);
            return rootView;
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            Button buttonPlayNow = (Button) getView().findViewById(R.id.buttonPlayNow);
            Button buttonHowToPlay = (Button) getView().findViewById(R.id.buttonHowToPlay);
            Button buttonScores = (Button) getView().findViewById(R.id.buttonScores);
            Button buttonSettings = (Button) getView().findViewById(R.id.buttonSettings);

            buttonPlayNow.setOnClickListener(this);
            buttonHowToPlay.setOnClickListener(this);
            buttonScores.setOnClickListener(this);
            buttonSettings.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonPlayNow:
                    startActivity(new Intent(getActivity(), GameActivity.class));
                    break;
                case R.id.buttonHowToPlay:
                    startActivity(new Intent(getActivity(), HowToPlayActivity.class));
                    break;
                case R.id.buttonScores:
                    startActivity(new Intent(getActivity(), ScoresActivity.class));
                    break;
                case R.id.buttonSettings:
                    Toast.makeText(getActivity(), "Soon to be added", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
