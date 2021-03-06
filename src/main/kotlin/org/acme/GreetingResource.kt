package org.acme

import io.smallrye.mutiny.Uni
import java.io.File
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/hello-resteasy")
class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello() = "Hello RESTEasy"

    @GET
    @Path("/get-file/{fileName}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    fun test(@PathParam("fileName") fileName: String): Uni<Response> {
        val file = File(fileName)
        val response = Response.ok(file)
        response.header("Content-Disposition", "attachment;filename=$file")
        return Uni.createFrom().item(response.build())
    }
}
