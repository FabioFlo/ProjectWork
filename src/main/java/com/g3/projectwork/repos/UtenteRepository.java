package com.g3.projectwork.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.g3.projectwork.entities.Utente;

//Questa è un interfaccia di tipo generico "generics"
//CrudRepository<T,ID> T richiede un oggetto (T where T = Utente) e ID il tipo usato per l'ID
public interface UtenteRepository extends JpaRepository<Utente, Long>{

}