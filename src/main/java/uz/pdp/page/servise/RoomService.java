package uz.pdp.page.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.pdp.page.dto.RoomDto;
import uz.pdp.page.entity.Hotel;
import uz.pdp.page.entity.Room;
import uz.pdp.page.repository.HotelRepository;
import uz.pdp.page.repository.RoomRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    HotelRepository hotelRepository;
    public List<Room> getAll() {
        return roomRepository.findAll();
    }

    public String add(RoomDto room1) {
        Hotel hotel = hotelRepository.findById(room1.getHotelId()).get();
        Room room = new Room();
        room.setHotel(hotel);
        room.setFloor(room1.getFloor());
        room.setNumber(room1.getNumber());
        room.setSize(room1.getSize());
        roomRepository.save(room);
        return "saved";
    }

    public String edit(Integer id, RoomDto roomDto) {
        Optional<Room> byId = roomRepository.findById(roomDto.getNumber());
        if (byId.isPresent()){
            Optional<Hotel> byId1 = hotelRepository.findById(roomDto.getHotelId());
            if (byId1.isPresent()){
                Room room = byId.get();
                room.setSize(roomDto.getSize());
                room.setHotel(byId1.get());
                room.setNumber(roomDto.getNumber());
                room.setFloor(roomDto.getFloor());
                roomRepository.save(room);
                return "Edited";
            }
            return "not this hotel";
        }
        return "Not found";
    }

    public String del(Integer id) {
        Optional<Room> byId = roomRepository.findById(id);
        if (byId.isPresent()) {
            roomRepository.delete(byId.get());
            return "deleted";
        }
        return "Not found";
    }

    public Page<Room> getById(int page) {
        Pageable pageable= PageRequest.of(1, 2);
        Page<Room> rooms = roomRepository.findAll(pageable);
        return rooms;
    }
}
