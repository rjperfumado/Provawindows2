package pilha;

import java.io.IOException;
import java.util.Stack;

public class Principal {

	public static void main(String[] args) throws IOException {
		new Principal().execute();
		
	}

	private void execute() throws IOException {

		Email email = new Email();
		
		CargaAluno cargaAluno = new CargaAluno();
		CargaFilme cargaFilme = new CargaFilme();
		CargaLivro cargaLivro = new CargaLivro();
		
		EscreveArquivo escreveArquivo = new EscreveArquivo();

		Stack<Aluno> pilhaAlunos = new Stack<Aluno>(); // pilha de alunos
		Stack<Filme> pilhaFilmes = new Stack<Filme>(); // pilha de filmes
		Stack<Livro> pilhalivros = new Stack<Livro>(); // pilha de livros
		
		

		pilhaAlunos = cargaAluno.lerArquivo();
		pilhaFilmes = cargaFilme.lerArquivo();
		pilhalivros = cargaLivro.lerArquivo();
				
		montarCorpoDoEmail(pilhaFilmes, pilhaAlunos,pilhalivros);

		email.enviarMensagem("javaicesp@gmail.com", "Alunos e Filmes", pilhaFilmes, pilhaAlunos,pilhalivros);//chama o m�todo de enviar e-mail
		escreveArquivo.escrever(pilhaFilmes, pilhaAlunos,pilhalivros, "novoArquivoGerado.txt", "Livros e Filmes"); //chama o m�todo de escrever o arquivo
	}

	public String montarCorpoDoEmail(Stack<Filme> filmes, Stack<Aluno> pilhaAlunos, Stack<Livro> pilhalivros) { //
		String resultado2 = "";
		String resultado1 = "";
		String identificacaoDoaluno = "";
		resultado1 = "Quantidade de filmes: " + filmes.size() + "\n" + "Media: " + filmes.pop().getMidia() + "\n"
				+ "---------------------------------------------------------------------------\n\n";
		for (int i = 0; i < filmes.size(); i++) {
			identificacaoDoaluno = "\nNome: " + pilhaAlunos.peek().getNome() + "\nCurso: "
					+ pilhaAlunos.peek().getCurso() + "\nMatricula: " + pilhaAlunos.peek().getMatricula();
			pilhaAlunos.pop();
			resultado2 += identificacaoDoaluno + "\nTitulo: " + filmes.peek().getTitulo() + "\nGenero: "
					+ filmes.peek().getGenero() + "\nMidia: " + filmes.peek().getMidia() + "\nValor: "
					+ filmes.peek().getValor() + "\nCodigo: " + filmes.peek().getCodigo() + "\nNumero interno: "
					+ filmes.peek().getNumeroInterno() + "\nData do pedido: " + filmes.peek().getDataPedido()
					+ "\n====================================================";
			filmes.pop();
		}
		return resultado1 + resultado2;
	}

}
