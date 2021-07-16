package org.acme.controller

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import org.acme.service.IOTDataService

@Path("/iot/")
class IOTDataController(
        val iotDataService: IOTDataService
) {

    @GET
    @Path("/collect/{data}")
    @Produces(MediaType.APPLICATION_JSON)
    fun collect(@PathParam("data") data: String): String {
        return iotDataService.collect(data)
    }
}
