
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Candidato {
    public int id;
    public String nome;
    public String estado;
    public int idade;
    public String formacao;
    public int linguasProgramacao; 
    public int certificados;
    public int numEmpregosPrevios;

    Candidato(int id, String nome, String estado, int idade, String formacao, 
            int linguasProgramacao, int certificados, int numEmpregosPrevios) 
    {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
        this.idade = idade;
        this.formacao = formacao;
        this.linguasProgramacao = linguasProgramacao;
        this.certificados = certificados;
        this.numEmpregosPrevios = numEmpregosPrevios;
    }

    public String toString() {
        return "(id: " + this.id + ") " + "nome: " + this.nome + ", idade: " + 
            this.idade + ", estado: " + this.estado + ", formacao: " + this.formacao;
    }

    public boolean sudeste()  {
        if(this.estado.equals("Rio de Janeiro")) {
            return true;
        }
        else if (this.estado.equals("São Paulo")) {
            return true;    
        }  
        else if (this.estado.equals("Minas Gerais")) {
            return true;    
        }
        else if(this.estado.equals("Espírito Santo")){
            return true;    
        }
        else{
            return false;    
        }
    }

    // retorna true se o cadidato possuir ensino superior concluido ou 
    // um curso profissionalizante. candidatos com mestrado ou doutorado são
    // qualificados demais para essa empresa
    public boolean qualificado()  {
        if(this.formacao.equals("ensino superior")) {
            return true;
        }
        if(this.formacao.equals("curso profissionalizante")) {
            return true;
        }
        else{
            return false;    
        }
    }

}

class relatorio {

    public static void main(String[] args) {

        // ler arquivo dataset.csv por linhas e salvar nesta array
        List<String> linhas = new ArrayList<String>();
        try {
            File file = new File("dataset.csv");
            FileReader filereader = new FileReader(file);
            BufferedReader br = new BufferedReader(filereader);
            String line;

            while ((line = br.readLine()) != null) {
                linhas.add(line);
            }


        } catch (Exception e) {
            System.out.println("erro! arquivo não encontrado");
            e.printStackTrace();
        }

        List<Candidato> candidatos = new ArrayList<Candidato>();

        // separar cada linha por colunas e salvar todos os candidatos em uma lista
        for (int i = 1; i < linhas.size(); i++)
        {
            String linha = linhas.get(i);
            // separa linha pelas virgulas
            String[] colunas = linha.split(",");

            // o layout das colunas é este:
            // id,nome,estado,idade,formacao,linguas_programacao,certificados,empregos
            // dentre estas, apenas "nome", "estado" e "formacao" deverão continuar
            // sendo strings. todas as outras precisam ser transformadas em int
            int id = Integer.parseInt(colunas[0]);
            String nome = colunas[1];
            String estado = colunas[2];
            int idade = Integer.parseInt(colunas[3]);
            String formacao = colunas[4];
            int linguasProgramacao = Integer.parseInt(colunas[5]);
            int certificados = Integer.parseInt(colunas[6]);
            int numEmpregosPrevios = Integer.parseInt(colunas[7]);

            // criar objeto candidato
            Candidato candidato = new Candidato(
                    id, nome, estado, idade, formacao, linguasProgramacao, certificados, 
                    numEmpregosPrevios);

            // salvar candidato
            candidatos.add(candidato);
        }

        /* Filtragem de Dados */
        for (int contador = 0; contador < candidatos.size(); contador++)
        {
            Candidato candidato = candidatos.get(contador);
            // remover candidatos não muito jovens
            if (candidato.idade > 27)
            {
                candidatos.remove(contador);
                contador--;
            } 
            // remover candidatos fora da região sudeste
            else if (!candidato.sudeste())
            {
                candidatos.remove(contador);
                contador--;
            }
            // remover candidatos que não tenham as qualificações corretas
            else if (!candidato.qualificado())
            {
                candidatos.remove(contador);
                contador--;
            }
        }

        System.out.println("A quantidade de candidatos são " + candidatos.size() + ",");
        System.out.println("Os candidatos que se adequam seguem:");
        for (var i : candidatos) {
            System.out.println(i);
        }
    }
}

