package vip.wicp.ruhome.system.model;

/**
 * @program: ruhome
 * @description: 统一返回结果
 * @author: Mr.PY
 * @create: 2019-08-06 15:56
 **/
public class ResultBean<T> {
    private Integer status;
    private String message;
    private T data;

    public static final Integer STATUS_NORMAL = 1; // 正常
    public static final Integer STATUS_EXCEPTION = -1; //异常



    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getdata() {
        return data;
    }

    public void setdata(T data) {
        this.data = data;
    }

    public ResultBean() {
    }

    public ResultBean(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
