package rest.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import daos.*;
import model.Usuario;

@Path("/usuarios")
public class UsuarioResource {
	
	@Context
	UriInfo uriInfo;
	
	@Context
	Request request;
	
	private UsuarioDAO udao = FactoryDAO.getUsuarioDAO();
	private String mensaje;
	
	private Map<String, Object> getResponseBody(Usuario usuario, boolean ok){
		// Crear la respuesta JSON con la URL del usuario creado
		Map<String, Object> aux = new HashMap<>();
		aux.put("id", usuario.getId());
		aux.put("nombre", usuario.getNombre());
	    aux.put("apellido", usuario.getApellido());
	    aux.put("email", usuario.getEmail());
	    if(ok)
	    	aux.put("url", uriInfo.getAbsolutePathBuilder().path(String.valueOf(usuario.getId())).build());
	    else
	    	aux.put("url", uriInfo.getAbsolutePathBuilder().build());
	    return aux;
	}
	


	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsuarios(){
		List<Usuario> usuarios = udao.getAll();
		List<Map<String,Object>> usuariosResponse = new ArrayList<>();
		for(Usuario usr: usuarios)
			if(usr.isActivo())
				usuariosResponse.add(this.getResponseBody(usr, true));
		return Response.ok(usuariosResponse).build();
		
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response encontrar(@PathParam("id") Long id){
		Usuario usu = udao.read(id);
		if (usu != null && usu.isActivo()){
			Map<String, Object> responseBody = this.getResponseBody(usu,false);
			return Response
					.ok()
					.entity(responseBody)
					.build();
		} else {
			mensaje="No se encontró el usuario";
			return Response
					.status(Response.Status.NOT_FOUND)
					.entity(mensaje)
					.build();
		}
	}
	
	private boolean validar(Usuario usuario) {
		return usuario != null && 
				udao.readByEmail(usuario.getEmail()) == null ? true : false;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Usuario usuario){
		if(validar(usuario)){ // podría validar si ya existe el usuario
			usuario.setActivo(true);
			udao.create(usuario);
			// Construir la URI del nuevo recurso
			URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(usuario.getId())).build();
            Map<String, Object> responseBody = this.getResponseBody(usuario, true);
            return Response.created(uri)
					.entity(responseBody)
					.build();
		} else {
			return Response.status(Response.Status.CONFLICT)
					.entity("El usuario ya existe o los datos son inválidos")
					.build();
		}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editar(Usuario usuario){
		Usuario aux = udao.read(usuario.getId());
		if (aux != null){
			aux = udao.update(usuario);
			return Response.ok().entity(this.getResponseBody(aux, true)).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND)
					.entity("[]").build();
		}
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response borrar(@PathParam("id") Long id){
		Usuario aux = udao.read(id);
		if (aux != null && aux.isActivo()){
			udao.delete(aux);
			return Response
					.ok()
					.entity(this.getResponseBody(aux, false))
					.build();
		} else {
			mensaje = "No existe el usuario con ese id";
			return Response.status(Response.Status.NOT_FOUND)
				.entity(mensaje)
				.build();
		}
	}

}
