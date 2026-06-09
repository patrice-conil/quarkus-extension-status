package com.pconil

import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType

@Path("/hello")
class ExampleResource {

    data class Result(val message: String)

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun hello() = Result("Hello from Quarkus REST")
}
