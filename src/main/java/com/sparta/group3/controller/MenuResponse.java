package com.sparta.group3.controller;

public class MenuResponse {
    public static enum ResponseCode{
        OK,
        NOT_FOUND,
        FALSE,
        BAD_REQUEST,
        ADDITIONAL_INFO_REQUIRED
    };
    final public ResponseCode feedbackCode;
    final public String responseMessage;
    public MenuResponse(ResponseCode feedbackCode, String responseMessage){
        this.feedbackCode = feedbackCode;
        this.responseMessage = responseMessage;
    }

    public MenuResponse(ResponseCode feedbackCode){
        this.feedbackCode = feedbackCode;
        this.responseMessage = "";
    }
}
