package xmu.oomall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.dao.DefaultFreightDao;
import xmu.oomall.dao.DefaultPieceFreightDao;
import xmu.oomall.dao.SpecialFreightDao;
import xmu.oomall.domain.DefaultFreightPo;
import xmu.oomall.domain.DefaultPieceFreightPo;
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
    public List<DefaultFreightPo> getDefaultFreights(Integer page, Integer limit) {
        return defaultFreightDao.getDefaultFreights(page, limit);
    }

    @Override
    public DefaultFreightPo addDefaultFreight(DefaultFreightPo defaultFreightPo) {
        return defaultFreightDao.addDefaultFreight(defaultFreightPo);
    }

    @Override
    public DefaultFreightPo updateDefaultFreight(Integer id, DefaultFreightPo DefaultFreightPo) {
        return defaultFreightDao.updateDefaultFreight(id, DefaultFreightPo);
    }


    @Override
    public Boolean deleteDefaultFreight(Integer id) {

        return defaultFreightDao.deleteDefaultFreight(id);
    }

    @Override
    public List<DefaultPieceFreightPo> getDefaultPieceFreightsList(Integer page, Integer limit) {

        return defaultPieceFreightDao.getDefaultPieceFreight(page,limit);
    }

    @Override
    public DefaultPieceFreightPo addDefaultPieceFreight(DefaultPieceFreightPo defaultPieceFreightPo) {

        return defaultPieceFreightDao.addDefaultPieceFreight(defaultPieceFreightPo);
    }

    @Override
    public DefaultPieceFreightPo updateDefaultPieceFreight(Integer id, DefaultPieceFreightPo defaultPieceFreightPo) {
        return updateDefaultPieceFreight(id,defaultPieceFreightPo);
    }

    @Override
    public Boolean deleteDefaultPieceFreight(Integer id) {

        return defaultPieceFreightDao.deleteDefaultPieceFreight(id);
    }

    @Override
    public SpecialFreight getSpecialFreights(Integer id) {

        return specialFreightDao.getSpecialFreights(id);
    }

    @Override
    public List<SpecialFreight> getAllSpecialFreight(Integer page, Integer limit) {
        return specialFreightDao.getAllSpecialFreights(page, limit);
    }

    @Override
    public SpecialFreight addSpecialFreight(SpecialFreight specialFreights) {
        return specialFreightDao.addSpecialFreight(specialFreights);
    }

    @Override
    public SpecialFreight updateSpecialFreights(Integer id, SpecialFreight specialFreight) {
        return specialFreightDao.updateSpecialFreight(specialFreight, id);
    }

    @Override
    public Boolean deleteSpecialFreights(Integer id) {
        return specialFreightDao.deleteSpecialFreight(id);
    }


}