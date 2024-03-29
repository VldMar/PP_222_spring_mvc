package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.List;

@Controller
public class CarsController {

    @Autowired
    private CarService carService;
    @GetMapping("/cars")
    public String showAll(@RequestParam(required = false, defaultValue = "5") Integer count, ModelMap model) {
        int carsCount = (count < 0) || (count > 5) ? 5 : count;

        List<Car> cars = carService.getCars(carsCount);
        model.addAttribute("cars", cars);

        return "cars";
    }
}
