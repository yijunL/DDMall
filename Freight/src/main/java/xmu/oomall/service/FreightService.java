package xmu.oomall.service;

import org.springframework.stereotype.Service;
import xmu.oomall.domain.DefaultFreightPo;
import xmu.oomall.domain.DefaultPieceFreightPo;
import xmu.oomall.domain.SpecialFreight;

import java.util.List;

@Service
public interface FreightService {

    public List<DefaultFreightPo> getDefaultFreights(Integer page, Integer limit);

    public DefaultFreightPo addDefaultFreight(DefaultFreightPo defaultFreightPo);

    public DefaultFreightPo updateDefaultFreight(Integer id, DefaultFreightPo DefaultFreightPo);

    public boolean deleteDefaultFreight(Integer id);

    public DefaultPieceFreightPo getDefaultPieceFreight(Integer page, Integer limit);

    public DefaultPieceFreightPo addDefaultPieceFreight(DefaultPieceFreightPo defaultPieceFreightPo);

    public DefaultPieceFreightPo updateDefaultPieceFreight(Integer id, DefaultPieceFreightPo defaultPieceFreightPo);

    public boolean deleteDefaultPieceFreight(Integer id);

    public SpecialFreight getSpecialFreights(Integer id);

    public List<SpecialFreight> getAllSpecialFreight(Integer page, Integer limit);

    public SpecialFreight addSpecialFreight(SpecialFreight specialFreights);

    public SpecialFreight updateSpecialFreights(Integer id, SpecialFreight specialFreight);

    public boolean deleteSpecialFreights(Integer id);
}
