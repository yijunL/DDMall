package xmu.oomall.test;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import xmu.oomall.vo.LoginVo;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * 用户帐号的抽象类
 * @author mingqiu
 * @date 2019/12/8
 */
public abstract class BaseAccount {

    protected abstract String getUserName();
    protected abstract String getPassword();
    protected abstract String getUrl();
    protected abstract RestTemplate getRestTemplate();

    protected String token = "";

    /**
     * 登录服务器，获取JWT Token
     * @return 登录成功与否
     */
    private boolean getToken() throws URISyntaxException {
        LoginVo loginVo = new LoginVo();
        loginVo.setUsername(this.getUserName());
        loginVo.setPassword(this.getPassword());

        URI uri = new URI(this.getUrl());
        HttpHeaders httpHeaders = this.getRestTemplate().headForHeaders(uri);
        HttpEntity httpEntity = new HttpEntity(loginVo, httpHeaders);

        ResponseEntity<String> response = this.getRestTemplate().postForEntity(uri, httpEntity, String.class);
        if (response.getStatusCode() == HttpStatus.OK){
            this.token = response.getHeaders().get("authorization").get(0);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 在包头上加上JWT Token
     * @param headers 包头
     * @return 成功与否
     */
    public boolean addToken(HttpHeaders headers) throws URISyntaxException {
        boolean retVal = true;
        if (this.token == ""){
            retVal = this.getToken();
        }
        if (retVal){
            headers.add("authorization", token);
        }
        return retVal;
    }
}