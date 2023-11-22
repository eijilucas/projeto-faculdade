package com.projetofaculdade.fasterfood.controllers;

import com.projetofaculdade.fasterfood.controllers.services.CollaboratorServices;
import com.projetofaculdade.fasterfood.controllers.services.CostumerServices;
import com.projetofaculdade.fasterfood.controllers.services.OrderServices;
import com.projetofaculdade.fasterfood.controllers.services.PaymentServices;
import com.projetofaculdade.fasterfood.controllers.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pages")
public class PageController {

    @Autowired
    CollaboratorServices collaboratorServices;
    
    @Autowired
    CostumerServices costumerServices;
    
    @Autowired
    OrderServices orderServices;
    
    @Autowired
    PaymentServices paymentServices;
    
    @Autowired
    ProductServices productServices;
    
    @GetMapping
    public ModelAndView indexPage() {
        return new ModelAndView("index");
    }
    
    // TODO Métodos CRUD
}
