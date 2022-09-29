package com.example.urlhistory.service;


import com.example.urlhistory.model.Url;
import com.example.urlhistory.model.wrapper.UserWrapper;

import java.util.List;

public interface UrlService {
    Url saveUrl(Url url);
    List<Url> getUrlList(String name);
    Url updateUrlUponVisiting(Url url, long id);
    Url updateUrlRating(Url url, long id);
}
