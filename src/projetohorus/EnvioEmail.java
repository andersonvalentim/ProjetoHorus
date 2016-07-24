/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetohorus;

/**
 *
 * @author Vectro26
 */
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class EnvioEmail {

    public void EnvioEmail() throws EmailException {
        EmailAttachment anexo1 = new EmailAttachment();
        anexo1.setPath("tesfinal11.pdf"); //caminho do arquivo (RAIZ_PROJETO/teste/teste.txt)
        anexo1.setDisposition(EmailAttachment.ATTACHMENT);
        anexo1.setDescription("PDF");
        anexo1.setName("ProjetoHorus.pdf");

        MultiPartEmail emails = new MultiPartEmail();
        emails.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail
        emails.addTo("", "Anderson"); //destinatário
        emails.setFrom("projecthorusifrn@gmail.com", "Projeto");
        emails.setSubject("Teste -> Email com anexo");
        emails.setMsg("conteudo");
        emails.setAuthentication("email", "senha");
        emails.setSmtpPort(465);
        emails.setSSL(true);
        emails.setTLS(true);
        emails.attach(anexo1);
        emails.send();

    }

}
