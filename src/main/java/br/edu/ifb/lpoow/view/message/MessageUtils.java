package br.edu.ifb.lpoow.view.message;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;

import br.edu.ifb.lpoow.view.jsf.JsfUtils;

public class MessageUtils {

	public static void addInfoFacesMessage(String key, Object... parameters) {
		FacesMessage facesMessage = getInfoFacesMessage(key, parameters);
		JsfUtils.getFacesContext().addMessage(null, facesMessage);
	}

	public static FacesMessage getInfoFacesMessage(String key, Object... parameters) {
		String message = getResourceBundle().getString(key);
		String formattedMessage = MessageFormat.format(message, parameters);
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, formattedMessage, formattedMessage);
		return facesMessage;
	}

	private static ResourceBundle getResourceBundle() {
		return JsfUtils.getResourceBundle("msg");
	}
}
