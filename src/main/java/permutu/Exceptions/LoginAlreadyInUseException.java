package permutu.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Podany login jest zajęty przez innego użytkownika")
public class LoginAlreadyInUseException extends RuntimeException {
}
