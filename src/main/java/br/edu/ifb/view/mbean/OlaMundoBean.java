package br.edu.ifb.view.mbean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class OlaMundoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public String getHorario() {
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		return "Atualizado em: " + sdf.format(new Date());
	}
}
