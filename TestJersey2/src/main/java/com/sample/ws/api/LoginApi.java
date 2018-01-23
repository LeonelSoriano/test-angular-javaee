package com.sample.ws.api;


import com.sample.ws.dao.UserDao;
import com.sample.ws.dto.out.LoginResponse;
import com.sample.ws.model.UserModel;
import org.eclipse.persistence.sessions.Login;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/login")
public class LoginApi {

    private final UserDao userDao;

    @Inject
    public LoginApi(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * login rest end point
     * @param login parce json login in
     * @return  if not found user witd param response is 404 else is 200
     */
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(@Valid Login login)
    {
        LoginResponse loginResponse = new LoginResponse();

        UserModel userModel = this.userDao.login(login);

        if(userModel != null){
            loginResponse.setMsg("Usuario logeado correctamente");
            return Response.status(Response.Status.OK).
                    entity(loginResponse).type(MediaType.APPLICATION_JSON).build();
        }else{
            loginResponse.setMsg("usuario no encontrado");
            return Response.status(Response.Status.NOT_FOUND)
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Credentials", "true")
                    .header("Access-Control-Allow-Headers",
                            "origin, content-type, accept, authorization")
                    .header("Access-Control-Allow-Methods",
                            "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                    .entity(loginResponse)
                    .type(MediaType.APPLICATION_JSON).build();
        }
    }


}
