/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.services;

import com.spas.model.Assessment;
import com.spas.model.Mark;
import com.spas.model.Subject;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 *
 * @author Z
 */
@WebService
public interface MobileService {
    
    @WebMethod
    @GET
    @Path("/authenticate{username}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public String authenticateStudent(@WebParam(name = "username") String username, @WebParam(name = "password") String password);

    @WebMethod
    @GET
    @Path("/sayhello")
    @Produces(MediaType.APPLICATION_JSON)
    public String sayHello();

    @WebMethod
    @GET
    @Path("/getSubjects{sessionID1}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Subject> getSubjects(@WebParam(name = "sessionID") String sessionID);



    @WebMethod
    @GET
    @Path("/getAssessment{sessionID2}/{subjectCode}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Assessment> getAssessment(@WebParam(name = "sessionID2") String sessionID, @WebParam(name = "subjectCode") String subjectCode);

    @WebMethod
    @GET
    @Path("/getMarks{sessionID3}/{assessmentID}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Mark> getMarks(@WebParam(name = "sessionID3") String sessionID, @WebParam(name = "sessionID") Long assessmentID);

    @WebMethod
    @GET
    @Path("/logout{sessionID4}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean logout(@WebParam(name = "sessionID4") String sessionID);

    @WebMethod
    @GET
    @Path("/isLoggedIn{sessionID5}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean isLoggedIn(@WebParam(name = "sessionID5") String sessionID);
}
