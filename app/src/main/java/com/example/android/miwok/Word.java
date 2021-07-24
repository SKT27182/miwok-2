package com.example.android.miwok;

public class Word {

    //Default Translator for the word
    private String mDefaultTranslation;

    //Miwok Translation for the word
    private String mMiwokTranslation;


    //Constructor
    public Word(String defaultTranslation, String miwokTranslation){
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
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



}
