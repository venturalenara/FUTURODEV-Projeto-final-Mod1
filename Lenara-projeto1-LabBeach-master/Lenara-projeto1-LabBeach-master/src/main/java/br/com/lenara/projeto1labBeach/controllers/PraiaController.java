package br.com.lenara.projeto1labBeach.controllers;

import br.com.lenara.projeto1labBeach.models.Praia;
import br.com.lenara.projeto1labBeach.services.PraiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/praias")
public class PraiaController {

    @Autowired
    private PraiaService praiaService;

    @GetMapping // Listagem de praias:
    public ResponseEntity<List<Praia>> findAll(){
        // verifica se a comunicação está ok e busca e lista todos as praias
        return ResponseEntity.status(HttpStatus.OK).body(praiaService.findAll());
    }

    @PostMapping(value = "/post") //Cadastro de praia
    public Long save(@RequestParam("name") String name,
                     @RequestParam("acessibilidade") Boolean acessibilidade,
                     @RequestParam("status") String status,
                    @RequestParam("bairroId") Long bairroId){
    return ResponseEntity.ok().body(praiaService.save(name,acessibilidade,status,bairroId)).getBody();
    }


    @PutMapping("/{id}") //Edição de praias por identificador
    ResponseEntity<Praia> update(@RequestBody Praia praia){
        return ResponseEntity.status(HttpStatus.OK).body(praiaService.update(praia));
    }

    @DeleteMapping("/{id}") //Exclusão de um praias por identificador
    public ResponseEntity<?> delete(@PathVariable Long id){
        praiaService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // Listar praias conforme o status (própria ou imprópria)
    @GetMapping(value = "status")
    public List<Praia> findByStatus(@RequestParam("status") String status){
        List<Praia> praias = praiaService.findByStatus(status);
        return ResponseEntity.ok().body(praias).getBody();
    }

    // Listagem de praias com acessibilidade
    @GetMapping(value = "acessibilidade")
    public List<Praia> findByAcessibilidade(@RequestParam("acessibilidade") Boolean acessibilidade){
        List<Praia> praias = praiaService.findByAcessibilidade(acessibilidade);
        return ResponseEntity.ok().body(praias).getBody();
    }

    //Listagens de praias por população no bairro
    @GetMapping(value = "populacao")
    public List<Praia> findByPopulation(@RequestParam("population") Integer population){
        List<Praia> praias = praiaService.findByPopulation(population);
        return ResponseEntity.ok().body(praias).getBody();
    }

}
