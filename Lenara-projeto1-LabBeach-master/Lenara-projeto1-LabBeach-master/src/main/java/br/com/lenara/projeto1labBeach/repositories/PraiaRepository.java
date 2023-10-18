package br.com.lenara.projeto1labBeach.repositories;

import br.com.lenara.projeto1labBeach.models.Bairro;
import br.com.lenara.projeto1labBeach.models.Praia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PraiaRepository extends JpaRepository<Praia, Long> {

    // Listar praias conforme o status (própria ou imprópria)
    public List<Praia> findByStatus(String status); // Listagem de praias conforme o status

    //Listar praias por acessibilidade ( verdadeiro ou falso )
    public  List<Praia> findByAcessibilidade (Boolean acessibilidade); // Listagem de praias com acessibilidade

    // Listagens de praias por população no bairro CRIAR

    @Query ("select p from Praia p left join Bairro b on ( p.bairro = b ) where b.population <= :num")
    public List<Praia> findByPopulation(@Param("num") Integer population);
}
