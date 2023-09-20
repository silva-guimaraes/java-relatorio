
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
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
        this.nome = nome;
        this.estado = estado;
        this.idade = idade;
        this.formacao = formacao;
        this.linguasProgramacao = linguasProgramacao;
        this.certificados = certificados;
        this.numEmpregosPrevios = numEmpregosPrevios;
    }

    public String toString() {
        return "nome: " + this.nome + ", idade: " + this.idade + ", estado: " + this.estado + ", formacao: " + this.formacao;
    }
}

class relatorio {

    public static void main(String[] args) {

        // ler arquivo dataset por linhas
        List<String> linhas = new ArrayList<String>();
        try {
            File file = new File("dataset.csv");
            FileReader filereader = new FileReader(file);
            BufferedReader br = new BufferedReader(filereader);
            String line;

            while ((line = br.readLine()) != null) {
                linhas.add(line);
                System.out.println(line);
            }


        } catch (Exception e) {
            System.out.println("erro! arquivo não encontrado");
            e.printStackTrace();
        }

        System.out.println(linhas.size());

        List<Candidato> candidatos = new ArrayList<Candidato>();

        for (int i = 1; i < linhas.size(); i++) {
            String linha = linhas.get(i);
            String[] colunas = linha.split(",");
            // nome,estado,idade,formacao,linguas_programacao,certificados,empregos
            String nome = colunas[0];
            String estado = colunas[1];
            int idade = Integer.parseInt(colunas[2]);
            String formacao = colunas[3];
            int linguasProgramacao = Integer.parseInt(colunas[4]);
            int certificados = Integer.parseInt(colunas[5]);
            int numEmpregosPrevios = Integer.parseInt(colunas[6]);

            Candidato candidato = new Candidato(
                    nome, estado, idade, formacao, linguasProgramacao, certificados, 
                    numEmpregosPrevios);

            candidatos.add(candidato);
        }

        for (var i : candidatos) 
            System.out.println(i);

    }
}
