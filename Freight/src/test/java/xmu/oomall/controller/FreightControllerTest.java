package xmu.oomall.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import xmu.oomall.dao.DefaultFreightDao;
import xmu.oomall.domain.DefaultFreightPo;
import xmu.oomall.util.JacksonUtil;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
public class FreightControllerTest {
    @Autowired
    private FreightController freightController;


    @Value("http://localhost:8081/defaultFreights")
    String url;
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void getAllDefaultFreightTest()throws Exception {

        URI uri=new URI(url);
        HttpHeaders httpHeaders = testRestTemplate.headForHeaders(uri);

        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<String> response = testRestTemplate.exchange(uri, HttpMethod.GET, httpEntity, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        /*取得响应体*/
        String body = response.getBody();

        Integer errno = JacksonUtil.parseInteger(body, "errno");
        assertEquals(200, errno);

        /*assert判断*/
        List<DefaultFreightPo> defaultFreightPoList = JacksonUtil.parseObject(body, "data", List.class);
        assertEquals(defaultFreightPoList.get(0).getId(), 3);
    }


//    public void getSpecialFreightByIdTest()
//    {
//        SpecialFreight specialFreight=freightController.getSpecialFreights(1);
//        assertEquals(specialFreight.getId(),1);
//    }

    @Test
    public void deleteDefaultFreightTest() {
        Map<String, Object> respon = (Map<String, Object>) freightController.deleteDefaultFreight(1);
        assertEquals(respon.get("errno"), 0);
    }

//    @Test
//    public void getAllDefaultFreightTest() {
//        Map<String, Object> respon = (Map<String, Object>) freightController.getDefaultFreights(2, 2);
//
//        List<DefaultFreightPo> defaultFreightPoList = (List<DefaultFreightPo>) respon.get("data");
//        assertEquals(defaultFreightPoList.get(0).getId(), 3);
//        assertEquals(respon.get("errno"), 0);
//    }

    @Test
    public void addDefaultFreightTest() {
        DefaultFreightPo defaultFreightPo = new DefaultFreightPo();
        defaultFreightPo.setRequireDays("1-3");

        defaultFreightPo.setOver10Price(new BigDecimal("10"));
        defaultFreightPo.setOver50Price(new BigDecimal("100"));
        Map<String, Object> respon = (Map<String, Object>) freightController.addDefaultFreight(defaultFreightPo);
        DefaultFreightPo defaultFreightPo1 = (DefaultFreightPo) respon.get("data");
        assertEquals(defaultFreightPo1.getOver10Price(), new BigDecimal("10"));
    }

}