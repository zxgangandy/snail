

package com.github.snail.common.util.exception;


public class SnailDeniedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public SnailDeniedException() {
    }

    public SnailDeniedException(String message) {
        super(message);
    }

    public SnailDeniedException(Throwable cause) {
        super(cause);
    }

    public SnailDeniedException(String message, Throwable cause) {
        super(message, cause);
    }

    public SnailDeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
