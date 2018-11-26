package com.fr.test.annotation;

import java.lang.annotation.*;

/**
 * @author jzj
 * @date 2018年11月26日 下午2:37:53
 * @desc 自定义枚举类
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface SupplierServiceKind {

    String[] supportSupplier();
    
}
