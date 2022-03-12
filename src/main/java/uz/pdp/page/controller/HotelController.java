package uz.pdp.page.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.page.entity.Hotel;
import uz.pdp.page.servise.HotelService;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    HotelService hotelService;
    @GetMapping()
    public List<Hotel> getAllHotel(){
        return hotelService.getAll();
    }
    @PostMapping("/add")
    public String add(@RequestBody Hotel hotel){
        return hotelService.add(hotel);
    }
    @PutMapping("/edite/{id}")
    public String edit(@RequestBody Hotel hotel,@PathVariable Integer id){
        return hotelService.edit(id,hotel);
    }
    @DeleteMapping("delete/{id}")
    public String del(@PathVariable Integer id){
        return hotelService.del(id);
    }
}
