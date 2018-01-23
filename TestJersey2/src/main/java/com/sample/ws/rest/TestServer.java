package com.sample.ws.rest;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.ws.dto.RequestObj;
import com.sample.ws.dto.ResponseObj;

/**
 * 
 * Server tests 
 * 
 * @author leonelsoriano3@gmail.com
 *
 */
@Path("/test")
public class TestServer {
    /**
     * This method return a hello World
     * 
     * @return string of test
     */
	@GET
    public String inicio()
    {
         return "Hello World!";
    }

}