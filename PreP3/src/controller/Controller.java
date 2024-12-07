package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller
{
	public Controller()
	{
		super();
	}

	private boolean fileExist(String path, String nome) {
		File dir = new File(path);
		if (dir.exists() && dir.isDirectory())
		{
			File[] files = dir.listFiles();
			for (File f : files)
			{	
				String name = f.getName();
				if (name.contentEquals(nome))
				{
					return true;
				}
				return false;
			}
		}
		return false;
	}

	public void searchInFile(String path, String nome, String ano) throws IOException 
	{
		
		File arq = new File(path, nome);
		if (fileExist(path, nome))
		{
			
			FileInputStream fluxo = new FileInputStream(arq);
	        InputStreamReader leitor = new InputStreamReader(fluxo);
	        BufferedReader buffer = new BufferedReader(leitor);
			String texto = buffer.readLine();
			
			
            String[] partes = texto.split(",");
		       
			int tamPartes = partes.length;
			
			for (int i = 0; i < tamPartes; i++)
			{
				if (partes[i].contains("\"" + ano + "\""))
				{
					System.out.println(partes[i+1].substring(partes[i+1].indexOf(":") + 1));
				}
			}
			
			buffer.close();
		}
		else
		{
			throw new IOException("Arquivo não encontrado"); 
		}
		
	}

	
}
