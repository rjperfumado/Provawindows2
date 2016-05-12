package pilha;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.ArrayList;

public class EscreveArquivo {
   
	
   public void escrever(Stack<Filme> filmes, Stack<Aluno> pilhaAlunos,  Stack<Livro> pilhaLivros,String nomeArquivo, String descricao) {
    	
        File dir = new File("/root/Programacao/workspace/TrabalhoProva/saida"); // aqui ser� o diret�rio onde a aplica��o ir� escrever o arquivo texto. Desta forma voc� deve mudar para o seu diret�rio.
        File arq = new File(dir, nomeArquivo);

        try {
            arq.createNewFile();
            FileWriter fileWriter = new FileWriter(arq, false);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            formatarFilmes(filmes, pilhaAlunos, pilhaLivros,printWriter, descricao);
            printWriter.flush();
            printWriter.close();
            System.out.println("Arquivo gerado");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

	private void formatarFilmes(Stack<Filme> filmes, Stack<Aluno> pilhaAlunos, Stack<Livro> pilhaLivros,PrintWriter printWriter,
			String descricao) {
		printWriter.println("--------------------------------------------------------------------------------------");
		printWriter.println("                                " + descricao + "                                     ");
		printWriter.println("--------------------------------------------------------------------------------------");
		for (Filme filme : filmes) {
			printWriter.println("Nome: " + pilhaAlunos.peek().getNome());
			printWriter.println("Curso: " + pilhaAlunos.peek().getCurso());
			printWriter.println("Matricula: " + pilhaAlunos.peek().getMatricula());
			printWriter.println("Colocacao: " + pilhaAlunos.peek().getColocacao());
			printWriter.println("----------------------------------------------------------------------------------");
			printWriter.println("Titulo: " + filme.getTitulo());
			printWriter.println("Genero: " + filme.getGenero());
			printWriter.println("Midia: " + filme.getMidia());
			printWriter.println("Valor: " + filme.getValor());
			printWriter.println("Codigo: " + filme.getCodigo());
			printWriter.println("Numero interno: " + filme.getNumeroInterno());
			printWriter.println("Data do pedido: " + filme.getDataPedido());
			printWriter.println("=======================================================================================");
		}
}
}