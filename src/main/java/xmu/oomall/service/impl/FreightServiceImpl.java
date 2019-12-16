package xmu.oomall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.dao.DefaultFreightDao;
import xmu.oomall.dao.DefaultPieceFreightDao;
import xmu.oomall.dao.SpecialFreightDao;
import xmu.oomall.domain.DefaultFreight;
import xmu.oomall.domain.DefaultFreightPo;
import xmu.oomall.domain.DefaultPieceFreight;
import xmu.oomall.domain.SpecialFreight;
import xmu.oomall.service.FreightService;

import java.util.List;

@Service
public class FreightServiceImpl implements FreightService {
    @Autowired
    private DefaultFreightDao defaultFreightDao;
    @Autowired
    private SpecialFreightDao specialFreightDao;
    @Autowired
    private DefaultPieceFreightDao defaultPieceFreightDao;

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
    public boolean deleteDefaultFreight(Integer id) {
        return defaultFreightDao.deleteDefaultFreight(id);
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
    public boolean deleteDefaultPieceFreight(Integer id) {
        return false;
    }

    @Override
    public SpecialFreight getSpecialFreights(Integer id) {
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
    public boolean deleteSpecialFreights(Integer id) {
        return false;
    }
}