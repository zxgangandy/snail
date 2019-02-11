

package com.github.snail.gateway.util;

import com.alibaba.ttl.TransmittableThreadLocal;


public class RibbonVersionHolder {
    private static final ThreadLocal<String> context = new TransmittableThreadLocal<>();


    public static String getContext() {
        return context.get();
    }

    public static void setContext(String value) {
        context.set(value);
    }

    public static void clearContext() {
        context.remove();
    }
}
