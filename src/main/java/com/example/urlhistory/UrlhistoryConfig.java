package com.example.urlhistory;

import com.example.urlhistory.exception.ResourceNotFoundException;
import com.example.urlhistory.model.Account;
import com.example.urlhistory.model.Url;
import com.example.urlhistory.repository.AccountRepository;
import com.example.urlhistory.repository.UrlRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Component
public class UrlhistoryConfig {
    private UrlRepository urlRepository;

    public UrlhistoryConfig(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public void deleteOldestUrlHistory(Account account) {
        List<Url> urlList = urlRepository.findUrlByName(account.getAccountName());
        long difference = Math.abs(account.getUrlMaxCount() - urlList.size());
        if (urlList.size() > account.getUrlMaxCount()) {
            List<Url> urlListOrderByCreatedAt = urlRepository.findUrlByNameOrderByCreatedAt(account.getAccountName());
            if (difference == 1){
                urlRepository.deleteById(urlListOrderByCreatedAt.get(0).getId());
            }
            else {
                for (int i=0; i<difference; i++) {
                    urlRepository.deleteById(urlListOrderByCreatedAt.get(i).getId());
                }
            }
        }
    }

    @Scheduled(fixedRate = 15000)
    public void deleteExpiredUrlhistory() {
        List<Url> urlList = urlRepository.findAll();
        urlList.forEach(url -> {
            if (url.isExpire()) {
                Instant expireAtInstant = url.getVisitedAt().toInstant().plus(
                        url.getAccount().getStorageDurationInDays(), ChronoUnit.DAYS);
                System.out.println(
                        expireAtInstant + "\t" +
                                Instant.now()
                );
                if (expireAtInstant.isBefore(Instant.now())) {
                    System.out.println("Being deleted!!");
                    urlRepository.findById(url.getId()).orElseThrow(
                            () -> new ResourceNotFoundException("Url", "Id", url.getId()));
                    urlRepository.deleteById(url.getId());
                }
            }
        });
    }
}