package br.org.libros.view.validator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import br.org.libros.view.utils.FacesMessageUtils;

@FacesValidator(value = "isbnValidator")
public class IsbnValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		if (value == null) {
			return;
		}

		String isbn = (String) value;

		if (isbn.length() != 13 || (!isbn.startsWith("978") && !isbn.startsWith("979"))
				|| !calcularDigitoVerificador(isbn.substring(0, 12)).equals(isbn.substring(12, 13))) {
			throw new ValidatorException(FacesMessageUtils.getInfoFacesMessage("livros.isbnValidator"));
		}
	}

	private String calcularDigitoVerificador(String num) {
		Integer digitoVerificador;
		int soma = 0;
		for (int i = 0; i < num.length(); i += 2) {
			soma += Integer.parseInt(num.substring(i, i + 1)) + Integer.parseInt(num.substring(i + 1, i + 2)) * 3;
		}
		digitoVerificador = (10 - soma % 10) % 10;
		return String.valueOf(digitoVerificador);
	}

}