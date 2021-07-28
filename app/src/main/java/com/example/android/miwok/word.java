package com.example.android.miwok;

public class word {
    private String mDefaultTrnslation;

    private String mMiwokTranslation;

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private int mAudioResourceId;

    private static final int NO_IMAGE_PROVIDED = -1;

    public word(String defaultTrnslation, String miwokTranslation, int audioResourceId){
        mDefaultTrnslation = defaultTrnslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;
    }

    public word(String defaultTrnslation, String miwokTranslation, int imageResourceId, int audioResourceId){
        mDefaultTrnslation = defaultTrnslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    public String getDefaultTrnslation(){
        return mDefaultTrnslation;
    }
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    public int getmImageResourceId()
    {
        return mImageResourceId;
    }

    // whether or not have image
    public boolean hasImage()
    {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getAudioResourceId(){
        return mAudioResourceId;
    }
}
