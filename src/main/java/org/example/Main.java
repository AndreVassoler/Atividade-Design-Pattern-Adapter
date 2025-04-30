package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String caminhoArquivo = "C:\\Users\\Unicesumar\\IdeaProjects\\atividade01\\pessoas.csv";

        RepositorioDePessoas repositorio = new PessoaCsvAdapter(caminhoArquivo);

        List<Pessoa> pessoas = repositorio.listarPessoas();

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
        }
    }
}
