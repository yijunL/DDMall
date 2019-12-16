package xmu.oomall.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import xmu.oomall.domain.*;

import java.util.List;

@Service
public interface FreightService {

    public List<DefaultFreightPo> getDefaultFreights(Integer limit, Integer page);

    public DefaultFreightPo addDefaultFreight(DefaultFreightPo defaultFreightPo);

    public DefaultFreightPo updateDefaultFreight(Integer id,DefaultFreightPo DefaultFreightPo);

    public boolean deleteDefaultFreight(Integer id);

    public DefaultPieceFreightPo getDefaultPieceFreight(Integer limit, Integer page);

    public DefaultPieceFreightPo addDefaultPieceFreight(DefaultPieceFreightPo defaultPieceFreightPo);

    public DefaultPieceFreightPo updateDefaultPieceFreight(Integer id,DefaultPieceFreightPo defaultPieceFreightPo);

    public boolean deleteDefaultPieceFreight(Integer id);

    public SpecialFreight getSpecialFreights(Integer id);

    public List<SpecialFreight> getAllSpecialFreight();

    public SpecialFreight addSpecialFreight(SpecialFreight specialFreights);

    public SpecialFreight updateSpecialFreights(Integer id,SpecialFreight specialFreight);

    public boolean deleteSpecialFreights(Integer id);
}
