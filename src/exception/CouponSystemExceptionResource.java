/**
 * 
 */
package exception;

/**
 * @author ilya shusterman
 *
 */
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import exceptions.ErrorType;
 
@Provider
public class CouponSystemExceptionResource extends Exception implements
                ExceptionMapper<CouponSystemExceptionResource> 
{
    private static final long serialVersionUID = 1L;
 
    public CouponSystemExceptionResource() {
        super("Unknown error!");
    }
 
    public CouponSystemExceptionResource(String string) {
        super(string);
    }
    public CouponSystemExceptionResource(ErrorTypeResource errorType,Throwable e) {
        super(errorType.toString(),e);
    }
    public CouponSystemExceptionResource(ErrorType errorType,Throwable e) {
        super(errorType.toString(),e);
    }
 
    @Override
    public Response toResponse(CouponSystemExceptionResource exception) 
    {
        return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage())
                                    .type("text/plain").build();
    }
}