package ie.iamshanedoyle.factsgame.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import ie.iamshanedoyle.factsgame.R;
import ie.iamshanedoyle.factsgame.models.Score;

/**
 * Created by shane on 06/01/2014.
 */
public class ScoresAdapter extends ArrayAdapter<Score> {

    static class ViewHolder {
        public TextView textViewUser;
        public TextView textViewScore;
        public TextView textViewPosition;
    }

    private List<Score> mScores;
    private final String[] mPositions;

    public ScoresAdapter(Context context, List<Score> scores) {
        super(context, R.layout.list_item_scores);
        mScores = scores;
        mPositions = getContext().getResources().getStringArray(R.array.positions);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Score getItem(int position) {
        return mScores.get(position);
    }

    @Override
    public int getCount() {
        return mScores.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Score score = getItem(position);

        if (score == null) {
            return null;
        }

        View view = convertView;

        ViewHolder viewHolder;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater.from(getContext()));
            view = inflater.inflate(R.layout.list_item_scores, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.textViewUser = (TextView) view.findViewById(R.id.textViewUser);
            viewHolder.textViewPosition = (TextView) view.findViewById(R.id.textViewPosition);
            viewHolder.textViewScore = (TextView) view.findViewById(R.id.textViewScore);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.textViewUser.setText(score.getUser());
        viewHolder.textViewScore.setText(Integer.toString(score.getValue()));
        viewHolder.textViewPosition.setText(mPositions[position]);

        return view;
    }
}
