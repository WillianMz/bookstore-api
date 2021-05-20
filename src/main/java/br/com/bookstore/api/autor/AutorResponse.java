
package br.com.bookstore.api.autor;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.WebApplicationException;
import static javax.ws.rs.core.Response.Status;

/**
 *
 * @author Willian
 */
@Path("/autores")
public class AutorResponse {
    
    static List<Autor> autores = new ArrayList<>(
        Arrays.asList(
            new Autor(1, "David Cockford", LocalDate.of(1959, Month.MARCH, 1), Genero.MASCULINO),
            new Autor(2, "JK Rowling", LocalDate.of(1953, Month.MARCH, 1), Genero.FEMININO)
        )
    );

    public AutorResponse() {

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Autor> getAutores() {
        return autores;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Autor getAutor(@PathParam("id") int id) {
        Autor autor = autores
                .stream()
                .filter(a -> id == a.getId())
                .findFirst()
                .orElse(null);

        if (autor == null) {
            throw new WebApplicationException("Autor não encontrado", Status.NOT_FOUND);
        }

        return autor;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Autor addAutor(Autor autor) {
        int ultimoId = autores.get(autores.size()-1).getId();
        autor.setId(++ultimoId);
        autores.add(autor);
        return autor;
    }
    
}
