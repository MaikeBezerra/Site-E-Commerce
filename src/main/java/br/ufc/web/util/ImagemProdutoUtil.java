package br.ufc.web.util;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class ImagemProdutoUtil {
	
	public static void salvarImagemProduto(String nomeDoProduto, MultipartFile imagem) {
		if (imagemIsValid(imagem)) {
			String caminho = "src/main/resources/static/img/produtos/" + nomeDoProduto + ".jpg";
			salvarImagem(caminho, imagem);
		}
	}
	
	public static Boolean imagemIsValid(MultipartFile imagem) {
		return Objects.nonNull(imagem) && !imagem.isEmpty();
	}
	
	public static void salvarImagem(String caminho, MultipartFile imagem) {
		File file = new File(caminho);
		
		try {
			FileUtils.writeByteArrayToFile(file, imagem.getBytes());
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
