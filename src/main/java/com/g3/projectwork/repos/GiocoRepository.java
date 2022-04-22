package com.g3.projectwork.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.g3.projectwork.entities.Gioco;

// Questa è un interfaccia di tipo generico "generics"
// CrudRepository<T,ID> T richiede un oggetto (T where T = Gioco) e ID il tipo usato per l'ID
public interface GiocoRepository extends JpaRepository<Gioco, Long>{

}
