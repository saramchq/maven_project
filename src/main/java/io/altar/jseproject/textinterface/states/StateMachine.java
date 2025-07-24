package io.altar.jseproject.textinterface.states;

import java.util.Scanner;

public class StateMachine {

	@SuppressWarnings("unused")
	private Scanner scanner = new Scanner(System.in);

	//posseveis estados da app
	private State[] states = { new MenuInit(), // 0
			new ListProducts(), // 1
			new CreateProduct(), // 2
			new ConsultProduct(),// 3
			new EditProduct(), // 4
			new DeleteProduct(), // 5
			new ListShelves(), // 6
			new CreateShelf(), // 7
			new ConsultShelf(), //8
			new EditShelf(), // 9
			new DeleteShelf() // 10
	};
	
	private int[][] transitions = {
			//menuInit 0
			{1,6,-1},
			
			//ListProducts 1
			{0,2,3,4,5},
			
			//CreateProduct 2
			{0},
			
			//ConsultProduct 3
			{0},
			
			//EditProduct 4
			{0},
			
			//DeleteProduct 5
			{0},
			
			//ListShelves 6
			{0,7,8,9,10},
			
			//CreateShelf 7
			{0},
			
			//ConsultShelf 8
			{0},
			
			//EditShelf 9
			{0},
			
			//DeleteShelf 10
			{0}
			
	};
	
	private int currentStateIndex = 0; //indice do estado atual, começa no menuinit
	
	//arranca c loop
	public void start() {
		while(currentStateIndex != -1) {
			int option = states[currentStateIndex].on(); //executa o estado atual e guarda a opçao escolhida
			
			if (option == -1) { //se escolher -1 o programa termina
				System.out.println("Obrigada por usar o meu programa. Adeus!");
				break;
			}
			
			//se a opçao escolhida pelo utilizador for maior ou igual a 0 e menor q o nr de opçoes disponiveis no estado atual ent é valida
			if (option >= 0 && option < transitions [currentStateIndex].length) { 
				currentStateIndex = transitions[currentStateIndex][option]; //atualiza o estado atual c o proximo estado indicado na tabela de transiçoes c base na opçao do utilizador
			} else {
				System.out.println("Opção inválida. De volta ao menu anterior.");
				currentStateIndex = 0;
			}
		}
	}
}
