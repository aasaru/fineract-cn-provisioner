package org.apache.fineract.cn.provisioner.rest.controller;

import org.apache.fineract.cn.anubis.annotation.AcceptedTokenType;
import org.apache.fineract.cn.anubis.annotation.Permittable;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HealthController implements HealthIndicator {

    @Permittable(AcceptedTokenType.GUEST)
    @Override
    @RequestMapping(
         value = "/health",
         method = RequestMethod.GET,
         consumes = {MediaType.ALL_VALUE},
         produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Health health() {
        return Health.up().build();
    }

}
