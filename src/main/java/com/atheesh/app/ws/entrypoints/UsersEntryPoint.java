package com.atheesh.app.ws.entrypoints;


import com.atheesh.app.ws.factory.DTOToResponseFactory;
import com.atheesh.app.ws.factory.RequestToDTOFactory;
import com.atheesh.app.ws.model.request.UserRequest;
import com.atheesh.app.ws.model.response.UserResponse;
import com.atheesh.app.ws.service.UserService;
import com.atheesh.app.ws.shared.dto.UserDTO;
import com.atheesh.app.ws.shared.enums.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
@Path("users")
public class UsersEntryPoint {

    private final
    UserService userService;

    @Autowired
    public UsersEntryPoint(UserService userService) {
        this.userService = userService;
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON} )
    @Path("/status/{status}")
    public List<UserResponse> getUsersByStatus(@PathParam("status") UserStatus status) {
        List<UserDTO> usersResList = userService.getUsersByStatus(status);
        List<UserResponse> userResponseList = new ArrayList<>();

        for(UserDTO userDTO : usersResList ){
            userResponseList.add(DTOToResponseFactory.user(userDTO));
        }
        return userResponseList;
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON} )
    @Path("/all")
    public List<UserResponse> getAllUsers() {
        List<UserDTO> usersList = userService.getAllUsers();
        List<UserResponse> usersResList = new ArrayList<>();

        for(UserDTO user:usersList){
            usersResList.add(DTOToResponseFactory.user(user));
        }

        return usersResList;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public UserResponse getUserById(@PathParam("id") int id) {
        UserDTO user = userService.getUserById(id);
        return DTOToResponseFactory.user(user);
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON} )
    @Produces({ MediaType.APPLICATION_JSON} )
    public UserResponse save(UserRequest userRequest) {
        UserDTO savedUser = userService.save(RequestToDTOFactory.user(userRequest));
        return DTOToResponseFactory.user(savedUser);
    }

    @PUT
    @Consumes({ MediaType.APPLICATION_JSON} )
    @Produces({ MediaType.TEXT_PLAIN} )
    @Path("/{id}")
    public boolean update(@PathParam("id") Integer id, UserRequest userRequest) {
        return userService.update(id, RequestToDTOFactory.user(userRequest));
    }

    @DELETE
    @Produces({ MediaType.TEXT_PLAIN} )
    @Path("/{id}")
    public boolean delete(@PathParam("id") int id){
        return userService.delete(id);
    }
}
