package xmu.oomall.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import xmu.oomall.domain.SpecialFreight;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class SpecialFreightDaoTest {
    @Autowired
    private SpecialFreightDao specialFreightDao;

    @Test
    public void getSpecialFreightsTest() {
        SpecialFreight specialFreight = specialFreightDao.getSpecialFreights(1);
        assertEquals(specialFreight.getId(), 1);
    }

}