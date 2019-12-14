package xmu.oomall.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import xmu.oomall.domain.DefaultFreight;
import xmu.oomall.domain.DefaultPieceFreight;
import xmu.oomall.domain.SpecialFreight;

import java.util.List;

@Service
public interface FreightService {

    public Object getDefaultFreights(Integer limit,Integer page);

    public Object addDefaultFreight(DefaultFreight defaultFreight);

    public Object updateDefaultFreight(Integer id,DefaultFreight defaultFreight);

    public void deleteDefaultFreight(Integer id);

    public Object getDefaultPieceFreight(Integer limit,Integer page);

    public Object addDefaultPieceFreight(DefaultPieceFreight defaultPieceFreight);

    public Object updateDefaultPieceFreight(Integer id,DefaultPieceFreight defaultPieceFreight);

    public void deleteDefaultPieceFreight(Integer id);

    public Object getSpecialFreights(Integer limit,Integer page);

    public Object addSpecialFreight(SpecialFreight specialFreights);

    public Object updateSpecialFreights(Integer id,SpecialFreight specialFreight);

    public void deleteSpecialFreights(Integer id);
}
