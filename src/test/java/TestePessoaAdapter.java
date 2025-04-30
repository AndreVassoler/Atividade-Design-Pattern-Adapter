import org.example.Pessoa;
import org.example.PessoaCsvAdapter;
import org.example.RepositorioDePessoas;

import java.util.List;

public class TestePessoaAdapter {
    public static void main(String[] args) {
        String caminhoCsv = "C:\\Users\\Unicesumar\\IdeaProjects\\atividade01\\pessoas.csv"; // Certifique-se de que esse arquivo exista no diretório do projeto

        RepositorioDePessoas repositorio = new PessoaCsvAdapter(caminhoCsv);

        List<Pessoa> pessoas = repositorio.listarPessoas();

        System.out.println("Lista de pessoas:");
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
        }
    }
}
