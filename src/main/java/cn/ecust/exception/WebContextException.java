package cn.ecust.exception;

/**
 * @Description
 * @Author chris
 * @Date 2022/5/11, 20:09
 */
public class WebContextException extends RuntimeException {

    WebContextException() {
    }

    WebContextException(String message) {
        super(message);
    }

    WebContextException(Throwable cause) {
        super(cause);
    }

    WebContextException(String message, Throwable cause) {
        super(message, cause);
    }
}
