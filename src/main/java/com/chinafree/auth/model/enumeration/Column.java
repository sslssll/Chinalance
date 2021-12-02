package com.chinafree.auth.model.enumeration;


public enum Column {


    LOGIN_MAIL("login_mail"),
    LOGIN_MOBILE("login_mobile"),
    LOGIN_ID("login_id");

    private String column;


    private Column(final String column){
        this.column=column;
    }


    public String getColumn() {
        return column;
    }

}
