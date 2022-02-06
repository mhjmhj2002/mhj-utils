package com.mhj.utils.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.mhj.utils.service.DecoderService;
import com.mhj.utils.service.EncoderService;

@Component
public class ServerInitializer implements ApplicationRunner {

	private String dirEncode = "/home/mhj/Documentos/dev/encoder-arquivos/";
	private String dirDecode = "/home/mhj/Documentos/dev/decoder-arquivos/";
	private String nomeArquivo = "teste";
	private String extensaoEntrada = ".zip";
	private String extensaoSaida = ".txt";	
	private String from = nomeArquivo + extensaoEntrada;
	private String to = nomeArquivo + extensaoSaida;
	
	@Autowired
	private EncoderService encoderService;
	
	@Autowired
	private DecoderService decoderService;

	    @Override
	    public void run(ApplicationArguments applicationArguments) throws Exception {

	    	encoderService.setDirEncode(dirEncode);
	    	encoderService.setDirDecode(dirDecode);
	    	encoderService.setFrom(from);
	    	encoderService.setTo(to);
	    	encoderService.encoder();
	    	
	    	decoderService.setDirDecode(dirDecode);
	    	decoderService.setFrom(to);
	    	decoderService.setTo(from);
	    	decoderService.decoder();

	    }
}