package gr.aueb.cf.springteacher5.validator;

import gr.aueb.cf.springteacher5.dto.TeacherInsertDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.executable.ExecutableValidator;
import jakarta.validation.metadata.BeanDescriptor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Set;
@Component
public class TeacherInsertValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return TeacherInsertDTO.class == clazz;
    }

    @Override
    public void validate(Object target, Errors errors) {
        TeacherInsertDTO teacherInsertDTO = (TeacherInsertDTO) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "empty");
        if (teacherInsertDTO.getFirstname().length() < 3 || teacherInsertDTO.getFirstname().length() > 50) {
            errors.reject("firstname", "size");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "empty");
        if (teacherInsertDTO.getLastname().length() < 3 || teacherInsertDTO.getLastname().length() > 50) {
            errors.reject("lastname", "size");
        }
        // if (teacherService.isUsernameExists(teacherInsertDTO.getUsername())
        // errors.reject("username", "exists")
    }
}
