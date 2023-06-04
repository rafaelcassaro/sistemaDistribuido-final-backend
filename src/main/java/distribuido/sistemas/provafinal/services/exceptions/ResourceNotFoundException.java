package distribuido.sistemas.provafinal.services.exceptions;

// runtimeEx --> excessao que o compilador n obriga a tratar
public class ResourceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {
		super("Resource not found. Id" + id);
	}
	

}
