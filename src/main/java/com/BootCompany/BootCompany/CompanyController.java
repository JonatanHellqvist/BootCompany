package com.BootCompany.BootCompany;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CompanyController {
    
    //getmapping för startsidan
    @RequestMapping("/companyInfo") 
        String companyInfo() {
        return "companyInfo";
    }
    
    //******PRUDUKTSIDAN*******

    //*****LISTAN FÖR PRODUKTSIDAN*****
    private static final List<CompanyProducts> productItems = new ArrayList<>();
    static {
        productItems.add(new CompanyProducts("Bil1",1000,1));
        productItems.add(new CompanyProducts("Bil2",1000,2));
        productItems.add(new CompanyProducts("Bil3",1000,3));
        productItems.add(new CompanyProducts("Bil4",1000,4));
    }
    //*********GETMAPPING FÖR PRODUKTSIDAN********
    @GetMapping("/products")
    String getCompanyProducts(Model model) {
        model.addAttribute("productItems",productItems);
        model.addAttribute("newItem", new CompanyProducts(null, 0, 0));
        return "products";
    }

    //****POSTMAPPING FÖR PRODUKTSIDAN
    //****FORM "new-product" SOM LÄGGER TILL I LISTAN "productItems"
    //****REQUESTPARAM name från TEXTEN I FORMET OCH LÄGGER TILL IDT SOM "productItems.size() +1"
    //****sen redirectar tillbaka till GetMapping för products listan "/products"
    @PostMapping("/new-product")
    String newProduct(@RequestParam("name") String name) {
        System.out.println("PostMapping " + name);
        productItems.add(new CompanyProducts(name, 0, productItems.size() +1));
        return "redirect:/products";
    }

    //*****ANSTÄLLDASIDAN*****

    //*****LISTA FÖR ANSTÄLLDASIDAN******
    private static final List<CompanyEmployes> employeList = new ArrayList<>();
    static {
        employeList.add(new CompanyEmployes("Kalle", 69, 1));
        employeList.add(new CompanyEmployes("Kalle2", 69, 2));
        employeList.add(new CompanyEmployes("Kalle3", 69, 3));
        employeList.add(new CompanyEmployes("Kalle4", 69, 4));
    }
    //*****GETMAPPING FÖR ANSTÄLLDASIDAN*****
     @GetMapping("/employes")
    String getCompanyEmployes(Model model) {
        model.addAttribute("employeList",employeList);
        return "employes";
    }
    
    
        

    
    

/*
@Controller
public class TodoController {

    private static final List<Todo> todoItems = new ArrayList<>();
    
    @GetMapping("/todo")
    String getTodo(Model model) {
        model.addAttribute("todoItems", todoItems);
        model.addAttribute("newTodo",new Todo(null,0));
        return "todo";
    }
    
    @PostMapping("/new-item")
    String newItem(@RequestParam("name") String name) {
        System.out.println("PostMapping " + name);
        todoItems.add(new Todo(name, todoItems.size() +1));
        return "redirect:/todo";
    }

    @GetMapping("/remove-item/{itemId}")
    String removeItem(@PathVariable int itemId) {
        System.out.println("RemoveItem " + itemId);
        todoItems.removeIf(item -> item.getId() == itemId);
        return "redirect:/todo";
    }
}
 */
    
}
