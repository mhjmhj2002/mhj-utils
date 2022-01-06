package com.mhj.utils.reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.springframework.stereotype.Component;

@Component
public class Reader {
	
	public InputStream readFile(String path) throws FileNotFoundException {
		FileInputStream fis = new FileInputStream(path);
		return fis;
	}

}
