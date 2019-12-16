package xmu.oomall.controller;

import org.junit.jupiter.api.Test;
import org.mockito.exceptions.verification.MoreThanAllowedActualInvocations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xmu.oomall.OomallApplication;
import xmu.oomall.domain.DefaultFreight;
import xmu.oomall.domain.DefaultFreightPo;
import xmu.oomall.service.FreightService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CollectionControllerTest {
    @Autowired
    private CollectionController collectionController;

    @Test
    public void CollectionControllerTest()
    {
        collectionController.deleteCollection(1);
    }
}