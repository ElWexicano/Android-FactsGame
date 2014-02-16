package ie.iamshanedoyle.factsgame.models;

/**
 * Created by shane on 03/02/2014.
 */
public class Question {

    // Ireland is the capital of the World?
    private String mTitle;

    // False
    private boolean mIsTrue;

    // ireland
    private String mImageResId;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public boolean isTrue() {
        return mIsTrue;
    }

    public void setIsTrue(boolean mIsTrue) {
        this.mIsTrue = mIsTrue;
    }

    public String getImageResId() {
        return mImageResId;
    }

    public void setImageResId(String mImageResId) {
        this.mImageResId = mImageResId;
    }
}
