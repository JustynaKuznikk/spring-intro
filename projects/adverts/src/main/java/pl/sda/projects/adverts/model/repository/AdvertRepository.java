package pl.sda.projects.adverts.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.projects.adverts.model.domain.Advert;

import java.util.List;

public interface AdvertRepository extends JpaRepository<Advert, Long> {
    //metoda zwracającą listę ogłoszeń posortowanych po dacie dodania, malejąco
    List<Advert> findAllByOrderByPostedDesc();
}
