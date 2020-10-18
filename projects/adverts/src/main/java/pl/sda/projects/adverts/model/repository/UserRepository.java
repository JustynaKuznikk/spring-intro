package pl.sda.projects.adverts.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.projects.adverts.model.domain.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUsername(String username);
    User getByUsername(String username);

//zapis do bazy, odczyt z bazy nam umożliwia

    //sprawdzenie czy użytkownik istnieje już w bazie:
    //boolean existByUsername(String username);



}
