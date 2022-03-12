package uz.pdp.page.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.page.entity.Hotel;
import uz.pdp.page.entity.Room;

public interface HotelRepository extends JpaRepository<Hotel,Integer> {

}
