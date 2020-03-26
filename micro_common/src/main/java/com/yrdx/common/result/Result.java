
package com.yrdx.common.result;

import lombok.Data;

/**
 * 封装接口返回结果实体类
 * @author zhuls
 * @version V1.0
 * @since 2020-03-26 10:59
 */
@Data
public class Result {

    private boolean flag;
    private Integer code;
    private String message;
    private Object data;

    public Result() {}

    public Result(boolean flag, Integer code, String message, Object data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;

        this.message = message;
    }
}
