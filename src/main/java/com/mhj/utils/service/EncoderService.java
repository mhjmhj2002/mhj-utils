package com.mhj.utils.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mhj.utils.reader.Reader;
import com.mhj.utils.writer.Writer;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Data
public class EncoderService {

	private String dirEncode;
	private String dirDecode;
	private String from;
	private String to;

	@Autowired
	private Reader reader;

	@Autowired
	private Writer writer;

	public EncoderService() {
		super();
	}

	public void encoder() {
		try {
			writeFile(encodeFile());
		} catch (IOException e) {
			log.error("Erro:", e);
		}
	}

	private String encodeFile() throws IOException {
		try {
			InputStream inputStream = reader.readFile(dirEncode + from);
			return Base64.getEncoder().encodeToString(inputStream.readAllBytes());
		} catch (IOException e) {
			log.error("Erro no encode", e);
			throw e;
		}
	}

	private void writeFile(String content) throws IOException {
		try {
			writer.writeFile(dirDecode + to, content);
		} catch (IOException e) {
			log.error("Erro no write", e);
			throw e;
		}
	}

}
