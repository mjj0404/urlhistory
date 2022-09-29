package com.example.urlhistory.controller;

import com.example.urlhistory.model.Url;
import com.example.urlhistory.model.wrapper.UserWrapper;
import com.example.urlhistory.service.UrlService;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity<List<Url>> getUrlList(@RequestBody UserWrapper userWrapper) {
        if (userWrapper != null && userWrapper.getUser() != null) {
            System.out.println(userWrapper.getUser());
        }
        return new ResponseEntity<List<Url>> (urlService.getUrlList(userWrapper.getUser()), HttpStatus.OK);
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<Url>> getUrlListOrderBy(@RequestParam(defaultValue = "id, desc") String[] sort,
                                                       @RequestBody UserWrapper userWrapper) {
        try {
            List<Sort.Order> orders = new ArrayList<Sort.Order>();
            System.out.println(orders);

            if (sort[0].contains(",")) {
                for (String sortOrder : sort) {
                    String[] _sort = sortOrder.split(",");
                    orders.add(new Sort.Order(getSortDirection(_sort[1]), _sort[0]));
                }
            } else {
                orders.add(new Sort.Order(getSortDirection(sort[1]), sort[0]));
            }
            return new ResponseEntity<List<Url>>(urlService.getUrlList(userWrapper.getUser()), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}/visit")
    public ResponseEntity<Url> updateUrlVisitCount(@PathVariable long id, @RequestBody Url url) {
        return new ResponseEntity<Url>(urlService.updateUrlUponVisiting(url, id), HttpStatus.OK);
    }

    @PutMapping("/{id}/rating")
    public ResponseEntity<Url> updateUrlRating(@PathVariable long id, @RequestBody Url url) {
        return new ResponseEntity<Url>(urlService.updateUrlRating(url, id), HttpStatus.OK);
    }

    @PutMapping("/{id}/group")
    public ResponseEntity<Url> updateUrlGroup(@PathVariable long id, @RequestBody Url url) {
        return new ResponseEntity<Url>(urlService.updateUrlRating(url, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteUrl(@PathVariable long id) {
        urlService.deleteUrl(id);
        return new ResponseEntity<String>("Url deleted.", HttpStatus.OK);
    }

    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        }

        return Sort.Direction.ASC;
    }
}

