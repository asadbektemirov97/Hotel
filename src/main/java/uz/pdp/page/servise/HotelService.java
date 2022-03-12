package uz.pdp.page.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.page.entity.Hotel;
import uz.pdp.page.repository.HotelRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {
    @Autowired
    HotelRepository hotelRepository;
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    public String add(Hotel hotel) {
        Hotel hotel1 = new Hotel();
        hotel1.setName(hotel.getName());
        hotelRepository.save(hotel1);
        return "saved";
    }

    public String edit(Integer id, Hotel hotel) {
        Optional<Hotel> hotels = hotelRepository.findById(id);
        if (hotels.isPresent()){
            hotels.get().setName(hotel.getName());
            hotelRepository.save(hotels.get());
            return "Edited";
        }
        return "Not found";
    }

    public String del(Integer id) {
        Optional<Hotel> byId = hotelRepository.findById(id);
        if (byId.isPresent()){
            hotelRepository.delete(byId.get());
            return "deleted";
        }
        return "Not found";
    }
}
