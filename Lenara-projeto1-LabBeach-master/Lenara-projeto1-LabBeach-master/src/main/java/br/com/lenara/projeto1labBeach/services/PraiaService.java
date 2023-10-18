package br.com.lenara.projeto1labBeach.services;

import br.com.lenara.projeto1labBeach.models.Bairro;
import br.com.lenara.projeto1labBeach.models.Praia;
import br.com.lenara.projeto1labBeach.repositories.PraiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PraiaService {

    @Autowired
    private PraiaRepository praiaRepository;
    @Autowired
    private BairroService bairroService;
    //classe de serviço que vai executar os métodos da controller

    public List<Praia> findAll(){return praiaRepository.findAll();} // lista todas as praias

//    public Long save ( String name,
//                      Boolean acessibilidade,
//                      String status){
//        Praia praia = new Praia();
//        praia.setName(name);
//        praia.setAcessibilidade(acessibilidade);
//        praia.setStatus(status);
//        return praiaRepository.save(praia).getId();
//    } // método save somente dos atributos praia

    //método save sem a validação da string
    public Long save (String name,
                      Boolean acessibilidade,
                      String status,
                      Long bairroId){
        Praia praia = new Praia();
        Bairro bairro = bairroService.findByID(bairroId);
        praia.setName(name);
        praia.setAcessibilidade(acessibilidade);
        praia.setStatus(status);
        praia.setBairro(bairro);
        return praiaRepository.save(praia).getId();
    } // método save para fazer o cadastro via query, por campoe com id bairro


    // método alterar
    public Praia update (Praia praia) {
        return praiaRepository.save(praia);
    }

    // método deletar por ID
    public void deleteById(Long id) { praiaRepository.deleteById(id);}

    // método Listar praias conforme o status (própria ou imprópria)
    public List<Praia> findByStatus(String status){
        return praiaRepository.findByStatus(status);
    }
    // método Listar praias por acessibilidade ( verdadeiro ou falso )
    public List<Praia> findByAcessibilidade(Boolean acessibilidade){
        return praiaRepository.findByAcessibilidade(acessibilidade);
    }
    // método Listagens de praias por população no bairro
    public List<Praia> findByPopulation(Integer population){
        return praiaRepository.findByPopulation(population);
    }

}
