package com.studentinfo.utils;

public class ResponsePayload {
    private String code;
    private String message;
    private Object object;

    public ResponsePayload() {
    }
    public ResponsePayload(String code, String message, Object object) {
        this.code = code;
        this.message = message;
        this.object = object;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public Object setObject(Object object) {
        this.object = object;
        return object;
    }
}
