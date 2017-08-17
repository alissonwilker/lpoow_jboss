package br.org.libros.view.utils;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;

public class FacesMessageUtils {

	public static void addInfoFacesMessage(String key, Object... parameters) {
		FacesMessage facesMessage = getInfoFacesMessage(key, parameters);
		JsfUtils.getFacesContext().addMessage(null, facesMessage);
	}

	public static FacesMessage getInfoFacesMessage(String key, Object... parameters) {
		String message = getMsgResourceBundle().getString(key);
		String formattedMessage = MessageFormat.format(message, parameters);
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, formattedMessage, formattedMessage);
		return facesMessage;
	}

	private static ResourceBundle getMsgResourceBundle() {
		return JsfUtils.getResourceBundle("msg");
	}
}
