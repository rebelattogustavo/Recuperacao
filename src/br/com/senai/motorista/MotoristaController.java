package br.com.senai.motorista;

import java.util.List;
import java.util.Scanner;

import br.com.veiculo.Veiculo;
import br.com.veiculo.VeiculoController;

public class MotoristaController {

	private Scanner in;

	public MotoristaController() {
		in = new Scanner(System.in);

	}

	public void menuMotorista(List<Motorista> motoristas, List<Veiculo> veiculos) {

		System.out.println("-----------------------------------");
		System.out.println("| 1-> CADASTAR MOTORISTAS         |");
		System.out.println("| 2-> LISTAR MOTORISTAS           |");
		System.out.println("| 3-> EDITAR MOTORISTAS           |");
		System.out.println("| 4-> EXCLUIR MOTORISTAS          |");
		System.out.println("-----------------------------------");
		System.out.print("Informe a opção desejada -> ");
		int opcao = in.nextInt();

		switch (opcao) {
		case 1:
			motoristas.add(cadastrarMotoristas(veiculos));
			break;

		case 2:
			listarMotoristas(motoristas);
			break;

		case 3:
			editarMotoristas(motoristas);
			break;

		case 4:
			excluirMotorista(motoristas);
			break;

		default:
			System.out.println("Opção Inválida!");
			break;

		}

	}

	public Motorista cadastrarMotoristas(List<Veiculo> veiculos) {

		if (veiculos.isEmpty()) {

			System.out.println("Não possui veiculos cadastrados.");
			return null;
		}

		System.out.print("\n");
		System.out.println("----CADASTRAR--MOTORISTA----");

		VeiculoController veiculoController = new VeiculoController();
		Motorista motorista = new Motorista();

		veiculoController.listarVeiculos(veiculos);

		System.out.println("----ID--VEICULO----");

		System.out.print("Informe o ID do veiculo desejado -> ");
		int idVeiculo = in.nextInt() - 1;

		motorista.setVeiculo(veiculos.get(idVeiculo));
		System.out.print("\n");
		System.out.println("----INFORMAÇÕES--DO--MOTORISTA----");

		in.nextLine();

		System.out.print("Informe o nome do motorista: ");
		motorista.setNome(in.nextLine());

		System.out.print("Informe a idade do motorista: ");
		motorista.setIdade(in.nextInt());

		System.out.print("Informe a categoria da CNH do motorista [A,B,C,D,E...]: ");
		motorista.setCategCNH(in.next());

		return motorista;

	}

	public List<Motorista> listarMotoristas(List<Motorista> motoristas) {

		if (motoristas.isEmpty()) {
			System.out.println("Não possui dados cadastrados");
			return null;
		}

		System.out.print("\n");
		System.out.println("----MOTORISTAS--CADASTRADOS----");

		System.out.printf("| %2s | %20s | %8s | %2s |\n", "ID", "Nome", "Idade", "Categoria CNH");

		for (int i = 0; i < motoristas.size(); i++) {

			System.out.printf("| %2s | %20s | %8s | %13s |\n", i + 1, motoristas.get(i).getNome(),
					motoristas.get(i).getIdade(), motoristas.get(i).getCategCNH());
		}

		return motoristas;
	}

	public List<Motorista> editarMotoristas(List<Motorista> motoristas) {

		if (motoristas.isEmpty()) {
			System.out.println("Não possui dados cadastrados");
			return null;
		}

		listarMotoristas(motoristas);

		Motorista motorista = new Motorista();

		System.out.print("\n");
		System.out.println("----EDITAR--MOTORISTA----");
		System.out.print("\n");
		System.out.print("Informe o ID do motorista -> ");
		int idMotorista = in.nextInt() - 1;

		System.out.println("\n");
		System.out.println("-----------------------------------");
		System.out.println("| 1-> NOME DO MOTORISTA           |");
		System.out.println("| 2-> IDADE DO MOTORISTA          |");
		System.out.println("| 3-> CATEGORIA CNH               |");
		System.out.println("-----------------------------------");
		System.out.print("Informe a opção desejada -> ");
		int opcao = in.nextInt();
		in.nextLine();

		switch (opcao) {
		case 1:
			System.out.print("\n");
			System.out.println("----EDITAR--NOME----");
			System.out.print("\n");
			System.out.print("Informe novamente o nome do Motorista -> ");
			motorista.setNome(in.nextLine());

			motorista.setCategCNH(motoristas.get(idMotorista).getCategCNH());
			motorista.setIdade(motoristas.get(idMotorista).getIdade());
			break;

		case 2:
			System.out.print("\n");
			System.out.println("----EDITAR--IDADE----");
			System.out.print("\n");
			System.out.print("Informe novamente a idade do Motorista -> ");
			motorista.setIdade(in.nextInt());

			motorista.setCategCNH(motoristas.get(idMotorista).getCategCNH());
			motorista.setNome(motoristas.get(idMotorista).getNome());
			break;

		case 3:
			System.out.print("\n");
			System.out.println("----EDITAR--CNH----");
			System.out.print("\n");
			System.out.print("Informe novamente a CNH do Motorista -> ");
			motorista.setCategCNH(in.next());

			motorista.setIdade(motoristas.get(idMotorista).getIdade());
			motorista.setNome(motoristas.get(idMotorista).getNome());
			break;

		default:
			System.out.println("\nOpção Inválida!");
			break;

		}

		motoristas.set(idMotorista, motorista);
		return motoristas;

	}

	public void excluirMotorista(List<Motorista> motoristas) {

		if (motoristas.isEmpty()) {
			System.out.print("\n");
			System.out.println("Não possui dados cadastrados.");
			return;
		}

		listarMotoristas(motoristas);
		System.out.print("\n");
		System.out.println("----EXCLUIR--MOTORISTA----");
		System.out.print("\n");
		System.out.print("Informe o Id do aluno para excluir -> ");
		int idMotorista = in.nextInt() - 1;

		if (motoristas.size() <= idMotorista) {
			System.out.print("\n");
			System.out.println("Nenhum aluno cadastrado.");
			return;
		}

		motoristas.remove(idMotorista);

	}
}