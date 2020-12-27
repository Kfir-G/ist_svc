package com.ist.svc.config.annotation;

import com.ist.svc.common.Module;

import java.lang.annotation.*;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME) 
@Inherited 
public @interface Logging {
	public Module modType();
	public int opeType();
    public String desc() default ""; 
}
