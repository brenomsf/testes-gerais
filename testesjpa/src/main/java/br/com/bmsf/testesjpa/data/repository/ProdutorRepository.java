package br.com.bmsf.testesjpa.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bmsf.testesjpa.data.entity.Distribuidor;
import br.com.bmsf.testesjpa.data.entity.Produtor;

@Repository
public interface ProdutorRepository extends JpaRepository<Produtor, String> {

}
