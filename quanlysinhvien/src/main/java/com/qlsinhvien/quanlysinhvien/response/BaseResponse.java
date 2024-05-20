package com.qlsinhvien.quanlysinhvien.response;

import com.qlsinhvien.quanlysinhvien.dto.StudentDTO;

import java.util.List;
import java.util.Objects;

public class BaseResponse<T> {
    private int statusCode;
    private String message;
    private T data;

    public BaseResponse(int statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
}
