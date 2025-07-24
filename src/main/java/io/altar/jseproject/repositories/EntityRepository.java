package io.altar.jseproject.repositories;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import io.altar.jseproject.model.myEntity;

public abstract class EntityRepository<T extends myEntity> { // classe abstrata genérica. Funciona como um repositório
																// (ou base de dados) para qualquer tipo de entidade
																// desde q herde de MyEntity

	private Map<Long, T> db = new HashMap<>(); // base de dados em memória
	private long currentId = 0; // gera ids automáticos

// gera o proximo id
	private long getNextId() {
		return ++currentId;
	}

// cria entidade
	public long create(T entity) {
		Long newId = getNextId(); //gera novo id
		entity.setId(newId);//exemplo: eu crio o obj sem id no construtor e depois o repositorio chama setId(...) para atribuir um id ao obj
		db.put(newId, entity); //guarda o obj na bd 
		return newId; //retorna o id criado
	}

// Consultar por ID
	public T getById(Long id) { //recebe o id
		return db.get(id); //retorna a entidade correspondente
	}

	//obtem todos os registos
	public List<T> getAll() {
		return new ArrayList<>(db.values()); //retorna uma lista de obj guardados. db.values devolve todos os valores do map (produtos/prateleiras) e transforma em arraylist
	}


// Editar entidade
	public void edit(T entity) { 
		db.put(entity.getId(), entity); //substitui uma enteidade q ja existe no map c base no seu id (caso eu queira alterar nome, valor, etc)
	}

// Remover por ID
	public void remove(Long id) {
		db.remove(id); //elimina a entidade c o id fornecido
	}
}

//TODO ver collections