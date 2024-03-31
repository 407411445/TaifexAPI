package com.youzhan.tailfex;

import com.youzhan.tailfex.dao.TaifexDao;
import com.youzhan.tailfex.dto.TaifexDto;
import com.youzhan.tailfex.model.Taifex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaifexService {

    private final TaifexDao taifexDao;

    @Autowired
    public TaifexService(TaifexDao taifexDao) {
        this.taifexDao = taifexDao;
    }

    public void createTaifexInfo(TaifexDto inputDto){
        Taifex entity = new Taifex();
        entity.setRmb2ntd(Double.valueOf(inputDto.getRMB_NTD()));
        entity.setUsd2ntd(Double.valueOf(inputDto.getUSD_NTD()));
        entity.setUsd2rmb(Double.valueOf(inputDto.getUSD_RMB()));
        taifexDao.insertTaifexDto(entity);
    }

    public void updateTaifexInfo(TaifexDto inputDto){
        Taifex entity = new Taifex();
        entity.setRmb2ntd(Double.valueOf(inputDto.getRMB_NTD()));
        entity.setUsd2ntd(Double.valueOf(inputDto.getUSD_NTD()));
        entity.setUsd2rmb(Double.valueOf(inputDto.getUSD_RMB()));
        taifexDao.updateTaifexDto(entity);
    }

    public Long getTaifexInfo(TaifexDto inputDto){
        Taifex entity = taifexDao.findTaifexDtoByDate(inputDto.getDate());
        Long unid = entity.getId();
        return unid;
    }

    public void deleteTaifexInfo(TaifexDto inputDto){
        Taifex entity = taifexDao.findTaifexDtoByDate(inputDto.getDate());
        taifexDao.deleteTaifexDto(entity);
    }
}
