package xmu.oomall.service.impl;

import org.springframework.stereotype.Service;
import xmu.oomall.dao.DefaultFreightDao;
import xmu.oomall.domain.DefaultFreight;
import xmu.oomall.domain.DefaultFreightPo;
import xmu.oomall.service.FreightService;

import java.util.List;

@Service
public class FreightServiceImpl implements FreightService {

    @Override
    public List<DefaultFreight> getDefaultFreights() {
        List<DefaultFreightPo> defaultFreightPoList=DefaultFreightDao.getDefaultFreights();
    }
}