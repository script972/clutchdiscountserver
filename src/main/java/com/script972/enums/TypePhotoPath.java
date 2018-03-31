package com.script972.enums;

public enum TypePhotoPath{
    COMPANY_LOGO, USER_PHOTO, CARDGROUP_LOGO, CARD_PHOTO_FRONT, CARD_PHOTO_BACK;

    public static String dir(TypePhotoPath type){
        String PATHROOT = "/src/main/resources/photos/";
        switch (type){
            case COMPANY_LOGO: return PATHROOT+"company logo";
            case USER_PHOTO: return PATHROOT+"user photo";
        }
        return "";
    }
}