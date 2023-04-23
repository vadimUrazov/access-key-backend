package com.example.accesskeybackend.template.service;

import com.example.accesskeybackend.template.dto.AccessKeyWebDto;
import org.apache.commons.validator.routines.DomainValidator;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.stereotype.Service;
import java.net.*;

@Service
public class AccessKeyWebService {
    public AccessKeyWebDto checkIpv6Support( String  siteUrl)  throws Exception{
        boolean isIPv6=false;
      siteUrl=parseInputUrl(siteUrl);
        if (checkSiteUrl(siteUrl)) {
            siteUrl=getDomainName(siteUrl);
            InetAddress inetAddress = InetAddress.getByName(siteUrl);
                isIPv6 = (inetAddress instanceof Inet6Address);
        }

    AccessKeyWebDto accessKeyWebDto=new AccessKeyWebDto(isIPv6);
        return accessKeyWebDto;
    }

    private String parseInputUrl(String url){
        if(url==null){
            return null;
        }
        url=url.replace("{","").replace("}","")
        .replace("\n","").replace("\"","");
       if(url.startsWith("siteUrl")){
           url=url.substring(8);
       }
        return url;
    }
    private boolean checkSiteUrl(String url){
        String[] protocols={"http", "https", "ftp", "tcp", "udp","dhcp", "ip", "icmp","sock4","sock5","telnet"};
        UrlValidator urlValidator=new UrlValidator(protocols);
        DomainValidator domainValidator=DomainValidator.getInstance(true);
        if(url==null ||!url.contains(".")){
            return false;
         }
        return urlValidator.isValid(url) || domainValidator.isValid(url);
    }

    private  String getDomainName(String url) throws Exception {
        URI netUrl = new URI(url);
        String host = netUrl.getHost();
          if(host==null){
              host=url;
           }
        if(host.startsWith("www")){
            host = host.substring("www".length()+1);
        }

        return host;
    }

}

