package io.altar.jseproject.repositories.interfaces;

import java.util.List;
import io.altar.jseproject.model.Shelf;

//uma interface nao implementa métodos, apenas declara
public interface ShelfInterface {  //qualquer classe que implemente esta classe tem de ter estes métodos:
	
    long create(Shelf entity);
    Shelf getById(Long id);
    List<Shelf> getAll();
    void edit(Shelf entity);
    void remove(Long id);
}
