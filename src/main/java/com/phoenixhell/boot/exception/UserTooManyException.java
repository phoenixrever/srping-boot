package com.phoenixhell.boot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author phoenixhell
 * @create 2021/1/13 0013-下午 2:33
 */
//@ResponseStatus(value= HttpStatus.FORBIDDEN,reason = "user is too many")
public class UserTooManyException extends RuntimeException {
    public UserTooManyException() {
    }

    public UserTooManyException(String message) {
        super(message);
    }
}
