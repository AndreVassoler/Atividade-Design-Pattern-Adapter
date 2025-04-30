package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PessoaCsvAdapter implements RepositorioDePessoas {
    private String caminhoArquivo;

    public PessoaCsvAdapter(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    @Override
    public List<Pessoa> listarPessoas() {
        List<Pessoa> pessoas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Unicesumar\\IdeaProjects\\atividade01\\nomes.csv"))) {
            String linha;
            boolean primeiraLinha = true;

            while ((linha = br.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false; 
                    continue;
                }

                String[] campos = linha.split(",");
                if (campos.length == 3) {
                    String nome = campos[0].trim();
                    int idade = Integer.parseInt(campos[1].trim());
                    String email = campos[2].trim();

                    pessoas.add(new Pessoa(nome, idade, email));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return pessoas;
    }
}
