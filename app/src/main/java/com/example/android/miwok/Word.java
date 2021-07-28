package com.example.android.miwok;

public class Word {

    //Default Translator for the word
    private String mDefaultTranslation;

    //Miwok Translation for the word
    private String mMiwokTranslation;

    //Variable to store the image id & setting it to NO_IMAGE_PROVIDED
    private Integer mImageResourceId;

    {
        mImageResourceId = NO_IMAGE_PROVIDED;
    }

    //Variable to store the position of the audio file
    private Integer mAudioResourceId;


    //making a constant variable with initializing it to -1 which checks whether image is provided or not
    public static final int NO_IMAGE_PROVIDED = -1;


    //Constructor
    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId){
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
        mAudioResourceId = audioResourceId;
    }

    // New Constructor with Image Resourcce ID
    public Word(String defaultTranslation, String miwokTranslation,int imageResourceId , int audioResourceId){
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;

    }




    /**
     * get the default translation of the word Method
     */
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    /**
     * get the Miwok translation of the word Method
     */
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    /**
     * get the Resource Id of the Image
     */
    public Integer getImageResourceId(){return  mImageResourceId;}


    /**
     * returns whether word_ Array List has image or not
     */
    public boolean HasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }



    //Returns the audioResourceID
    public int getAudioResourceId(){return mAudioResourceId;}



}
