package pacote;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Func {

    // 1. Função para escrever em um arquivo
    public static void escreverArquivo(String caminho, String conteudo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho, false))) {
            bw.write(conteudo);
            System.out.println("Arquivo gravado com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    // 2. Função para ler o conteúdo de um arquivo
    public static String lerArquivo(String caminho) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                sb.append(linha).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String arquivo = "exemplo.txt";

        // Testando a função de escrita
        escreverArquivo(arquivo, "Olá, este éasudashduhasudhas!");

        // Testando a função de leitura
        String textoLido = lerArquivo(arquivo);
        System.out.println("\nConteúdo lido do arquivo:\n" + textoLido);
    }
}