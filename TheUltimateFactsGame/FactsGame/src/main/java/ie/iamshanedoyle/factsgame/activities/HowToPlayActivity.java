package ie.iamshanedoyle.factsgame.activities;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ie.iamshanedoyle.factsgame.R;

/**
 * This activity represents that How To Play screen.
 */
public class HowToPlayActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_play);

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

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_how_to_play, container, false);
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            if (getView() == null) {
                return;
            }

            TextView textViewSubTitle = (TextView) getView().findViewById(R.id.textViewSubTitle);

            String lineBreak = "\n";

            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(textViewSubTitle.getText());

            spannableStringBuilder.append(lineBreak);
            spannableStringBuilder.append(lineBreak);


            String scorePoints = getString(R.string.score_points);
            spannableStringBuilder.append(scorePoints + lineBreak);

            int startPos = spannableStringBuilder.length() - scorePoints.length();
            int endPos = spannableStringBuilder.length();

            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getResources().getColor(R.color.game_info_value_font));

            spannableStringBuilder.setSpan(foregroundColorSpan, startPos-1, endPos, SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);

            spannableStringBuilder.append(getString(R.string.score_points_desc)).append(lineBreak).append(lineBreak);
            spannableStringBuilder.append(getString(R.string.build_up_streaks)).append(lineBreak);
            spannableStringBuilder.append(getString(R.string.build_up_streaks_desc_one)).append(lineBreak).append(lineBreak);
            spannableStringBuilder.append(getString(R.string.build_up_streaks_desc_two)).append(lineBreak).append(lineBreak);
            spannableStringBuilder.append(getString(R.string.build_up_streaks_desc_three));

            textViewSubTitle.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);

        }

    }

}
