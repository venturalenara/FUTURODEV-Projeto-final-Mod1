package br.com.lenara.projeto1labBeach.services;

import br.com.lenara.projeto1labBeach.models.Bairro;
import br.com.lenara.projeto1labBeach.repositories.BairroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BairroService {

    @Autowired
    private BairroRepository bairroRepository;

    //classe de serviço que vai executar os métodos da controller

    public Long save (String name,
                      String description,
                      Integer population){
        Bairro bairro = new Bairro();
        bairro.setName(name);
        bairro.setDescription(description);
        bairro.setPopulation(population);
        return bairroRepository.save(bairro).getId();
    } // método save para fazer o cadastro via query, por campo

   public Bairro saveAll (Bairro bairro) { return bairroRepository.save(bairro);} // método salvar via JSON
    public Bairro findByID(Long id){
        Optional<Bairro> bairros = bairroRepository.findById(id);
        return (bairros.isPresent() ? bairros.get() : null);
    }

     public List<Bairro> findAll() {return bairroRepository.findAll();} // lista todos
    public void deleteById(Long id) { bairroRepository.deleteById(id);}

}
