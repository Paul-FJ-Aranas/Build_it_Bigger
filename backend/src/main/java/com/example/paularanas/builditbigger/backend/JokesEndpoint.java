/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.paularanas.builditbigger.backend;

import com.example.JokeLibrary;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "jokesApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.paularanas.example.com",
                ownerName = "backend.builditbigger.paularanas.example.com",
                packagePath = ""
        )
)
public class JokesEndpoint {


    @ApiMethod(name = "tellJoke")
    public Jokes tellJoke() {
        Jokes jokes = new Jokes();
        jokes.setData(new JokeLibrary().getJoke());

        return jokes;
    }

}
