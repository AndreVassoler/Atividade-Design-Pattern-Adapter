Alunos: André Fragalli Vassoler - 22012716-2
        Felipe Cesar Tomazoti de Souza - 22019977-2

# Projeto: Adapter Pattern com Arquivo CSV

Este projeto demonstra como aplicar o padrão de projeto **Adapter** para adaptar um sistema legado que armazena dados em arquivos `.csv` a um sistema novo baseado em objetos Java.

---

## ✨ Objetivo

Integrar um arquivo `.csv` de pessoas ao novo sistema orientado a objetos, sem modificar o código principal. Para isso, foi criado um **adapter** que converte os dados do CSV para objetos da classe `Pessoa`, utilizando uma interface comum chamada `RepositorioDePessoas`.

---

## 📦 Estrutura de Classes

### 1. Classe `Pessoa`

```java
public class Pessoa {
    private String nome;
    private int idade;
    private String email;

    public Pessoa(String nome, int idade, String email) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return nome + " (" + idade + " anos) - " + email;
    }
}
```

---

### 2. Interface `RepositorioDePessoas`

```java
import java.util.List;

public interface RepositorioDePessoas {
    List<Pessoa> listarPessoas();
}
```

---

### 3. Classe `PessoaCsvAdapter`

```java
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
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
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
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return pessoas;
    }
}
```

---

### 4. Classe `TestePessoaAdapter`

```java
import java.util.List;

public class TestePessoaAdapter {
    public static void main(String[] args) {
        String caminhoCsv = "pessoas.csv"; 

        RepositorioDePessoas repositorio = new PessoaCsvAdapter(caminhoCsv);
        List<Pessoa> pessoas = repositorio.listarPessoas();

        System.out.println("Lista de pessoas:");
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
        }
    }
}
```

---

## 📄 Exemplo de Arquivo `pessoas.csv`

```csv
nome, idade, email
Ana Silva, 29, ana.silva@email.com
João Santos, 34, joao.santos@email.com
Marina Souza, 41, marina.souza@email.com
```




