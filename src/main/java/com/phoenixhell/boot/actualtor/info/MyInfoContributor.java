package com.phoenixhell.boot.actualtor.info;

import org.springframework.boot.actuate.health.ContributorRegistry;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

/**
 * @author phoenixhell
 * @create 2021/1/16 0016-上午 9:24
 */
@Component
public class MyInfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("msg","hello MyInfoContributor").withDetail("code","9527") ;
    }
}
