package com.example.accesskeybackend;

import com.example.accesskeybackend.template.dto.AccessKeyWebDto;
import com.example.accesskeybackend.template.service.AccessKeyWebService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAccessKeyWebService {

    private final AccessKeyWebService service=new AccessKeyWebService();

    @Test
    public void testCheckIpv6DomainTrue() throws Exception {
        AccessKeyWebDto dto=service.checkIpv6Support("ipv6.google.com");
        assertEquals(true,dto.isSuccess());
    }

    @Test
    public void testCheckIpv6DomainFalse() throws Exception {
        AccessKeyWebDto dto=service.checkIpv6Support("google.com");
        assertEquals(false,dto.isSuccess());
    }

    @Test
    public void testCheckIpv6URLTrue() throws Exception {
        AccessKeyWebDto dto=service.checkIpv6Support("http://ipv6.google.com/");
        assertEquals(true,dto.isSuccess());
    }

    @Test
    public void testCheckIpv6NullURL() throws Exception {
        AccessKeyWebDto dto=service.checkIpv6Support(null);
        assertEquals(false,dto.isSuccess());
    }

    @Test
    public void testCheckIpv6EmptyURL() throws Exception {
        AccessKeyWebDto dto=service.checkIpv6Support("");
        assertEquals(false,dto.isSuccess());
    }

    @Test
    public void testCheckIpv6IncorrectURL() throws Exception {
        AccessKeyWebDto dto=service.checkIpv6Support("abc.com/");
        assertEquals(false,dto.isSuccess());
    }

    @Test
    public void testCheckIpv6URLFalse() throws Exception {
        AccessKeyWebDto dto=service.checkIpv6Support("https://stackoverflow.com/questions/140061/when-to-use-dynamic-vs-static-libraries");
        assertEquals(false,dto.isSuccess());
    }

    @Test
    public void testCheckIpv6URIFalse() throws Exception {
        AccessKeyWebDto dto=service.checkIpv6Support("http://www.ics.uci.edu/pub/ietf/uri/#Related");
        assertEquals(false,dto.isSuccess());
    }

    @Test
    public void testCheckIpv6URITrue() throws Exception {
        AccessKeyWebDto dto=service.checkIpv6Support("http://ipv6.google.com/pub/ietf/uri/#Related");
        assertEquals(true,dto.isSuccess());
    }

}
