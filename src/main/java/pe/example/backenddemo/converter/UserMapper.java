package pe.example.backenddemo.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import pe.example.backenddemo.controller.dto.UserRequest;
import pe.example.backenddemo.service.model.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface UserMapper {


    @Mapping(source = "birthday", target = "birthday", qualifiedByName = "parseBirthday")
    User fromDtoToModel(UserRequest userRequest);

    @Named(value = "parseBirthday")
    static LocalDate parseBirthday(String birthday) {
        if (birthday == null) {
            return null;
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(birthday, dtf);
    }
}
