package com.sparta.group3.controller;

public class MenuResponse {
    public static enum ResponseCode{
        OK,
        NOT_FOUND,
        FALSE,
        BAD_REQUEST,
        ADDITIONAL_INFO_REQUIRED
    };
    public ResponseCode feedbackCode;
    public String responseMessage;
    public MenuResponse(ResponseCode feedbackCode, String responseMessage){
        this.feedbackCode = feedbackCode;
        this.responseMessage = responseMessage;
    }

    public MenuResponse(ResponseCode feedbackCode){
        this.feedbackCode = feedbackCode;
    }
}
