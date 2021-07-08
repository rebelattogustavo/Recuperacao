package br.com.senai.pp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.motorista.Motorista;
import br.com.motorista.MotoristaController;
import br.com.veiculo.Veiculo;
import br.com.veiculo.VeiculoController;

public class programaPrincipal {

	public static void main(String[] args) {

		List<Veiculo> veiculos = new ArrayList<Veiculo>();
		List<Motorista> motoristas = new ArrayList<Motorista>();

		Scanner in = new Scanner(System.in);
		boolean sair = true;

		VeiculoController veiculoController = new VeiculoController();
		MotoristaController motoristaController = new MotoristaController();

		do {

			System.out.println("-----------------------------------");
			System.out.println("| 1-> MENU DE VEICULOS            |");
			System.out.println("| 2-> MENU DE MOTORISTAS          |");
			System.out.println("| 0-> SAIR                        |");
			System.out.println("-----------------------------------");
			System.out.print("Informe a opção desejada -> ");
			int opcao = in.nextInt();

			switch (opcao) {
			case 1:
				veiculoController.menuVeiculo(veiculos, motoristas);
				break;

			case 2:
				motoristaController.menuMotorista(motoristas, veiculos);
				break;

			case 0:

				sair = false;
				break;

			default:
				System.out.print("\n");
				System.out.println("Opção Inválida!");
				break;
			}

		} while (sair);
		System.out.print("\n");
		System.out.println("Sistema Finalizado");
	}

}