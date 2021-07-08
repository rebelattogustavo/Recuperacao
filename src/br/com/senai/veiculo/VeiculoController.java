package br.com.senai.veiculo;

import java.util.List;
import java.util.Scanner;

import br.com.motorista.Motorista;

public class VeiculoController {

	private Scanner in;

	public VeiculoController() {
		in = new Scanner(System.in);
	}

	public void menuVeiculo(List<Veiculo> veiculos, List<Motorista> motoristas) {

		System.out.println("-----------------------------------");
		System.out.println("| 1-> CADASTAR VEICULOS           |");
		System.out.println("| 2-> LISTAR VEICULOS             |");
		System.out.println("| 3-> EDITAR VEICULOS             |");
		System.out.println("| 4-> EXCLUIR VEICULOS            |");
		System.out.println("-----------------------------------");
		System.out.print("Informe a opção desejada -> ");
		int opcao = in.nextInt();

		switch (opcao) {
		case 1:
			veiculos.add(cadastrarVeiculos());
			break;

		case 2:
			listarVeiculos(veiculos);
			break;

		case 3:
			editarVeiculos(veiculos, motoristas);
			break;

		case 4:
			excluirVeiculo(veiculos, motoristas);
			break;

		default:
			System.out.println("Opção Inválida!");
			break;

		}

	}

	public Veiculo cadastrarVeiculos() {
		System.out.print("\n");
		System.out.println("----CADASTRAR--VEICULO----");

		Veiculo veiculo = new Veiculo();

		in.nextLine();
		System.out.print("\n");
		System.out.print("Informe o nome do veiculo -> ");
		veiculo.setModelo(in.nextLine());

		System.out.print("Informe a marca do veiculo -> ");
		veiculo.setMarca(in.nextLine());

		System.out.print("Informe a placa do veiculo -> ");
		veiculo.setPlaca(in.nextLine());

		System.out.print("Informe o ano do veiculo -> ");
		veiculo.setAnodoveiculo(in.nextInt());

		System.out.print("Informe o tipo de combustível -> ");
		veiculo.setTipodecombustivel(in.next());

		return veiculo;

	}

	public List<Veiculo> listarVeiculos(List<Veiculo> veiculos) {

		if (veiculos.isEmpty()) {
			System.out.print("\n");
			System.out.println("nao possui dados cadastrados");
			return null;
		}

		System.out.print("\n");
		System.out.println("----VEICULOS--CADASTRADOS----");

		System.out.printf("| %2s | %20s | %20s | %10s | %4s | %15s |\n", "Id", "Nome do Veiculo", "Marca", "Placa",
				"Ano", "Combustivel");

		for (int i = 0; i < veiculos.size(); i++) {
			System.out.printf("| %2d | %20s | %20s | %10s | %4s | %15s |\n", i + 1, veiculos.get(i).getModelo(),
					veiculos.get(i).getMarca(), veiculos.get(i).getPlaca(), veiculos.get(i).getAnodoveiculo(),
					veiculos.get(i).getTipodecombustivel());
		}

		return veiculos;

	}

	public List<Veiculo> editarVeiculos(List<Veiculo> veiculos, List<Motorista> motoristas) {

		if (veiculos.isEmpty()) {
			System.out.println("Não possui veiculos cadastrados.");
			return null;
		}

		listarVeiculos(veiculos);

		Veiculo veiculo = new Veiculo();
		Motorista motorista = new Motorista();

		System.out.println("----EDITAR--VEICULO----");

		System.out.print("Informe o Id do Veiculo para editar: ");
		int idVeiculo = in.nextInt() - 1;

		System.out.println("\n");
		System.out.println("-----------------------------------");
		System.out.println("| 1-> NOME DO VEICULO             |");
		System.out.println("| 2-> PLACA DO VEICULO            |");
		System.out.println("| 3-> ANO DO VEICULO              |");
		System.out.println("| 4-> TIPO DE COMBUSTIVEL         |");
		System.out.println("| 5-> MARCA DO VEICULO            |");
		System.out.println("-----------------------------------");
		System.out.print("Informe a opção desejada -> ");
		int opcao = in.nextInt();
		in.nextLine();

		switch (opcao) {
		case 1:
			System.out.print("\n");
			System.out.println("----EDITAR--NOME----");
			System.out.print("\n");
			System.out.print("Informe novamente o nome do Veiculo -> ");
			veiculo.setModelo(in.nextLine());

			veiculo.setAnodoveiculo(veiculos.get(idVeiculo).getAnodoveiculo());
			veiculo.setPlaca(veiculos.get(idVeiculo).getPlaca());
			veiculo.setMarca(veiculos.get(idVeiculo).getMarca());
			veiculo.setTipodecombustivel(veiculos.get(idVeiculo).getTipodecombustivel());
			veiculo.setMarca(veiculos.get(idVeiculo).getMarca());
			break;

		case 2:
			System.out.print("\n");
			System.out.println("----EDITAR--PLACA----");
			System.out.print("\n");
			System.out.print("Informe novamente a placa do veiculo -> ");
			veiculo.setPlaca(in.nextLine());

			veiculo.setMarca(veiculos.get(idVeiculo).getMarca());
			veiculo.setTipodecombustivel(veiculos.get(idVeiculo).getTipodecombustivel());
			veiculo.setAnodoveiculo(veiculos.get(idVeiculo).getAnodoveiculo());
			veiculo.setModelo(veiculos.get(idVeiculo).getModelo());
			veiculo.setMarca(veiculos.get(idVeiculo).getMarca());
			break;

		case 3:
			System.out.print("\n");
			System.out.println("----EDITAR--ANO----");
			System.out.print("\n");
			System.out.print("Informe novamente o ano do veiculo -> ");
			veiculo.setAnodoveiculo(in.nextInt());

			veiculo.setMarca(veiculos.get(idVeiculo).getMarca());
			veiculo.setTipodecombustivel(veiculos.get(idVeiculo).getTipodecombustivel());
			veiculo.setModelo(veiculos.get(idVeiculo).getModelo());
			veiculo.setPlaca(veiculos.get(idVeiculo).getPlaca());
			veiculo.setMarca(veiculos.get(idVeiculo).getMarca());
			break;

		case 4:
			System.out.print("\n");
			System.out.println("----EDITAR--COMBUSTIVEL----");
			System.out.print("\n");
			System.out.print("Informe novamente o tipo de combustivel do veiculo -> ");
			veiculo.setTipodecombustivel(in.next());

			veiculo.setModelo(veiculos.get(idVeiculo).getModelo());
			veiculo.setPlaca(veiculos.get(idVeiculo).getPlaca());
			veiculo.setMarca(veiculos.get(idVeiculo).getMarca());
			veiculo.setAnodoveiculo(veiculos.get(idVeiculo).getAnodoveiculo());
			veiculo.setMarca(veiculos.get(idVeiculo).getMarca());
			break;

		case 5:
			System.out.print("\n");
			System.out.println("----EDITAR--MARCA----");
			System.out.print("\n");
			System.out.print("Informe novamente a marca do veiculo -> ");
			veiculo.setMarca(in.next());

			veiculo.setModelo(veiculos.get(idVeiculo).getModelo());
			veiculo.setPlaca(veiculos.get(idVeiculo).getPlaca());
			veiculo.setMarca(veiculos.get(idVeiculo).getMarca());
			veiculo.setAnodoveiculo(veiculos.get(idVeiculo).getAnodoveiculo());
			veiculo.setTipodecombustivel(veiculos.get(idVeiculo).getTipodecombustivel());
			break;

		default:
			System.out.println("Opção Inválida!");
			break;
		}

		veiculos.set(idVeiculo, veiculo);
		return veiculos;

	}

	public void excluirVeiculo(List<Veiculo> veiculos, List<Motorista> motoristas) {

		if (veiculos.isEmpty()) {
			System.out.print("\n");
			System.out.println("Não possui dados cadastrados!");
			return;
		}

		listarVeiculos(veiculos);
		System.out.print("\n");
		System.out.println("----EXCLUIR--VEICULO----");
		System.out.print("\n");
		System.out.print("Informe o ID do veiculo para excluir -> ");
		int idVeiculo = in.nextInt() - 1;

		String modelo = veiculos.get(idVeiculo).getModelo();

		for (int i = 0; i < motoristas.size(); i++) {
			String motoristaEVeiculo = motoristas.get(i).getVeiculo().getModelo();

			if (motoristaEVeiculo.equals(modelo)) {
				System.out.print("\n");
				System.out.println("Não foi possivel excluir o veiculo!");
				return;
			}

		}

		if (veiculos.size() <= idVeiculo) {

			return;
		}

		veiculos.remove(idVeiculo);
	}
}