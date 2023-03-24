package com.zzwv.dto;

import lombok.Data;

public record R(int code, Object data, String message) {

    // 中肯、加练、未来可期、顶峰相见、感谢教练，哈哈哈
    public static R ok(Object data) {
        return new R(200, data, null);
    }

    public static R ok(String dataAndMessage) {
        return new R(200, dataAndMessage, dataAndMessage);
    }

    public static R error(int code, String message) {
        return new R(code, null, message);
    }
}
