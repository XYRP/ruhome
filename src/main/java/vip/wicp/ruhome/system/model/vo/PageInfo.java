package vip.wicp.ruhome.system.model.vo;

import java.util.List;

/**
 * @program: ruhome
 * @description: 用于分页数据的封装
 * @author: Mr.PY
 * @create: 2019-08-08 14:45
 **/
public class PageInfo {
    private Integer code = 0;

    private String msg;

    private List data;

    private long count;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
