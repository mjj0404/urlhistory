package com.example.urlhistory.service.impl;

import com.example.urlhistory.UrlhistoryConfig;
import com.example.urlhistory.exception.InvalidInputRangeException;
import com.example.urlhistory.exception.ResourceNotFoundException;
import com.example.urlhistory.model.Url;
import com.example.urlhistory.repository.UrlRepository;
import com.example.urlhistory.service.UrlService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Service
public class UrlServiceImpl implements UrlService {
    private UrlRepository urlRepository;

    public UrlServiceImpl(UrlRepository urlRepository) {
        super();
        this.urlRepository = urlRepository;
    }

    @Override
    public Url saveUrl(Url url) {
        Date expireDate = Date.from(Instant.now().plus(url.getAccount().getStorageDurationInDays(), ChronoUnit.DAYS));
        url.setVisitedAt(Date.from(Instant.now()));
        url.setCreatedAt(Date.from(Instant.now()));
        url.setExpireAt(expireDate);
        url.setVisitCount(1L);
        url.setRating(0L);
        url.setExpire(true);

        UrlhistoryConfig config = new UrlhistoryConfig(urlRepository);
        config.deleteOldestUrlHistory(url.getAccount());

        return urlRepository.save(url);
    }

    @Override
    public List<Url> getUrlList(String name) {
        return urlRepository.findUrlByName(name);
    }

    @Override
    public Url updateUrlUponVisiting(Url url, long id) {
        Url existingUrl = urlRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Url", "Id", id));
        existingUrl.setVisitCount(existingUrl.getVisitCount() + 1);
        existingUrl.setVisitedAt(Date.from(Instant.now()));
        urlRepository.save(existingUrl);
        return existingUrl;
    }

    @Override
    public Url updateUrlRating(Url url, long id) {
        Url existingUrl = urlRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Url", "Id", id));
        if (url.getRating() > 5 || url.getRating() < 0) {
            throw new InvalidInputRangeException("Rating", url.getRating());
        }
        else {
            existingUrl.setRating(url.getRating());
            urlRepository.save(existingUrl);
        }
        return existingUrl;
    }

    @Override
    public void deleteUrl(long id) {
        urlRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Url", "Id", id));
        urlRepository.deleteById(id);
    }

}