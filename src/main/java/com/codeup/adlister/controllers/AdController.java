package com.codeup.adlister.controllers;

import com.codeup.adlister.Repository.AdRepository;
import com.codeup.adlister.Repository.UserRepository;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdController {
    private final AdRepository adDao;
    private final UserRepository userDao;


    public AdController(AdRepository adDao, UserRepository userDao) {
        this.adDao = adDao;
        this.userDao = userDao;
    }
    //Shows all ads
    @GetMapping("/ads")
    public String GetAds(Model model) {
        model.addAttribute("ads", adDao.findAll());
        return "ads/index";
    }


    //Ad creation get and post requests
    @GetMapping("/ads/create")
    public String showCreateForm(Model model) {
        model.addAttribute("ad", new Ad());
        return "ads/create";
    }
    //TODO: WILL NEED TO PASS A LOGGED IN USER ID WHEN WE GET THERE AND HAVE IT
    // PASSED IN THE POST METHOD TO CONNECT THE "AD" TO THE LOGGED IN "USER"
    @PostMapping("/ads/create")
    public String CreateAd(
            @ModelAttribute Ad dbAd) {
        User user = userDao.getOne(1L);
        dbAd.setUser(user);
        adDao.save(dbAd);
        return "redirect:/ads";
    }


    //Show's a single ad's content
    @GetMapping("/ads/{id}")
    public String GetAd(@PathVariable long id, Model model) {
        model.addAttribute("ad", adDao.getOne(id));
        return "/ads/show";
    }


    //Ad edit get and post requests
    @GetMapping("/ads/{id}/edit")
    public String EditAd(@PathVariable long id, Model model) {
        model.addAttribute("ad", adDao.getOne(id));
        return "/ads/edit";
    }
    @PostMapping("/ads/{id}/edit")
    public String UpdateAd(
            @PathVariable long id,
            @ModelAttribute Ad adToBeEdited
    ){
        User user = adDao.getOne(id).getUser();
        adToBeEdited.setUser(user);
        adToBeEdited.setId(id);
        adDao.save(adToBeEdited);
        return "redirect:/ads";
    }


    //Delete's a ad by it's passed Id
    @PostMapping("/delete/ad/{id}")
    public String DeleteAd(@PathVariable long id) {
        adDao.deleteById(id);
        return "redirect:/ads";
    }
}