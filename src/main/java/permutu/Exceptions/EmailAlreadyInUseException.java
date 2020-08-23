package permutu.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Podany adres email jest już przypisany do innego konta")
public class EmailAlreadyInUseException extends RuntimeException {
}
