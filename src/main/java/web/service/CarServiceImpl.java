package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.Arrays;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private static final List<Car> cars = Arrays.asList(
            new Car("BMW", "3 series", "blue"),
            new Car("Audi", "a4", "black"),
            new Car("Lada", "vesta", "white"),
            new Car("Mercedes", "ML", "white"),
            new Car("Skoda", "Octavia", "red")
    );

    public List<Car> getCars(int count) {
        return cars.stream().limit(count).toList();
    }
}
