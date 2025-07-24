package io.altar.jseproject.textinterface.states;

import java.util.Scanner;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ProductRepository;
import io.altar.jseproject.repositories.ShelfRepository;

public class EditProduct extends State{
	@Override
	public int on() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\n===== EDITAR PRODUTO =====");
		System.out.println("Informe o ID do produto que deseja editar: ");
		
		if(scanner.hasNextLong()) { //verifica se o utilizador inseriu um nr valido
			long id = scanner.nextLong();
			scanner.nextLine(); //limpa o buffer
			
			Product produto = ProductRepository.getInstance().getById(id); //vai buscar produto ao repositorio
			
			if (produto != null) { //se o produto existir
                System.out.println("PRODUTO ENCONTRADO!");
                System.out.println("DESCONTO ATUAL: " + produto.getDescontoUni());
                System.out.println("IVA ATUAL: " + produto.getIva());
                System.out.println("PVP ATUAL: " + produto.getPvp());

                System.out.print("NOVO DESCONTO: ");
                while (!scanner.hasNextDouble()) { //valida q o input é um nr decimal
                    System.out.println("Insira um valor válido.");
                    scanner.nextLine();//limpa o input invalido
                }
                double novoDesconto = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("NOVO IVA: ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Insira um valor válido.");
                    scanner.nextLine();
                }
                double novoIva = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("NOVO PVP: ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Insira um valor válido.");
                    scanner.nextLine();
                }
                double novoPvp = scanner.nextDouble();
                scanner.nextLine();

                
                //aplica as alteraçoes ao obj
                produto.setDescontoUni(novoDesconto);
                produto.setIva(novoIva);
                produto.setPvp(novoPvp);
                
                // Pergunta se quer editar prateleiras associadas
                System.out.print("Deseja alterar a(s) prateleira(s) associada(s) a este produto? (s/n): ");
                String resposta = scanner.nextLine();

                if (resposta.equalsIgnoreCase("s")) {
                    // Remove a associação anterior 
                    for (Long idPrateleira : produto.getPrateleiras()) {
                        Shelf prateleira = ShelfRepository.getInstance().getById((long) idPrateleira);
                        if (prateleira != null && prateleira.getIdProduto() == produto.getId()) {
                            prateleira.setIdProduto(0); // remove associação
                            ShelfRepository.getInstance().edit(prateleira);
                        }
                    }
                    produto.getPrateleiras().clear(); // limpa lista de IDs no produto

                    // Permite uma nova associaçao
                    boolean continuar = true;
                    while (continuar) {
                        System.out.print("Insira o ID da nova prateleira: ");
                        if (scanner.hasNextLong()) {
                            long idNova = scanner.nextLong();
                            scanner.nextLine();

                            Shelf novaPrateleira = ShelfRepository.getInstance().getById(idNova);
                            if (novaPrateleira != null) {
                                novaPrateleira.setIdProduto((long) produto.getId());
                                ShelfRepository.getInstance().edit(novaPrateleira);

                                produto.getPrateleiras().add((Long) novaPrateleira.getId());
                                System.out.println("Nova prateleira associada.");
                            } else {
                                System.out.println("Prateleira não encontrada.");
                            }
                        } else {
                            System.out.println("ID inválido.");
                            scanner.nextLine();
                        }

                        System.out.print("Deseja associar outra prateleira? (s/n): ");
                        String outra = scanner.nextLine();
                        if (!outra.equalsIgnoreCase("s")) {
                            continuar = false;
                        }
                    }
                }

                ProductRepository.getInstance().edit(produto);

                System.out.println("Produto atualizado com sucesso.");
            } else {
                System.out.println("Produto com o ID " + id + " não encontrado.");
            }
        } else {
            System.out.println("ID inválido. Insira um número."); //só p caso do utilizador inseirr letras
            scanner.nextLine();
        }

        return 0; //volta p menu principal
    }
}