package com.example.urlhistory.controller;

import com.example.urlhistory.model.Url;
import com.example.urlhistory.model.wrapper.UserWrapper;
import com.example.urlhistory.service.UrlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/url")
public class UrlController {

    private UrlService urlService;

    public UrlController(UrlService urlService) {
        super();
        this.urlService = urlService;
    }

    @PostMapping()
    public ResponseEntity<Url> saveUrl(@RequestBody Url url) {
        return new ResponseEntity<Url>(urlService.saveUrl(url), HttpStatus.CREATED);
    }

    @GetMapping()
    public List<Url> getUrlList(@RequestBody UserWrapper userWrapper) {
        if (userWrapper != null && userWrapper.getUser() != null) {
            System.out.println(userWrapper.getUser());
        }
        return urlService.getUrlList(userWrapper.getUser());
    }

    @PutMapping("/visit/{id}")
    public ResponseEntity<Url> updateUrlVisitCount(@PathVariable long id, @RequestBody Url url) {
        return new ResponseEntity<Url>(urlService.updateUrlUponVisiting(url, id), HttpStatus.OK);
    }

    @PutMapping("/rating/{id}")
    public ResponseEntity<Url> updateUrlRating(@PathVariable long id, @RequestBody Url url) {
        return new ResponseEntity<Url>(urlService.updateUrlRating(url, id), HttpStatus.OK);
    }
}

