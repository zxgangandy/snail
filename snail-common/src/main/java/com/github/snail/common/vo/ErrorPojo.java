

package com.github.snail.common.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

@Data
public class ErrorPojo implements Serializable {

    @JSONField(name = "timestamp")
    private long timestamp;
    @JSONField(name = "status")
    private int status;
    @JSONField(name = "error")
    private String error;
    @JSONField(name = "exception")
    private String exception;
    @JSONField(name = "message")
    private String message;
    @JSONField(name = "path")
    private String path;
}
