package app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.altar.jseproject.textinterface.states.ConsultProduct;
import io.altar.jseproject.textinterface.states.ConsultShelf;
import io.altar.jseproject.textinterface.states.CreateProduct;
import io.altar.jseproject.textinterface.states.CreateShelf;
import io.altar.jseproject.textinterface.states.DeleteProduct;
import io.altar.jseproject.textinterface.states.DeleteShelf;
import io.altar.jseproject.textinterface.states.EditProduct;
import io.altar.jseproject.textinterface.states.EditShelf;
import io.altar.jseproject.textinterface.states.ListProducts;
import io.altar.jseproject.textinterface.states.ListShelves;
import io.altar.jseproject.textinterface.states.MenuInit;
import io.altar.jseproject.textinterface.states.State;

public class StateMachineTest {

private State[] states; //array p simular os estados possiveis
private int[][] transitions; // matriz q simula as transiçoes entre os states

@BeforeEach // este metodo corre antes de cada teste
public void setup() {
	//inicializa os states simulados como estao na verdadeira statemachine
	states = new State[] {
			new MenuInit(), //0
			new ListProducts(), //1
			new CreateProduct(), //2
			new ConsultProduct(),//3
			new EditProduct(), //4
			new DeleteProduct(),//5
			new ListShelves(),//6
			new CreateShelf(),//7
			new ConsultShelf(),//8
			new EditShelf(),//9
			new DeleteShelf()//10
			
	};
	
	//define as transiçoes simuladas
	
	transitions = new int [][] {
		   {1, 6, -1},        // Transições a partir do MenuInit (estado 0)
           {0, 2, 3, 4, 5},   // Transições a partir de ListProducts (estado 1)
           {0},               // CreateProduct (estado 2)
           {0},               // ConsultProduct (estado 3)
           {0},               // EditProduct (estado 4)
           {0},               // DeleteProduct (estado 5)
           {0, 7, 8, 9, 10},  // ListShelves (estado 6)
           {0},               // CreateShelf (estado 7)
           {0},               // ConsultShelf (estado 8)
           {0},               // EditShelf (estado 9)
           {0}                // DeleteShelf (estado 10)
       };
   }

@Test //transiçoes a partir do MenuInit
public void testTransitionsFromMenuInit() {
	assertEquals(1, transitions[0][0]); //verifica se ao escolher a opçao 0 vamos p indice 1
	assertEquals(6, transitions[0][1]); // verifica se ao escolher 1 vamos p indice 6
	assertEquals(-1, transitions[0][2]); // verifica se ao escolher 2 terminamos o programa -1
	}

@Test //testa se ao sair de listproducts volta ao menuinit
public void testReturnToMenuInitFromListProducts() {
	assertEquals(0, transitions[1][0]); //verifica se a opçao 0 em listproducts(state 1) volta ao menuinit(state0)
}

@Test
public void testStateClassesOrder() { //verifica se os estados do array correspondem corretamente a matriz transitions
    assertEquals(MenuInit.class, states[0].getClass());
    assertEquals(ListProducts.class, states[1].getClass());
    assertEquals(CreateProduct.class, states[2].getClass());
    assertEquals(ConsultProduct.class, states[3].getClass());
    assertEquals(EditProduct.class, states[4].getClass());
    assertEquals(DeleteProduct.class, states[5].getClass());
    assertEquals(ListShelves.class, states[6].getClass());
    assertEquals(CreateShelf.class, states[7].getClass());
    assertEquals(ConsultShelf.class, states[8].getClass());
    assertEquals(EditShelf.class, states[9].getClass());
    assertEquals(DeleteShelf.class, states[10].getClass());
}

}

// assertEquals é um método de teste JUnit p verificar se dois valores são iguais