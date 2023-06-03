/*
RESUMO      : Classe de leitura e análise do arquivo solicitado e criação de um novo
PROGRAMADORA: Luiza Felix
DATA        : 15/05/2023
 */

package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Controller {
	public static void busca(int ano, String mes, double avg) throws IOException {

		File arquivo = new File("C:\\sistemas operacionais i\\steam_charts.csv");
		
		FileInputStream fluxo = new FileInputStream(arquivo);
		InputStreamReader leitor = new InputStreamReader(fluxo);
		BufferedReader buffer = new BufferedReader(leitor);
		String linha = buffer.readLine();
		linha = buffer.readLine();
		
		while(linha!=null) {
			String[] game = linha.split(",");
			if (Integer.parseInt(game[1])== ano && game[2].equalsIgnoreCase(mes)) {
				if(avg >=Double.parseDouble(game[3]) ) {
					System.out.println(game[0]+ " \t | \t " + game[3]);
				}
				
			}
			linha = buffer.readLine();
		}
		buffer.close();
		leitor.close();
		fluxo.close();
			
	}
	
	public static void registro(int ano, String mes, String nome) throws IOException {
		JOptionPane.showMessageDialog(null, "O diretório será sempre o 'C:/sistemas operacionais i/<arquivo>.csv'!");
			
		File arq = new File("C:\\sistemas operacionais i\\ASOI_20230504_Steam\\", nome + ".csv"); //diretório e arquivo são enxergues como a mesma coisa
		boolean existe =  false;	
		if (arq.exists()) {	existe = true; }

		File arquivo = new File("C:\\sistemas operacionais i\\ASOI_20230504_Steam\\steam_charts.csv");
		
		FileInputStream fluxo = new FileInputStream(arquivo);
		InputStreamReader leitor = new InputStreamReader(fluxo);
		BufferedReader buffer = new BufferedReader(leitor);
		FileWriter escritor = new FileWriter(arq,existe);
		PrintWriter print = new PrintWriter(escritor);
		
		String linha = buffer.readLine();
		linha = buffer.readLine();
		
		while(linha!=null) {
			String[] game = linha.split(",");
			if (Integer.parseInt(game[1])== ano && game[2].equalsIgnoreCase(mes)) {
				String conteudo = game[0]+ ";" + game[3] + ";\n";
				
				print.write(conteudo); 
				
				
				
			}
			linha = buffer.readLine();
		}
		
		
		System.out.println("Seu arquivo foi criado e salvo com sucesso!");
		print.flush();
		print.close(); 
		escritor.close();
		
		buffer.close();
		leitor.close();
		fluxo.close();
		
		}
}
