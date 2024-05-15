package com.riwi.beautySalon.infraestructure.helpers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class EmailHelper {
    //Iyectar el servicio de email la libreria
    private final JavaMailSender mailSender;


    public void sendMail(String destinity, String nameClient, String nameEmployee, LocalDateTime date){
        MimeMessage message = mailSender.createMimeMessage();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String dateAppointment = date.format(formatter);
        String htmlContent = this.readHTMLTemplate(nameClient, nameEmployee, dateAppointment);

        try {
            message.setFrom(new InternetAddress("kwmejia9@gmail.com"));
            message.setSubject("Confirmación de cita en Beauty Salon");

            message.setRecipients(MimeMessage.RecipientType.TO,destinity);
            message.setContent(htmlContent,MediaType.TEXT_HTML_VALUE);

            mailSender.send(message);
            System.out.println("Email enviado");

        } catch (Exception e) {
            System.out.println("ERROR no se pudo enviar el email " + e.getMessage());

        }
    }


    private String readHTMLTemplate(String nameClient, String nameEmployee, String date){
        //Indicar en donde se encuentra el template
        final Path path = Paths.get("src/main/resources/emails/email_template.html");

        try (var lines = Files.lines(path)){
            var html = lines.collect(Collectors.joining());

            return html.replace("{name}", nameClient).replace("{employee}", nameEmployee).replace("{date}", date);
        } catch (IOException e) {
            System.out.println("No se pudo leer el html");
            throw new RuntimeException();
        }
    }
}
