package xmu.oomall.service.impl;

import org.springframework.stereotype.Service;
import xmu.oomall.dao.DefaultFreightDao;
import xmu.oomall.domain.DefaultFreight;
import xmu.oomall.domain.DefaultFreightPo;
import xmu.oomall.domain.DefaultPieceFreight;
import xmu.oomall.domain.SpecialFreight;
import xmu.oomall.service.FreightService;

import java.util.List;

@Service
public class FreightServiceImpl implements FreightService {
    @Override
    public Object getDefaultFreights(Integer limit, Integer page) {
        return null;
    }

    @Override
    public Object addDefaultFreight(DefaultFreight defaultFreight) {
        return null;
    }

    @Override
    public Object updateDefaultFreight(Integer id, DefaultFreight defaultFreight) {
        return null;
    }

    @Override
    public void deleteDefaultFreight(Integer id) {

    }

    @Override
    public Object getDefaultPieceFreight(Integer limit, Integer page) {
        return null;
    }

    @Override
    public Object addDefaultPieceFreight(DefaultPieceFreight defaultPieceFreight) {
        return null;
    }

    @Override
    public Object updateDefaultPieceFreight(Integer id, DefaultPieceFreight defaultPieceFreight) {
        return null;
    }

    @Override
    public void deleteDefaultPieceFreight(Integer id) {

    }

    @Override
    public Object getSpecialFreights(Integer limit, Integer page) {
        return null;
    }

    @Override
    public Object addSpecialFreight(SpecialFreight specialFreights) {
        return null;
    }

    @Override
    public Object updateSpecialFreights(Integer id, SpecialFreight specialFreight) {
        return null;
    }

    @Override
    public void deleteSpecialFreights(Integer id) {

    }
}