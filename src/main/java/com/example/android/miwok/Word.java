package com.example.android.miwok;

/**
 * class to get the words of the Luo and the default translation
 */
public class Word
{

    /**
     * getting reference to the immage as private
     */
    private int mImageResourceId = NO_IMAGE_PROVODED;
    /**
     * get luo translation
     */
    private String mluoTranslation;
    /**
     * string to get the english translation.
     */
    private String mEnglishTranslation;
    /**
     *CHECK IF IMAGE HAS BEEN PROVIDED;
     */
    private static final int NO_IMAGE_PROVODED = -1;

    /**
     * create a constructor that will take in two string for the translation
     */
    public Word(String luoTranslation, String englishTranslation)
    {
        mluoTranslation = luoTranslation;
        mEnglishTranslation = englishTranslation;

    }
    /**
     * create a constructor that will take in two string for the translation
     */
    public Word(String luoTranslation, String englishTranslation,int imageResourceId)
    {
        mluoTranslation = luoTranslation;
        mEnglishTranslation = englishTranslation;
        mImageResourceId = imageResourceId;

    }

    /**
     * create methods to get the luo translation;
     */
    public String getLuoTranslation()
    {
        return mluoTranslation;
    }
    /**
     * method to get the english translation
     */
    public String getEnglishTranslation()
    {
        return mEnglishTranslation;
    }
    /**
     * get the image using the getter resource id
     */
   public int getImageResourceId()
   {
       return mImageResourceId;
   }
    /**
     * Check if the resource has the image;
     */
    public boolean hasImage()
    {
        return mImageResourceId != NO_IMAGE_PROVODED;
    }

}
