/*
RESUMO      : Classe de leitura e análise do arquivo solicitado e criação de um novo
PROGRAMADORA: Luiza Felix
DATA        : 15/05/2023
 */

package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.Controller;

public class Principal {

	public static void main(String[] args) throws IOException {
		int opcao = 0;
		
		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog("1. Buscar jogos\n2. Registrar jogos\nPara SAIR digite 0;"));
			
			switch(opcao) {
			case 1:
				busca();
				break;
			case 2:
				save();
				break;
			case 0:
				System.out.println("Programa finalizado com sucesso!");
			}
		}while(opcao!=0);


	}

	private static void busca() throws IOException {
		String busca = JOptionPane.showInputDialog("Digite o ano, mês e média de jogadores daquele ano seguindo o modelo 'ANO;MÊS;AVG'");
		
		String[] dados = busca.split(";");
		Controller.busca(Integer.parseInt(dados[0]), dados[1], Double.parseDouble(dados[2]));
		
	}
	private static void save() throws IOException {
		String save = JOptionPane.showInputDialog("Digite o ano, mês e nome do arquivo em que deseja salvar os jogos seguindo o modelo 'ANO;MÊS;NOME'");
		
		String[] dados = save.split(";");
		Controller.registro(Integer.parseInt(dados[0]), dados[1], dados[2]);
		
	}

	

}
