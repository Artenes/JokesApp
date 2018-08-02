package com.udacity.gradle.builditbigger.backend;

import com.artenesnogueira.puns.Puns;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/**
 * What did daddy spider say to baby spider? You spend too much time on the web.
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * What cheese can never be yours? Nacho cheese.
     */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi() {
        Puns puns = new Puns();
        MyBean response = new MyBean();
        response.setData(puns.getPun());

        return response;
    }

}
