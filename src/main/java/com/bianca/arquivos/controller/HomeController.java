package com.bianca.arquivos.controller;

import com.bianca.arquivos.entity.RecomendacoesEntity;
import com.bianca.arquivos.repository.RecomendacoesRepository;
import com.bianca.arquivos.service.RecomendacoesService;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/")
public class HomeController {

  @Autowired
  private final RecomendacoesRepository repository;
  private RecomendacoesService recomendacoesService;

  @Autowired
  public HomeController(RecomendacoesService recomendacoesService, RecomendacoesRepository recomendacoesRepository){
    this.recomendacoesService = recomendacoesService;
    this.repository = recomendacoesRepository;
  }

  @CrossOrigin
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

  for(int i = 1; i < lines.size(); i++) {
    recs.add(new RecomendacoesEntity(
            lines.get(i)[0],
            lines.get(i)[1],
            lines.get(i)[2],
            lines.get(i)[3],
            lines.get(i)[4],
            repository.GetUser(id)
    ));
  }

    repository.saveAll(recs); //salvando os vetores acima
  }

  @CrossOrigin
  @GetMapping("/message/{id}")
  public void exporta(@PathVariable int id, HttpServletResponse response) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
     //set file name and content type
     String filename = "Recomendacoes.csv";

     response.setContentType("text/csv");
     response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
             "attachment; filename=\"" + filename + "\"");

     //create a csv writer
     StatefulBeanToCsv<RecomendacoesEntity> writer = new StatefulBeanToCsvBuilder<RecomendacoesEntity>(response.getWriter())
             .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
             .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
             .withOrderedResults(false)
             .build();

     //write all users to csv file
     writer.write(recomendacoesService.listaRecomendacoes(id));
  }

}
