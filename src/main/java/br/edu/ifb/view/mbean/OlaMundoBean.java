package br.edu.ifb.view.mbean;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class OlaMundoBean {
	public String getHorario() {
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		return "Atualizado em " + sdf.format(new Date());
	}
}
