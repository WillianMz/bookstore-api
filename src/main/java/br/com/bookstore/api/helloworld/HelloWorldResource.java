
package br.com.bookstore.api.helloworld;

import javax.ws.rs.Path;
import javax.ws.rs.GET;

/**
 *
 * @author Willian
 */
@Path("hello-world")
public class HelloWorldResource {
    
    @GET
    public String hello(){
        return "Hello world Web Service em Java";
    }
}
