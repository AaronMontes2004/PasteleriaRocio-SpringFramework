package proyecto.grupo07.idat.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import proyecto.grupo07.idat.controlador.dto.MailRequest;
import proyecto.grupo07.idat.controlador.dto.MallResponse;

@Service
public class EmailServiceFactura {
	
	@Autowired
	private JavaMailSender sender;
	
	@Autowired
	private Configuration config;
	
	public ModelAndView sendEmail(MailRequest request, Map<String, Object> model) {
		ModelAndView modelAndView = new ModelAndView("redirect:/Cliente/ConsultaDeClientes");
		MallResponse response = new MallResponse();
		MimeMessage message = sender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message,MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());
			helper.addAttachment("logo.png", new ClassPathResource("logo.png"));
			
			Template t = config.getTemplate("email-template.ftl");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
			
			//request.setTo("montesaaron2018@gmail.com");
			request.setFrom("bot214721@gmail.com");
			//request.setSubject("Factura ps xD");
			
			helper.setTo(request.getTo());
			helper.setText(html,true);
			helper.setSubject(request.getSubject());
			helper.setFrom(request.getFrom());
			sender.send(message);
			
			response.setMessage("mail send to : "+request.getTo());
			response.setStatus(Boolean.TRUE);
		}
		
		catch (MessagingException | IOException | TemplateException e) {
			response.setMessage("Mail Sending failure : "+e.getMessage());
			response.setStatus(Boolean.FALSE);
		}
		
		return modelAndView;
	}
}
