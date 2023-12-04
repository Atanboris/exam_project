package atanas.ba.exam_project.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class StringDateIsInPresentOrFutureValidator implements ConstraintValidator<StringDateIsInPresentOrFuture, String> {

    @Override
    public void initialize(StringDateIsInPresentOrFuture constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s.isBlank()) {
            return false;
        }
        LocalDate date = LocalDate.parse(s);
        if(date.isBefore(LocalDate.now())){
            return false;
        };
        return true;
    }
}
