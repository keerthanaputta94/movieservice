package com.brainfirst.cinema.db;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class InMemoryJavaDatabase {
	
	public static final Map<Object, Object> DB = new HashMap<Object, Object>();

}
