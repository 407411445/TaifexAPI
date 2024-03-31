package com.youzhan.controller;


import com.google.gson.Gson;
import com.youzhan.tailfex.dto.TaifexDto;
import com.youzhan.Utils.taifexUtils;
import com.youzhan.tailfex.TaifexService;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@Component
public class TaifexCtrl {

    @Autowired
    TaifexService taifexService;
    @RequestMapping(value="/demoAPI", method= RequestMethod.GET)
    public ResponseEntity<?> getTaifexInfo(Model model) {
        String url = "https://openapi.taifex.com.tw/v1/DailyForeignExchangeRates";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        httpGet.setHeader(HttpHeaders.IF_MODIFIED_SINCE, "Mon, 26 Jul 1997 05:00:00 GMT");
        httpGet.setHeader(HttpHeaders.CACHE_CONTROL, "no-cache");
        httpGet.setHeader(HttpHeaders.PRAGMA, "no-cache");

        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == HttpStatus.OK.value()) {
                HttpEntity entity =response.getEntity();
                String responseBody = EntityUtils.toString(entity);
                if(responseBody !=null){
                    List<TaifexDto> responseJson = taifexUtils.parseTaifex(responseBody);
                    model.addAttribute("taifexList",new Gson().toJson(responseJson));
                    return new ResponseEntity<>(new Gson().toJson(responseJson),HttpStatus.OK);
                }
            } else {
                return new ResponseEntity<>("Error occurred while fetching data. Status code: " + response.getStatusLine().getStatusCode(),
                        HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("not connect to API",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value="/insertAPI", method= RequestMethod.POST)
    public ResponseEntity<?> newTaifexInfo(@RequestBody TaifexDto inputDto) {
//        String url = "https://openapi.taifex.com.tw/v1/DailyForeignExchangeRates";
        taifexService.createTaifexInfo(inputDto);
        return new ResponseEntity<>("insert entity complete",HttpStatus.OK);
    }

    @RequestMapping(value="/updateAPI", method= RequestMethod.POST)
    public ResponseEntity<?> updateTaifexInfo(@RequestBody TaifexDto inputDto) {
        taifexService.updateTaifexInfo(inputDto);
        return new ResponseEntity<>("update entity complete",HttpStatus.OK);
    }

    @RequestMapping(value="/selectAPI", method= RequestMethod.POST)
    public ResponseEntity<?> getTaifexInfo(@RequestBody TaifexDto inputDto) {
        taifexService.getTaifexInfo(inputDto);
        return new ResponseEntity<>("complete！",HttpStatus.OK);
    }

    @RequestMapping(value="/deleteAPI", method= RequestMethod.DELETE)
    public ResponseEntity<?> deleteTaifexInfo(@RequestBody TaifexDto inputDto) {
        taifexService.deleteTaifexInfo(inputDto);
        return new ResponseEntity<>("delete complete！",HttpStatus.OK);
    }

}


