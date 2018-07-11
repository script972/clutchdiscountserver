package com.script972.enums;

public enum TypePhotoPath{
    COMPANY_LOGO, USER_PHOTO, CARDGROUP_LOGO, CARD_PHOTO_FRONT, CARD_PHOTO_BACK;

    public static String dir(TypePhotoPath type){
        switch (type){
            case COMPANY_LOGO: return "companylogo";
            case USER_PHOTO: return "userphoto";
            case CARD_PHOTO_FRONT: return "cardphoto/front";
            case CARD_PHOTO_BACK: return "cardphoto/back";
        }
        return "";
    }
}