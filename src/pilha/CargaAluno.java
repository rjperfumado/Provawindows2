package pilha;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class CargaAluno {
	
	public Stack<Aluno> lerArquivo() throws IOException{  
		
		Stack<Aluno> pilha = new Stack<Aluno>();
		Stack<String> pilhaString = new Stack<String>();
		
    	//File file = new File("/root/Programacao/workspace/TrabalhoProva/nomes.txt");  // aqui deve ser mudado para o diret�rio do seu computador.
    	File file = new File("C:\\Users\\c1217635\\workspace\\TrabalhoProva\\nomes.txt");
    	FileReader fileReader = new FileReader(file);  
        BufferedReader reader = new BufferedReader(fileReader);  
        
        
        String data = null;  
        long inicio = System.currentTimeMillis();
        
        while((data = reader.readLine()) != null){  
        	
        	   pilha.push(desmembrarString(data));
        }  
        
        long fim = System.currentTimeMillis();
        
        System.out.println((fim - inicio)/1000 + " Segundos");
        fileReader.close();  
        reader.close(); 
        return pilha;
    }  
	
	
	private Aluno desmembrarString(String dados) {
		Aluno aluno = null;
		StringTokenizer st = new StringTokenizer(dados, ";");
		while (st.hasMoreTokens()) {
			/* System.out.println(" Linha Bruta " + dados); */
			aluno = new Aluno();
			aluno.setColocacao(Integer.parseInt(st.nextToken()));
			aluno.setMatricula(st.nextToken());
			aluno.setNome(st.nextToken());
			aluno.setCurso(st.nextToken());
		}
		return aluno;
	}
}
