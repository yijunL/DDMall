package xmu.oomall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.dao.DefaultFreightDao;
import xmu.oomall.dao.DefaultPieceFreightDao;
import xmu.oomall.dao.SpecialFreightDao;
import xmu.oomall.domain.*;
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
    public List<DefaultFreightPo> getDefaultFreights(Integer page, Integer limit) {
        return defaultFreightDao.getDefaultFreights(page,limit);
    }

    @Override
    public DefaultFreightPo addDefaultFreight(DefaultFreightPo defaultFreightPo) {
        return null;
    }

    @Override
    public DefaultFreightPo updateDefaultFreight(Integer id, DefaultFreightPo DefaultFreightPo) {
        return null;
    }


    @Override
    public boolean deleteDefaultFreight(Integer id) {
        return defaultFreightDao.deleteDefaultFreight(id);
    }

    @Override
    public DefaultPieceFreightPo getDefaultPieceFreight(Integer page, Integer limit) {
        return null;
    }

    @Override
    public DefaultPieceFreightPo addDefaultPieceFreight(DefaultPieceFreightPo defaultPieceFreightPo) {
        return null;
    }

    @Override
    public DefaultPieceFreightPo updateDefaultPieceFreight(Integer id, DefaultPieceFreightPo defaultPieceFreightPo) {
        return null;
    }

    @Override
    public boolean deleteDefaultPieceFreight(Integer id) {
        return false;
    }

    @Override
    public SpecialFreight getSpecialFreights(Integer id) {
        return specialFreightDao.getSpecialFreights(id);
    }

    @Override
    public List<SpecialFreight> getAllSpecialFreight(Integer page, Integer limit) {
        return null;
    }

    @Override
    public SpecialFreight addSpecialFreight(SpecialFreight specialFreights) {
        return null;
    }

    @Override
    public SpecialFreight updateSpecialFreights(Integer id, SpecialFreight specialFreight) {
        return null;
    }

    @Override
    public boolean deleteSpecialFreights(Integer id) {
        return false;
    }


}