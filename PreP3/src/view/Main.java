package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.Controller;

public class Main {

	public static void main(String[] args) 
	{
		
		Controller c = new Controller();
		
		String path = "C:\\TEMP";
		String nome = "pop.json";
		int ano = 0;
		boolean valida = true;
		
		while (valida)
		{
			ano = Integer.parseInt(JOptionPane.showInputDialog("digite o ano (entre 1960 e 2023) que deseja saber o tamanho da população chinesa"));
			if(ano >= 1960 && ano <= 2023)
			{
				valida = !valida;
			}
		}
		
		String sAno = Integer.toString(ano);
		
		try {
			c.searchInFile(path, nome, sAno);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
	}

}
