package com.mhj.utils.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.stereotype.Component;

@Component
public class Writer {
	
	public void writeFile(String path, String content) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(path));
	    writer.write(content);	    
	    writer.close();
	}
	
	public void writeFile(Path path, byte[] content) throws IOException {
		Files.write(path, content);
	}

}
