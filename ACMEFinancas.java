package ACMEFinancas;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ACMEFinancas {
	private Cadastro cadastro;
	private Scanner entrada;

	public ACMEFinancas() {
		cadastro = new Cadastro();
		entrada = new Scanner(System.in);
	}

	public void inicializa() {
		Servico s1 = new Servico(1, "consultoria", 10000 , "empresarial" );
		Servico s2 = new Servico(2, "consultoria", 8000, "empresarial");
		Veiculo v1 = new Veiculo(3,"Camaro", 250000, "esportivo");
		Servico s3 = new Servico(4, "consultoria", 8000, "pessoal");
		Veiculo v2 = new Veiculo(5,"Uno Mille", 50000, "popular");
		Veiculo v3 = new Veiculo(6,"Tucson", 50000,"basico");
		Servico s4 = new Servico(7,"assesoria",1500, "pessoal");
		cadastro.adiciona(s1);
		cadastro.adiciona(s2);
		cadastro.adiciona(v1);
		cadastro.adiciona(s3);
		cadastro.adiciona(v2);
		cadastro.adiciona(v3);
		cadastro.adiciona(s4);

	}

	public void executa() {
		int opcao = 2;
		do{
			apresentarMenu();
			boolean error = false;

			do {
				error = false;
				try {
					do {
						opcao = entrada.nextInt();
						if (opcao < 0 || opcao > 5) {
							System.out.println("ERRO DE DIGITAÇÃO. Entre com um número entre 0 e 5.");
						}
					}while(opcao < 0 || opcao > 5);
				} catch (InputMismatchException e) {
					System.out.println("ERRO DE DIGITAÇÃO. Entre com um número entre 0 e 5.");
					error = true;
					entrada.nextLine();
					apresentarMenu();
				}
			}while(error);

			switch(opcao){
				case 1: {
					System.out.println("Você deseja cadastrar um serviço ou um veículo? ");
					System.out.println("Digite 1-serviço");
					System.out.println("Digite 2-veiculo");
					boolean error2 = false;
					int op = 0;
					do {
						error2 = false;
						try {
							op = entrada.nextInt();
							while (op != 1 && op != 2) {
								System.out.println("Digite uma opção válida! 1 ou 2.");
								op = entrada.nextInt();
							}
								if (op == 1) {
									System.out.println("Informe o identificador do serviço");
									int identificador = entrada.nextInt();
									System.out.println("Informe o nome do serviço");
									entrada.nextLine();
									String nome = entrada.nextLine();
									System.out.println("Informe o valor base do serviço");
									double valorBase = entrada.nextDouble();
									System.out.println("Informe o tipo do serviço");
									entrada.nextLine();
									String tipo = entrada.nextLine();
									while(!tipo.equalsIgnoreCase("pessoal") && !tipo.equalsIgnoreCase("empresarial")){
										System.out.println("Digite um tipo válido.");
										System.out.println("Informe o tipo do serviço:");
										tipo = entrada.nextLine();
									}
									Servico servico = new Servico(identificador, nome, valorBase, tipo);
									if (cadastro.adiciona(servico)) {
										System.out.println("Serviço adicionado com sucesso.");
									} else {
										System.out.println("Item repetido.");
									}
								}
								if (op == 2) {
									System.out.println("Informe o identificador do veiculo");
									int identificador = entrada.nextInt();
									System.out.println("Informe o nome do veiculo");
									entrada.nextLine();
									String nome = entrada.nextLine();
									System.out.println("Informe o valor base do veiculo");
									double valorBase = entrada.nextDouble();
									System.out.println("Informe o tipo do veiculo");
									entrada.nextLine();
									String tipo = entrada.nextLine();
									Veiculo veiculo = new Veiculo(identificador, nome, valorBase, tipo);
									if (cadastro.adiciona(veiculo)) {
										System.out.println("Veiculo adicionado com sucesso.");
									} else {
										System.out.println("Item repetido.");
									}
								}
						} catch (InputMismatchException e) {
							System.out.println("ERRO DE DIGITAÇÃO. Digite 1 ou 2:");
							entrada.nextLine();
							error = true;
						}
					}while (error);
					break;
				}
				case 2: {
					ArrayList<Cobravel> array = cadastro.pesquisa();
					if(array.size()==0){
						System.out.println("Nenhum item cadastrado.");
					} else {
						for(Cobravel c : array){
							System.out.println(c.toString());
						}
					}
					break;
				}
				case 3: {
					System.out.println("Informe o nome do item que deseja pesquisar:");
					entrada.nextLine();
					String s = entrada.nextLine();
					ArrayList<Cobravel> array = cadastro.pesquisa(s);
					if(array==null){
						System.out.println("Nenhum item foi localizado com este nome");
					} else {
						for(Cobravel c : array) {
							System.out.println(c.toString());
						}
					}
					break;
				}
				case 4: {
					System.out.println("Informe o identificador do item:");
					boolean error4 = false;

					do{
						error4 = false;
						try{
							int id = entrada.nextInt();
							double result = cadastro.calculaImpostoItem(id);
							if(result==-1){
								System.out.println("Nenhum item foi localizado com este identificador.");
							} else {
								System.out.println("Valor total do imposto: " + result);
							}
						}
						catch (InputMismatchException e){
							System.out.println("ERRO DE DIGITAÇÃO. Entre com um número.");
							entrada.nextLine();
							error4 = true;
						}
					}while (error4);

					break;
				}
				case 5: {
					System.out.println("Informe o nome do arquivo para salvamento de dados:");
					entrada.nextLine();
					String s = entrada.nextLine();
					cadastro.salvaArquivoTexto(s);
					break;
				}
				case 0: {
					System.out.println("Programa finalizado.");
					break;
				}
			}

		} while(opcao!=0);

	}

	public void apresentarMenu(){
		System.out.println("-----MENU DE OPÇÕES-----");
		System.out.println("[1] Cadastrar item cobrável.");
		System.out.println("[2] Mostrar todas as informações do cadastro.");
		System.out.println("[3] Pesquisar item por nome.");
		System.out.println("[4] Calcular imposto de item.");
		System.out.println("[5] Salvar arquivos de dados.");
		System.out.println("[0] Sair.");
	}

}
