package xmu.oomall.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/admin-freightSerice")// /wx/order

public class FreightController {


    @GetMapping("/defaultFreights")
    public Object getDefaultFreights()
    {
        return 0;
    }
}