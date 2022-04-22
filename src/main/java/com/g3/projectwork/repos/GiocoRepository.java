package com.g3.projectwork.repos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.g3.projectwork.entities.Gioco;

// Questa è un interfaccia di tipo generico "generics"
// CrudRepository<T,ID> T richiede un oggetto (T where T = Gioco) e ID il tipo usato per l'ID
public interface GiocoRepository extends CrudRepository<Gioco, Long>{

}
