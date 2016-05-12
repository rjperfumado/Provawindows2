package pilha;

import java.util.Properties;
import java.util.Stack;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

	public void enviarMensagem(String para, String assunto, Stack<Filme> pilhaFilmes, Stack<Aluno> pilhaAlunos,Stack<Livro> pilhaLivro) {
		
		Session session = conectarEmail();
		Principal metodo = new Principal();
		String corpo = metodo.montarCorpoDoEmail(pilhaFilmes, pilhaAlunos,pilhaLivro);
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("javaicesp@gmail.com")); // aqui
																			// �
																			// o
																			// email
																			// configurado.
																			// Crie
																			// uma
																			// conta
																			// para
																			// vc
																			// no
																			// gmail.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(para));
			message.setSubject(assunto);
			message.setText(corpo);
			Transport.send(message);
			System.out.println("Mensagem enviada");
			
		} catch (MessagingException e) {
			
			throw new RuntimeException(e);
		}
	}

	private Session conectarEmail() {
		final String username = "icespjava@gmail.com"; // insira o login da// conta de email
		final String password = "java12345678"; // insira a senha da conta de
												// e-mail

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		return session;
	}
}