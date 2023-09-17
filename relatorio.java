
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Candidato {
    public String nome;
    public String estado;
    public int idade;
    public String formacao;
    public int linguasProgramacao; 
    public int certificados;
    public int numEmpregosPrevios;

    Candidato(String nome, String estado, int idade, String formacao, 
            int linguasProgramacao, int certificados, int numEmpregosPrevios) 
    {
        System.out.println("não implementado!");
    }
}

class relatorio {

    public static void main(String[] args) {

        // ler arquivo dataset por linhas
        List<String> linhas = new ArrayList<String>();
        try {
            File arquivo = new File("dataset.csv");
            Scanner myReader = new Scanner(arquivo);

            // descartar primeira linha que apenas contem os nomes de cada coluna
            myReader.nextLine();

            while (myReader.hasNextLine())
            {
                // ler todas as linhas e adiocionar a lista
                String linha = myReader.nextLine();
                linhas.add(linha);
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("erro! arquivo não encontrado");
            e.printStackTrace();
        }

        // debug: exibir todas as linhas
        for (String linha : linhas) {
            System.out.println(linha);
        }
    }
}
