package io.altar.jseproject.textinterface;

import java.util.Scanner;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ProductRepository;
import io.altar.jseproject.repositories.ShelfRepository;

public class TextInterface {

	Scanner scanner = new Scanner(System.in);

	// criei duas arraylist p guardar em memória os produtos e prateleiras q forem
	// criados enquanto corre o programa
	// List<Product> produtos = new ArrayList<>();
	// List<Shelf> prateleiras = new ArrayList<>();

	ProductRepository productRepo = ProductRepository.getInstance();
	ShelfRepository shelfRepo = ShelfRepository.getInstance();

	public void menu() {
		int opcao = -1; // inicio c uma opçao invalida pq se nao o while nem chega a inicializar uma vez

		while (opcao != 3) {
			System.out.println("\n----- MENU PRINCIPAL -----");
			System.out.println("1 - Listar produtos");
			System.out.println("2 - Listar prateleiras");
			System.out.println("3 - Sair");
			System.out.print("Escolha uma opção: ");

			if (scanner.hasNextInt()) { // Valida se a entrada do utilizador é um número inteiro
				opcao = scanner.nextInt();
				scanner.nextLine(); // limpa o enter do buffer

				switch (opcao) {
				case 1:
					menuProdutos(); // chama o submenu dos produtos
					break;
				case 2:
					menuPrateleiras(); // chama o submenu das prateleiras
					break;
				case 3:
					System.out.println("Adeus!");
					break;
				default:
					System.out.println("Opção inválida.");
				}
			} else {
				System.out.println("Por favor, insira uma opção válida!");
				scanner.nextLine(); // consome a entrada inválida
			}
		}
	}

	// submenu dos produtos
	private void menuProdutos() {
		int opcao = -1;

		while (opcao != 5) {
			listarProdutos(); // primeiro mostra a lista
			System.out.println("----- GESTÃO DE PRODUTOS -----");
			System.out.println("1 - Criar novo produto");
			System.out.println("2 - Editar um produto existente");
			System.out.println("3 - Consultar o detalhe de um produto");
			System.out.println("4 - Remover um produto");
			System.out.println("5 - Voltar ao menu anterior");
			System.out.print("Escolha uma opção: ");

			if (scanner.hasNextInt()) {
				opcao = scanner.nextInt();
				scanner.nextLine();

				switch (opcao) {
				case 1:
					criarProduto();
					break;
				case 2:
					System.out.println("Insira o ID do produto que deseja editar");
					if (scanner.hasNextLong()) {
						long id = scanner.nextLong();
						scanner.nextLine(); // limpa o buffer

						Product produto = productRepo.getById(id);
						
//TODO NUMA UNICA ADIÇAO FAZER 3 REMOÇOES E 1 ADIÇAO
						
						if (produto != null) {
							// Mostra valores atuais
							System.out.println("Produto encontrado:");
							System.out.println("Desconto atual: " + produto.getDescontoUni());
							System.out.println("IVA atual: " + produto.getIva());
							System.out.println("PVP atual: " + produto.getPvp());

							// pede os novos valores
							System.out.print("Novo desconto: ");
							while (!scanner.hasNextDouble()) {
								System.out.println("Insira um valor válido.");
								scanner.nextLine();
							}
							double novoDesconto = scanner.nextDouble();
							scanner.nextLine();

							System.out.print("Novo IVA: ");
							while (!scanner.hasNextDouble()) {
								System.out.println("Insira um valor válido.");
								scanner.nextLine();
							}
							double novoIva = scanner.nextDouble();
							scanner.nextLine();

							System.out.print("Novo PVP: ");
							while (!scanner.hasNextDouble()) {
								System.out.println("Insira um valor válido.");
								scanner.nextLine();
							}
							double novoPvp = scanner.nextDouble();
							scanner.nextLine();

							// Aplica as alterações
							produto.setDescontoUni(novoDesconto);
							produto.setIva(novoIva);
							produto.setPvp(novoPvp);

							productRepo.edit(produto); // atualiza no repositorio
							System.out.println("Produto atualizado com sucesso.");

						} else {
							System.out.println("Produto com o ID " + id + " não encontrado.");
						}

					} else {
						System.out.println("ID inválido. Insira um número.");
						scanner.nextLine(); // limpa entrada inválida
					}
					break;

				case 3:
					System.out.println("Insira o ID do produto que deseja consultar: ");
					if (scanner.hasNextLong()) {// verifica se o q o utilizador inseriu é long
						long id = scanner.nextLong(); // guarda na variavel id
						scanner.nextLine(); // limpa o buffer
						Product produto = productRepo.getById(id); // acessa o repositorio, productRepo é a minha bd em
																	// memoria (hashmap) e o metodo getById vai
																	// prodcurar o produto c o id inserido pelo
																	// utilizador e se n encontrar vem null

						// mostrar detalhes
						if (produto != null) {
							System.out.println("----- DETALHES DO PRODUTO -----");
							System.out.println("ID: " + produto.getId());
							System.out.println("Desconto: " + produto.getDescontoUni());
							System.out.println("IVA: " + produto.getIva());
							System.out.println("PVP: " + produto.getPvp());
							System.out.println("------------------------------");

						} else {
							System.out.println("Produto com o ID " + id + " não encontrado.");
						}
					} else {
						System.out.println("ID inválido. Por favor insira um número.");
						scanner.nextLine();
					}
					break;

				case 4:
					System.out.println("Insira o ID do produto que deseja remover");

					if (scanner.hasNextLong()) {
						long id = scanner.nextLong();
						scanner.nextLine(); // limpa o buffer

						Product produto = productRepo.getById(id); // verifica se existe

						if (produto != null) {
							productRepo.remove(id); // Remove do HashMap<Long, Product> no repositorio
							System.out.println("Produto com ID " + id + " removido com sucesso!");
						} else {
							System.out.println("Produto com ID " + id + " não encontrado!");
						}
					} else {
						System.out.println("ID inválido. Por favor, insira um número.");
						scanner.nextLine();// limpa a entrada inválida
					}
					break;

				case 5:
					System.out.println("Menu reiniciado. Por favor, escolha uma das seguintes opções:\\n");
					break;
				default:
					System.out.println("Opção inválida.");
				}
			} else

			{
				System.out.println("Por favor, insira uma opção válida!");
				scanner.nextLine();
			}
		}
	}

	// submenu das prateleiras
	private void menuPrateleiras() {
		int opcao = -1;

		while (opcao != 5) {
			listarPrateleiras(); // primeiro mostra a lista
			System.out.println("----- GESTÃO DE PRATELEIRAS -----");
			System.out.println("1 - Criar nova prateleira");
			System.out.println("2 - Editar uma prateleira existente");
			System.out.println("3 - Consultar o detalhe de uma prateleira");
			System.out.println("4 - Remover uma prateleira");
			System.out.println("5 - Voltar ao menu anterior");
			System.out.print("Escolha uma opção: ");

			if (scanner.hasNextInt()) {
				opcao = scanner.nextInt();
				scanner.nextLine();

				switch (opcao) {
				case 1:
					criarPrateleira();
					break;
				case 2:
					System.out.println("Insira o ID da prateleira que deseja editar");
					if (scanner.hasNextLong()) {
						long id = scanner.nextLong();
						scanner.nextLine(); // limpa o buffer

						Shelf prateleira = shelfRepo.getById(id);

						if (prateleira != null) {
							// Mostra valores atuais
							System.out.println("Produto encontrado:");
							System.out.println("Capacidade atual: " + prateleira.getCapacidade());
							System.out.println("Preço Aluguer: " + prateleira.getPrecoAluguer());

							// pede os novos valores
							System.out.print("Nova Capacidade: ");
							while (!scanner.hasNextDouble()) {
								System.out.println("Insira um valor válido.");
								scanner.nextLine();
							}
							int novaCapacidade = scanner.nextInt();
							scanner.nextLine();

							System.out.print("Novo Preço Aluguer: ");
							while (!scanner.hasNextDouble()) {
								System.out.println("Insira um valor válido.");
								scanner.nextLine();
							}
							double novoPrecoAluguer = scanner.nextDouble();
							scanner.nextLine();

							// Aplica as alterações
							prateleira.setCapacidade(novaCapacidade);
							prateleira.setPrecoAluguer(novoPrecoAluguer);

							shelfRepo.edit(prateleira); // atualiza no repositorio
							System.out.println("Prateleira atualizada com sucesso.");

						} else {
							System.out.println("Prateleira com o ID " + id + " não encontrada.");
						}

					} else {
						System.out.println("ID inválido. Insira um número.");
						scanner.nextLine(); // limpa entrada inválida
					}
					break;

				case 3:
					System.out.println("Insira o ID da prateleira que deseja consultar: ");
					if (scanner.hasNextLong()) {// verifica se o q o utilizador inseriu é long
						long id = scanner.nextLong(); // guarda na variavel id
						scanner.nextLine(); // limpa o buffer
						Shelf prateleira = shelfRepo.getById(id);

						// mostrar detalhes
						if (prateleira != null) {
							System.out.println("----- DETALHES DA PRATELEIRA-----");
							System.out.println("ID: " + prateleira.getId());
							System.out.println("Capacidade: " + prateleira.getCapacidade());
							System.out.println("Preço Aluguer: " + prateleira.getPrecoAluguer());
							System.out.println("------------------------------");

						} else {
							System.out.println("Prateleira com o ID " + id + " não encontrada.");
						}
					} else {
						System.out.println("ID inválido. Por favor insira um número.");
						scanner.nextLine();
					}
					break;

				case 4:
					System.out.println("Insira o ID da prateleira que deseja remover");

					if (scanner.hasNextLong()) {
						long id = scanner.nextLong();
						scanner.nextLine(); // limpa o buffer

						Shelf prateleira = shelfRepo.getById(id); // verifica se existe

						if (prateleira != null) {
							shelfRepo.remove(id); // Remove do HashMap<Long, Shelf> no repositório
							System.out.println("Prateleira com ID " + id + " removida com sucesso!");
						} else {
							System.out.println("Prateleira com ID " + id + " não encontrada!");
						}
					} else {
						System.out.println("ID inválido. Por favor, insira um número.");
						scanner.nextLine(); // limpa a entrada inválida
					}
					break;
					
				case 5:
					System.out.println("Menu reiniciado. Por favor, escolha uma das seguintes opções:\\n");
					break;
				default:
					System.out.println("Opção inválida.");
				}
			} else {
				System.out.println("Por favor, insira uma opção válida!");
				scanner.nextLine();
			}
		}
	}

	// metodos

	public void criarProduto() {
		System.out.println("----- CRIAR PRODUTO -----");

		// Pede e valida o desconto
		System.out.print("Insira o desconto: ");
		while (!scanner.hasNextDouble()) {
			System.out.println("Por favor, insira um valor válido!");
			scanner.nextLine();
		}
		double desconto = scanner.nextDouble();
		scanner.nextLine();

		// Pede e valida o IVA
		System.out.print("Insira o IVA: ");
		while (!scanner.hasNextDouble()) {
			System.out.println("Por favor, insira um valor válido!");
			scanner.nextLine();
		}
		double iva = scanner.nextDouble();
		scanner.nextLine();

		// Pede e valida o PVP
		System.out.print("Insira o PVP: ");
		while (!scanner.hasNextDouble()) {
			System.out.println("Por favor, insira um valor válido!");
			scanner.nextLine();
		}
		double pvp = scanner.nextDouble();
		scanner.nextLine();

		// Cria o produto e guarda na lista
		Product novoProduto = new Product(desconto, iva, pvp);
		productRepo.create(novoProduto);
		// produtos.add(novoProduto); // guarda

		System.out.println("Produto criado.");
	}

	public void criarPrateleira() {
		System.out.println("----- CRIAR PRATELEIRA -----");

		// Pede e valida a capacidade
		System.out.print("Insira a capacidade: ");
		while (!scanner.hasNextInt()) {
			System.out.println("Por favor, insira um valor válido!");
			scanner.nextLine();
		}
		int capacidade = scanner.nextInt();
		scanner.nextLine();

		// Pede e valida o preço de aluguer
		System.out.print("Insira o preço de aluguer: ");
		while (!scanner.hasNextDouble()) {
			System.out.println("Por favor, insira um valor válido!");
			scanner.nextLine();
		}
		double precoAluguer = scanner.nextDouble();
		scanner.nextLine();

		// Cria a prateleira e guarda na lista
		Shelf novaPrateleira = new Shelf(capacidade, precoAluguer);
		shelfRepo.create(novaPrateleira); // guarda

	}

	public void listarProdutos() {
		System.out.println("----- LISTA DE PRODUTOS -----");
		// Verifica se há produtos na lista
		if (productRepo.getAll().isEmpty()) {
			System.out.println("Ainda não foram criados produtos.");
			return;
		}

		// Percorre e mostra os detalhes de cada produto
		for (Product produto : productRepo.getAll()) {
			System.out.println("ID: " + produto.getId());
			System.out.println("Desconto: " + produto.getDescontoUni());
			System.out.println("IVA: " + produto.getIva());
			System.out.println("PVP: " + produto.getPvp());
			System.out.println("----------------------------");
		}
	}

	public void listarPrateleiras() {
		System.out.println("----- LISTA DE PRATELEIRAS -----");
		// Verifica se há prateleiras na lista
		if (shelfRepo.getAll().isEmpty()) {
			System.out.println("Ainda não foram criadas prateleiras.");
			return;
		}

		// Percorre e mostra os detalhes de cada prateleira
		for (Shelf prateleira : shelfRepo.getAll()) {
			System.out.println("ID: " + prateleira.getId());
			System.out.println("Capacidade: " + prateleira.getCapacidade());
			System.out.println("Preço de aluguer: " + prateleira.getPrecoAluguer());
			System.out.println("----------------------------");
		}
	}

}
