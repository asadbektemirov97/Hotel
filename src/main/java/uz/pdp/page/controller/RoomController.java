package uz.pdp.page.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import uz.pdp.page.dto.RoomDto;
import uz.pdp.page.entity.Hotel;
import uz.pdp.page.entity.Room;
import uz.pdp.page.servise.HotelService;
import uz.pdp.page.servise.RoomService;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    RoomService roomService;
    @GetMapping()
    public List<Room> getAllHotel(){
        return roomService.getAll();
    }
    @PostMapping("/add")
    public String add(@RequestBody RoomDto roomDto){
        return roomService.add(roomDto);
    }
    @PutMapping("/edite/{id}")
    public String edit(@RequestBody RoomDto roomDto,@PathVariable Integer id){
        return roomService.edit(id,roomDto);
    }
    @DeleteMapping("delete/{id}")
    public String del(@PathVariable Integer id){
        return roomService.del(id);
    }

    @GetMapping("/getByHotelId/{id} ")
    public Page<Room>getByHotelId(@RequestParam int page){
        return roomService.getById(page);
    }
}
