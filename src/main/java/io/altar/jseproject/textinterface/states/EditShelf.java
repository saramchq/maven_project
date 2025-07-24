package io.altar.jseproject.textinterface.states;

import java.util.Scanner;

import io.altar.jseproject.model.Shelf; 
import io.altar.jseproject.repositories.ShelfRepository; 

public class EditShelf extends State { 

    @Override
    public int on() { 
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in); 

        System.out.println("\n===== EDITAR PRATELEIRA =====");
        System.out.print("Insira o ID da prateleira a editar: ");

        // verifica se o utilizador introduziu um nr
        if (scanner.hasNextLong()) {
            long id = scanner.nextLong(); 
            scanner.nextLine(); // Limpa o enter do buffer

            // Procura a prateleira no repositório
            Shelf prateleira = ShelfRepository.getInstance().getById(id);

            if (prateleira != null) { // Se a prateleira foi encontrada
                System.out.println("PRATELEIRA ENCONTRADA:");
                System.out.println("CAPACIDADE ATUAL: " + prateleira.getCapacidade());
                System.out.println("PREÇO DE ALUGUER ATUAL: " + prateleira.getPrecoAluguer());

                // Pede nova capacidade
                System.out.print("NOVA CAPACIDADE: ");
                while (!scanner.hasNextInt()) { // Valida se o valor é inteiro
                    System.out.println("Insira um valor válido.");
                    scanner.nextLine();
                }
                int novaCapacidade = scanner.nextInt();
                scanner.nextLine();

                // Pede novo preço de aluguer
                System.out.print("NOVO PREÇO DE ALUGUER: ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Insira um valor válido.");
                    scanner.nextLine();
                }
                double novoPreco = scanner.nextDouble();
                scanner.nextLine();

                // Atualiza os valores
                prateleira.setCapacidade(novaCapacidade);
                prateleira.setPrecoAluguer(novoPreco);

                // Atualiza no repositório
                ShelfRepository.getInstance().edit(prateleira);

                System.out.println("Prateleira atualizada com sucesso.");
            } else {
                System.out.println("Prateleira com o ID " + id + " não encontrada.");
            }
        } else {
            System.out.println("ID inválido. Insira um número."); // Caso o input seja texto 
            scanner.nextLine();
        }

        return 0; // Volta ao menu principal
    }
}
