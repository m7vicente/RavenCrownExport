package com.bianca.arquivos.controller;

import com.bianca.arquivos.entity.RecomendacoesEntity;
import com.bianca.arquivos.repository.RecomendacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class HomeController {

  private final RecomendacoesRepository repository;

  @Autowired
  public HomeController(final RecomendacoesRepository repository) {
    this.repository = repository;
  }

  @PostMapping
  public void importa(@RequestParam MultipartFile file, @RequestParam int id){
    ArrayList<String[]> lines = new ArrayList<>(); // list

    try {
      Scanner leitor = new Scanner(file.getInputStream());
      while (leitor.hasNext()) {
        String line = leitor.nextLine();
        String[] cols = line.split(";");
        lines.add(cols);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    ArrayList<RecomendacoesEntity> recs = new ArrayList<>(); //Objeto do banco (redomendaçoes)

    lines.forEach(elem -> {
      recs.add(new RecomendacoesEntity(
          elem[0],
          elem[1],
          elem[2],
          elem[3],
          elem[4],
          repository.GetUser(id)
      ));
    });

    repository.saveAll(recs); //salvando os vetores acima


  }

  @GetMapping(produces = "text/csv")
  public List<RecomendacoesEntity> exporta(@RequestParam final int id) {
    return  repository.findByUsuarioId(id);

  }
}
