package br.com.develcode.teste.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {
	
	public static Date converteDataParaOBanco(String data) {
		SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return formatador.parse(data);
		} catch (ParseException e) {
			//optei por usar um runtime ao invés de um exception, para não gerar outros try catchs no código, 
			//deixando o try catch do controller lidar com as exceptions.
			throw new RuntimeException("Formato de data não aceito. Formato de data aceitos: 'yyyy-MM-dd'");
		}
	}
}
