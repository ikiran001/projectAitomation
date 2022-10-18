package com.INB.Annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import enums.CategoryType;

@Retention(RUNTIME)
@Target(METHOD)
public @interface FrameworkAnnotation {

	
	public String [] author();
	public CategoryType [] category();
}
