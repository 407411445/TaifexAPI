package com.youzhan.Utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.youzhan.tailfex.dto.TaifexDto;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class taifexUtils {
    public static List<TaifexDto> parseTaifex(String responseBody) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Map<String, String>>>() {}.getType();
        List<Map<String, String>> dataList = gson.fromJson(responseBody, listType);
        List<TaifexDto> taifexJson = new ArrayList<>();
        for (Map<String, String> data : dataList){
            TaifexDto dto = new TaifexDto();
            dto.setUSD_NTD(data.get("USD/NTD"));
            dto.setRMB_NTD(data.get("RMB/NTD"));
            dto.setUSD_RMB(data.get("USD/RMB"));
            taifexJson.add(dto);
        }
        return taifexJson;
    }
}
