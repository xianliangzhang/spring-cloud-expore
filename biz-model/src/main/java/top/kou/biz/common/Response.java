package top.kou.biz.common;

public class Response<T> {
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_FAILURE = 1;
    public static final String MESSAGE_SUCCESS = "Success";
    public static final String MESSAGE_FAILURE = "Failure";

    private int code;
    private String message;

    private T data;

    public Response() {

    }

    public Response(T t) {
        this.data = t;
        this.code = CODE_SUCCESS;
        this.message = MESSAGE_SUCCESS;
    }

    public Response(T t, int code, String message) {
        this.data = t;
        this.code = code;
        this.message = message;
    }

    public void setStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    @Override
    public String toString() {
        return String.format("User[code=%d, message=%s, data=%s]", code, message, data.toString());
    }
}
