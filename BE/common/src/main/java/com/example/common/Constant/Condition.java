package com.example.common.Constant;

public class Condition {
    //------------------------------------------------------------------------------------------------------------------
    //----------------------------------------COMMON-SERVICE------------------------------------------------------------
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";
    public static final String REGEX_PHONE = "^0\\d{8,9}$";
    public static final String REGEX_USERNAME = "^[a-zA-Z][a-zA-Z0-9]{5,}$";
    public static final String REGEX_NAME = "^[A-Za-zÀ-ÿ]+(?: [A-Za-zÀ-ÿ]+)*$";
    public static final String REGEX_PASSWORD="^[a-zA-Z0-9]{7,}$";

    public static final int MAX_LENGTH_FIRST_NAME = 100;
    public static final int MAX_LENGTH_LAST_NAME = 100;
    public static final int MAX_LENGTH_USERNAME = 500;
    public static final int MAX_LENGTH_PHONE_NUMBER = 50;
    public static final int MAX_LENGTH_EMAIL = 500;
    public static final int MAX_LENGTH_DEPARTMENT_CODE = 100;
    public static final int MAX_LENGTH_DEPARTMENT_NAME = 500;

    public static final int MAX_LENGTH_CATEGORY_CODE = 100;
    public static final int MAX_LENGTH_CATEGORY_NAME = 500;

    public static final int MAX_LENGTH_ITEM_NAME = 500;
    public static final int MAX_LENGTH_ITEM_CODE = 100;
    public static final int MAX_LENGTH_ITEM_VALUE = 500;
    //------------------------------------------------------------------------------------------------------------------

    //------------------------------------------------------------------------------------------------------------------
    //-------------------------------------------WFM-SERVICE------------------------------------------------------------
    public static final String REGEX_PROCESS_TIME="^\\d{1,10}(\\.\\d{1,2})?$";

    public static final int MAX_LENGTH_WO_TYPE_CODE = 100;
    public static final int MAX_LENGTH_WO_TYPE_NAME = 500;



    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
}
