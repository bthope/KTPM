package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.services.OrderServices;

@RestController
@RequestMapping("/api/orders")
public class OrderControllers {

    @Autowired
    private OrderServices orderServices;

    @PostMapping("")
    public ResponseEntity<String> send(@RequestBody String jsonDoc){
        orderServices.sendOrder("processing.order_1", jsonDoc);

        return ResponseEntity.ok("{'state' : 'sent'}");
    }
}

