package com.mhj.utils.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
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
public class DecoderService {

//	private String dirEncode;
	private String dirDecode;
	private String from;
	private String to;

	@Autowired
	private Reader reader;

	@Autowired
	private Writer writer;

	public DecoderService() {
		super();
	}

	public void decoder() {
		try {
			writeFile(decodeFile());
		} catch (IOException e) {
			log.error("Erro:", e);
		}
	}

	private byte[] decodeFile() throws IOException {
		try {
			InputStream inputStream = reader.readFile(dirDecode + from);
			return Base64.getDecoder().decode(inputStream.readAllBytes());
		} catch (IOException e) {
			log.error("Erro no encode", e);
			throw e;
		}
	}

	private void writeFile(byte[] content) throws IOException {
		try {
			writer.writeFile(Paths.get(dirDecode + to), content);
		} catch (IOException e) {
			log.error("Erro no write", e);
			throw e;
		}
	}



}
