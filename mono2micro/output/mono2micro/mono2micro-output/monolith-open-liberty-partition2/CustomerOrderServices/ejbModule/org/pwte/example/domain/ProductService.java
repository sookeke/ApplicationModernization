package org.pwte.example.domain;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

import com.ibm.cardinal.util.CardinalException;
import com.ibm.cardinal.util.CardinalLogger;
import com.ibm.cardinal.util.CardinalString;
import com.ibm.cardinal.util.ClusterObjectManager;
import com.ibm.cardinal.util.SerializationUtil;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;

/**
 * Service class for Product - Generated by Cardinal
 */

@Path("/ProductService")
public class ProductService {
    private static final Logger klu__logger = CardinalLogger.getLogger(ProductService.class);




    // health check service
    @GET 
    @Path("/health") 
    @Produces(MediaType.TEXT_HTML) 
    public String getHealth() { 
        klu__logger.info("[Product] getHealth() called");
        return "ProductService::Health OK"; 
    }



    // service for incrementing object reference count
    @POST
    @Path("/incObjectCount")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void incObjectCount(@FormParam("klu__referenceID") String klu__referenceID) {
        klu__logger.info("[ProductService] incObjectCount() called with ref: "+klu__referenceID);
        ClusterObjectManager.incObjectCount(klu__referenceID);
    }



    // service for decrementing object reference count
    @POST
    @Path("/decObjectCount")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void decObjectCount(@FormParam("klu__referenceID") String klu__referenceID) {
        klu__logger.info("[Product] decObjectCount() called with ref: "+klu__referenceID);
        ClusterObjectManager.decObjectCount(klu__referenceID);
    }



    // getter service for field "productId" (generated)
    @GET 
    @Path("/get__productId")
    @Produces(MediaType.APPLICATION_JSON) 
    public Response get__productId(
        @FormParam("klu__referenceID") String klu__referenceID,
        @Context HttpServletResponse servletResponse
    ) {
        int response;
        Product instProduct = (Product)ClusterObjectManager.getObject(klu__referenceID);
        response = instProduct.productId;
        JsonObjectBuilder jsonresp = Json.createObjectBuilder();
        JsonObject jsonobj = jsonresp.add("return_value", String.valueOf(response)).build();
        klu__logger.info("[Product] Returning JSON object: "+jsonobj.toString());
        return Response
            .status(Response.Status.OK)
            .entity(jsonobj)
            .build();
    }



    // setter service for field "productId" (generated)
    @POST
    @Path("/set__productId")
    public void set__productId(
        @FormParam("klu__referenceID") String klu__referenceID,
        @FormParam("productId") String productId,
        @Context HttpServletResponse servletResponse
    ) {
        int productId_fpar = Integer.parseInt(productId);
        Product instProduct = (Product)ClusterObjectManager.getObject(klu__referenceID);
        instProduct.productId = productId_fpar;
    }
    // getter service for field "name" (generated)
    @GET 
    @Path("/get__name")
    @Produces(MediaType.APPLICATION_JSON) 
    public Response get__name(
        @FormParam("klu__referenceID") String klu__referenceID,
        @Context HttpServletResponse servletResponse
    ) {
        String response;
        Product instProduct = (Product)ClusterObjectManager.getObject(klu__referenceID);
        response = instProduct.name;
        JsonObjectBuilder jsonresp = Json.createObjectBuilder();
        JsonObject jsonobj = jsonresp.add("return_value", response).build();
        klu__logger.info("[Product] Returning JSON object: "+jsonobj.toString());
        return Response
            .status(Response.Status.OK)
            .entity(jsonobj)
            .build();
    }



    // setter service for field "name" (generated)
    @POST
    @Path("/set__name")
    public void set__name(
        @FormParam("klu__referenceID") String klu__referenceID,
        @FormParam("name") String name,
        @Context HttpServletResponse servletResponse
    ) {
        String name_fpar = name;
        Product instProduct = (Product)ClusterObjectManager.getObject(klu__referenceID);
        instProduct.name = name_fpar;
    }
    // getter service for field "price" (generated)
    @GET 
    @Path("/get__price")
    @Produces(MediaType.APPLICATION_JSON) 
    public Response get__price(
        @FormParam("klu__referenceID") String klu__referenceID,
        @Context HttpServletResponse servletResponse
    ) {
        BigDecimal response;
        Product instProduct = (Product)ClusterObjectManager.getObject(klu__referenceID);
        response = instProduct.price;
        JsonObjectBuilder jsonresp = Json.createObjectBuilder();
        
        // convert physical/proxy object(s) referenced by "response" to reference ID(s)
        String response_obj = SerializationUtil.encodeWithDynamicTypeCheck(response);
        JsonObject jsonobj = jsonresp.add("return_value", response_obj).build();


        klu__logger.info("[Product] Returning JSON object: "+jsonobj.toString());
        return Response
            .status(Response.Status.OK)
            .entity(jsonobj)
            .build();
    }



    // setter service for field "price" (generated)
    @POST
    @Path("/set__price")
    public void set__price(
        @FormParam("klu__referenceID") String klu__referenceID,
        @FormParam("price") String price,
        @Context HttpServletResponse servletResponse
    ) {
        
        // convert reference ID(s) stored in "price" to physical/proxy object(s)
        BigDecimal price_fpar = (BigDecimal)SerializationUtil.decodeWithDynamicTypeCheck(price);

        Product instProduct = (Product)ClusterObjectManager.getObject(klu__referenceID);
        instProduct.price = price_fpar;
    }
    // getter service for field "description" (generated)
    @GET 
    @Path("/get__description")
    @Produces(MediaType.APPLICATION_JSON) 
    public Response get__description(
        @FormParam("klu__referenceID") String klu__referenceID,
        @Context HttpServletResponse servletResponse
    ) {
        String response;
        Product instProduct = (Product)ClusterObjectManager.getObject(klu__referenceID);
        response = instProduct.description;
        JsonObjectBuilder jsonresp = Json.createObjectBuilder();
        JsonObject jsonobj = jsonresp.add("return_value", response).build();
        klu__logger.info("[Product] Returning JSON object: "+jsonobj.toString());
        return Response
            .status(Response.Status.OK)
            .entity(jsonobj)
            .build();
    }



    // setter service for field "description" (generated)
    @POST
    @Path("/set__description")
    public void set__description(
        @FormParam("klu__referenceID") String klu__referenceID,
        @FormParam("description") String description,
        @Context HttpServletResponse servletResponse
    ) {
        String description_fpar = description;
        Product instProduct = (Product)ClusterObjectManager.getObject(klu__referenceID);
        instProduct.description = description_fpar;
    }
    // getter service for field "imagePath" (generated)
    @GET 
    @Path("/get__imagePath")
    @Produces(MediaType.APPLICATION_JSON) 
    public Response get__imagePath(
        @FormParam("klu__referenceID") String klu__referenceID,
        @Context HttpServletResponse servletResponse
    ) {
        String response;
        Product instProduct = (Product)ClusterObjectManager.getObject(klu__referenceID);
        response = instProduct.imagePath;
        JsonObjectBuilder jsonresp = Json.createObjectBuilder();
        JsonObject jsonobj = jsonresp.add("return_value", response).build();
        klu__logger.info("[Product] Returning JSON object: "+jsonobj.toString());
        return Response
            .status(Response.Status.OK)
            .entity(jsonobj)
            .build();
    }



    // setter service for field "imagePath" (generated)
    @POST
    @Path("/set__imagePath")
    public void set__imagePath(
        @FormParam("klu__referenceID") String klu__referenceID,
        @FormParam("imagePath") String imagePath,
        @Context HttpServletResponse servletResponse
    ) {
        String imagePath_fpar = imagePath;
        Product instProduct = (Product)ClusterObjectManager.getObject(klu__referenceID);
        instProduct.imagePath = imagePath_fpar;
    }
    // getter service for field "categories" (generated)
    @GET 
    @Path("/get__categories")
    @Produces(MediaType.APPLICATION_JSON) 
    public Response get__categories(
        @FormParam("klu__referenceID") String klu__referenceID,
        @Context HttpServletResponse servletResponse
    ) {
        Collection<Category> response;
        Product instProduct = (Product)ClusterObjectManager.getObject(klu__referenceID);
        response = instProduct.categories;
        JsonObjectBuilder jsonresp = Json.createObjectBuilder();
        
        // convert physical/proxy object(s) referenced by "response" to reference ID(s)
        String response_obj = SerializationUtil.encodeWithDynamicTypeCheck(response);
        JsonObject jsonobj = jsonresp.add("return_value", response_obj).build();


        klu__logger.info("[Product] Returning JSON object: "+jsonobj.toString());
        return Response
            .status(Response.Status.OK)
            .entity(jsonobj)
            .build();
    }



    // setter service for field "categories" (generated)
    @POST
    @Path("/set__categories")
    public void set__categories(
        @FormParam("klu__referenceID") String klu__referenceID,
        @FormParam("categories") String categories,
        @Context HttpServletResponse servletResponse
    ) {
        
        // convert reference ID(s) stored in "categories" to physical/proxy object(s)
        Collection<Category> categories_fpar = (Collection<Category>)SerializationUtil.decodeWithDynamicTypeCheck(categories);

        Product instProduct = (Product)ClusterObjectManager.getObject(klu__referenceID);
        instProduct.categories = categories_fpar;
    }


    @POST
    @Path("/Product")
    @Produces(MediaType.APPLICATION_JSON)
    public Response Product(
        @Context HttpServletResponse servletResponse
    ) {

        // call constructor, add created object to cluster object manager, and return ref ID
        Product instProduct;
        try {
            instProduct = new Product();
        }
        catch (java.lang.Throwable t) {
            String msg = "Call to constructor Product() raised exception: "+t.getMessage();
            klu__logger.warning(msg);
            throw new WebApplicationException(msg, t, CardinalException.APPLICATION_EXCEPTION);
        }
        String refid = ClusterObjectManager.putObject(instProduct);
        instProduct.setKlu__referenceID(refid);
        JsonObject jsonobj = Json
            .createObjectBuilder()
            .add("return_value", refid)
            .build();
        return Response
            .status(Response.Status.OK)
            .entity(jsonobj)
            .build();
    }

    @POST
    @Path("/getCategories")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategories(
        @FormParam("klu__referenceID") String klu__referenceID,
        @Context HttpServletResponse servletResponse
    ) {

        Collection<Category> response;

        // dynamically dispatched method: using reference ID, get object from cluster object manager and
        // call method on the object
        Product instProduct = (Product)ClusterObjectManager.getObject(klu__referenceID);

        try {
            response = instProduct.getCategories();
        }
        catch (java.lang.Throwable t) {
            String msg = "Call to method getCategories() of Product raised exception: "+t.getMessage();
            klu__logger.warning(msg);
            throw new WebApplicationException(msg, t, CardinalException.APPLICATION_EXCEPTION);
        }
        JsonObjectBuilder jsonresp = Json.createObjectBuilder();
        
        // convert physical/proxy object(s) referenced by "response" to reference ID(s)
        String response_obj = SerializationUtil.encodeWithDynamicTypeCheck(response);
        JsonObject jsonobj = jsonresp.add("return_value", response_obj).build();

        klu__logger.info("[Product] Returning JSON object: "+jsonobj.toString());
        return Response
            .status(Response.Status.OK)
            .entity(jsonobj)
            .build();

    }

    @POST
    @Path("/setCategories")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void setCategories(
        @FormParam("klu__referenceID") String klu__referenceID,
        @FormParam("categories") String categories,
        @Context HttpServletResponse servletResponse
    ) {

        
        // convert reference ID(s) stored in "categories" to physical/proxy object(s)
        Collection<Category> categories_fpar = (Collection<Category>)SerializationUtil.decodeWithDynamicTypeCheck(categories);

        // dynamically dispatched method: using reference ID, get object from cluster object manager and
        // call method on the object
        Product instProduct = (Product)ClusterObjectManager.getObject(klu__referenceID);

        try {
            instProduct.setCategories(categories_fpar);
        }
        catch (java.lang.Throwable t) {
            String msg = "Call to method setCategories() of Product raised exception: "+t.getMessage();
            klu__logger.warning(msg);
            throw new WebApplicationException(msg, t, CardinalException.APPLICATION_EXCEPTION);
        }

    }

    @POST
    @Path("/getProductId")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductId(
        @FormParam("klu__referenceID") String klu__referenceID,
        @Context HttpServletResponse servletResponse
    ) {

        int response;

        // dynamically dispatched method: using reference ID, get object from cluster object manager and
        // call method on the object
        Product instProduct = (Product)ClusterObjectManager.getObject(klu__referenceID);

        try {
            response = instProduct.getProductId();
        }
        catch (java.lang.Throwable t) {
            String msg = "Call to method getProductId() of Product raised exception: "+t.getMessage();
            klu__logger.warning(msg);
            throw new WebApplicationException(msg, t, CardinalException.APPLICATION_EXCEPTION);
        }
        JsonObjectBuilder jsonresp = Json.createObjectBuilder();
        JsonObject jsonobj = jsonresp.add("return_value", String.valueOf(response)).build();
        klu__logger.info("[Product] Returning JSON object: "+jsonobj.toString());
        return Response
            .status(Response.Status.OK)
            .entity(jsonobj)
            .build();

    }

    @POST
    @Path("/setProductId")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void setProductId(
        @FormParam("klu__referenceID") String klu__referenceID,
        @FormParam("productId") String productId,
        @Context HttpServletResponse servletResponse
    ) {

        int productId_fpar = Integer.parseInt(productId);

        // dynamically dispatched method: using reference ID, get object from cluster object manager and
        // call method on the object
        Product instProduct = (Product)ClusterObjectManager.getObject(klu__referenceID);

        try {
            instProduct.setProductId(productId_fpar);
        }
        catch (java.lang.Throwable t) {
            String msg = "Call to method setProductId() of Product raised exception: "+t.getMessage();
            klu__logger.warning(msg);
            throw new WebApplicationException(msg, t, CardinalException.APPLICATION_EXCEPTION);
        }

    }

    @POST
    @Path("/getName")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getName(
        @FormParam("klu__referenceID") String klu__referenceID,
        @Context HttpServletResponse servletResponse
    ) {

        String response;

        // dynamically dispatched method: using reference ID, get object from cluster object manager and
        // call method on the object
        Product instProduct = (Product)ClusterObjectManager.getObject(klu__referenceID);

        try {
            response = instProduct.getName();
        }
        catch (java.lang.Throwable t) {
            String msg = "Call to method getName() of Product raised exception: "+t.getMessage();
            klu__logger.warning(msg);
            throw new WebApplicationException(msg, t, CardinalException.APPLICATION_EXCEPTION);
        }
        JsonObjectBuilder jsonresp = Json.createObjectBuilder();
        JsonObject jsonobj = jsonresp.add("return_value", response).build();
        klu__logger.info("[Product] Returning JSON object: "+jsonobj.toString());
        return Response
            .status(Response.Status.OK)
            .entity(jsonobj)
            .build();

    }

    @POST
    @Path("/setName")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void setName(
        @FormParam("klu__referenceID") String klu__referenceID,
        @FormParam("name") String name,
        @Context HttpServletResponse servletResponse
    ) {

        String name_fpar = name;

        // dynamically dispatched method: using reference ID, get object from cluster object manager and
        // call method on the object
        Product instProduct = (Product)ClusterObjectManager.getObject(klu__referenceID);

        try {
            instProduct.setName(name_fpar);
        }
        catch (java.lang.Throwable t) {
            String msg = "Call to method setName() of Product raised exception: "+t.getMessage();
            klu__logger.warning(msg);
            throw new WebApplicationException(msg, t, CardinalException.APPLICATION_EXCEPTION);
        }

    }

    @POST
    @Path("/getPrice")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPrice(
        @FormParam("klu__referenceID") String klu__referenceID,
        @Context HttpServletResponse servletResponse
    ) {

        BigDecimal response;

        // dynamically dispatched method: using reference ID, get object from cluster object manager and
        // call method on the object
        Product instProduct = (Product)ClusterObjectManager.getObject(klu__referenceID);

        try {
            response = instProduct.getPrice();
        }
        catch (java.lang.Throwable t) {
            String msg = "Call to method getPrice() of Product raised exception: "+t.getMessage();
            klu__logger.warning(msg);
            throw new WebApplicationException(msg, t, CardinalException.APPLICATION_EXCEPTION);
        }
        JsonObjectBuilder jsonresp = Json.createObjectBuilder();
        
        // convert physical/proxy object(s) referenced by "response" to reference ID(s)
        String response_obj = SerializationUtil.encodeWithDynamicTypeCheck(response);
        JsonObject jsonobj = jsonresp.add("return_value", response_obj).build();

        klu__logger.info("[Product] Returning JSON object: "+jsonobj.toString());
        return Response
            .status(Response.Status.OK)
            .entity(jsonobj)
            .build();

    }

    @POST
    @Path("/setPrice")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void setPrice(
        @FormParam("klu__referenceID") String klu__referenceID,
        @FormParam("price") String price,
        @Context HttpServletResponse servletResponse
    ) {

        
        // convert reference ID(s) stored in "price" to physical/proxy object(s)
        BigDecimal price_fpar = (BigDecimal)SerializationUtil.decodeWithDynamicTypeCheck(price);

        // dynamically dispatched method: using reference ID, get object from cluster object manager and
        // call method on the object
        Product instProduct = (Product)ClusterObjectManager.getObject(klu__referenceID);

        try {
            instProduct.setPrice(price_fpar);
        }
        catch (java.lang.Throwable t) {
            String msg = "Call to method setPrice() of Product raised exception: "+t.getMessage();
            klu__logger.warning(msg);
            throw new WebApplicationException(msg, t, CardinalException.APPLICATION_EXCEPTION);
        }

    }

    @POST
    @Path("/getDescription")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDescription(
        @FormParam("klu__referenceID") String klu__referenceID,
        @Context HttpServletResponse servletResponse
    ) {

        String response;

        // dynamically dispatched method: using reference ID, get object from cluster object manager and
        // call method on the object
        Product instProduct = (Product)ClusterObjectManager.getObject(klu__referenceID);

        try {
            response = instProduct.getDescription();
        }
        catch (java.lang.Throwable t) {
            String msg = "Call to method getDescription() of Product raised exception: "+t.getMessage();
            klu__logger.warning(msg);
            throw new WebApplicationException(msg, t, CardinalException.APPLICATION_EXCEPTION);
        }
        JsonObjectBuilder jsonresp = Json.createObjectBuilder();
        JsonObject jsonobj = jsonresp.add("return_value", response).build();
        klu__logger.info("[Product] Returning JSON object: "+jsonobj.toString());
        return Response
            .status(Response.Status.OK)
            .entity(jsonobj)
            .build();

    }

    @POST
    @Path("/setDescription")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void setDescription(
        @FormParam("klu__referenceID") String klu__referenceID,
        @FormParam("description") String description,
        @Context HttpServletResponse servletResponse
    ) {

        String description_fpar = description;

        // dynamically dispatched method: using reference ID, get object from cluster object manager and
        // call method on the object
        Product instProduct = (Product)ClusterObjectManager.getObject(klu__referenceID);

        try {
            instProduct.setDescription(description_fpar);
        }
        catch (java.lang.Throwable t) {
            String msg = "Call to method setDescription() of Product raised exception: "+t.getMessage();
            klu__logger.warning(msg);
            throw new WebApplicationException(msg, t, CardinalException.APPLICATION_EXCEPTION);
        }

    }

    @POST
    @Path("/getImagePath")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getImagePath(
        @FormParam("klu__referenceID") String klu__referenceID,
        @Context HttpServletResponse servletResponse
    ) {

        String response;

        // dynamically dispatched method: using reference ID, get object from cluster object manager and
        // call method on the object
        Product instProduct = (Product)ClusterObjectManager.getObject(klu__referenceID);

        try {
            response = instProduct.getImagePath();
        }
        catch (java.lang.Throwable t) {
            String msg = "Call to method getImagePath() of Product raised exception: "+t.getMessage();
            klu__logger.warning(msg);
            throw new WebApplicationException(msg, t, CardinalException.APPLICATION_EXCEPTION);
        }
        JsonObjectBuilder jsonresp = Json.createObjectBuilder();
        JsonObject jsonobj = jsonresp.add("return_value", response).build();
        klu__logger.info("[Product] Returning JSON object: "+jsonobj.toString());
        return Response
            .status(Response.Status.OK)
            .entity(jsonobj)
            .build();

    }

    @POST
    @Path("/setImagePath")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void setImagePath(
        @FormParam("klu__referenceID") String klu__referenceID,
        @FormParam("imagePath") String imagePath,
        @Context HttpServletResponse servletResponse
    ) {

        String imagePath_fpar = imagePath;

        // dynamically dispatched method: using reference ID, get object from cluster object manager and
        // call method on the object
        Product instProduct = (Product)ClusterObjectManager.getObject(klu__referenceID);

        try {
            instProduct.setImagePath(imagePath_fpar);
        }
        catch (java.lang.Throwable t) {
            String msg = "Call to method setImagePath() of Product raised exception: "+t.getMessage();
            klu__logger.warning(msg);
            throw new WebApplicationException(msg, t, CardinalException.APPLICATION_EXCEPTION);
        }

    }

}