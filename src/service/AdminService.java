package service;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import facade.AdminFacade;
import facade.ClientType;
import servicebeans.Company;
import servicebeans.Customer;

@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AdminService{
	private final ClientType clientType=ClientType.ADMIN;
	@POST
	@Path("/customers/customer")
	public void creatCustomer(@Context HttpServletRequest request,Customer customer) throws Exception {
		((AdminFacade)Login.getFacade(request,this.clientType)).creatCustomer(customer);
	}

    @DELETE
	@Path("/customers/{customerId}")
	public void removeCustomer(@Context HttpServletRequest request,@PathParam("customerId") long customerId) throws Exception {
    	((AdminFacade)Login.getFacade(request,this.clientType)).removeCustomer(customerId);
	}
	
	@PUT
	@Path("/customers/{customerId}")
	public void updateCustomer(@Context HttpServletRequest request, Customer customer,@PathParam("customerId") long customerId) throws Exception {
		((AdminFacade)Login.getFacade(request,this.clientType)).updateCustomer(customerId,customer.getPassword());
	}
	
	@GET
	@Path("/customers/{customerId}")
	public Customer getCustomer(@Context HttpServletRequest request, @PathParam("customerId") long customerId) throws Exception {
		return ((AdminFacade)Login.getFacade(request,this.clientType)).getCustomer(customerId);
	}
	
	@GET
	@Path("/customers")
	public Collection<Customer> getAllCustomer(@Context HttpServletRequest request) throws Exception {
		return ((AdminFacade)Login.getFacade(request,this.clientType)).getAllCustomer();
	}
	
	@POST
	@Path("/companies")
	public void creatCompany(@Context HttpServletRequest request,Company company) throws Exception  {
		((AdminFacade)Login.getFacade(request,this.clientType)).creatCompany(company);
	}
	
    @DELETE
	@Path("/companies/{companyId}")
	public void removeCompany(@Context HttpServletRequest request, @PathParam("companyId") long companyId) throws Exception {
    	((AdminFacade)Login.getFacade(request,this.clientType)).removeCompany(companyId);
	}
    @PUT
	@Path("/companies/{companyId}")
	public void updateCompany(@Context HttpServletRequest request,Company company,@PathParam("companyId") long companyId) throws Exception {
		((AdminFacade)Login.getFacade(request,this.clientType)).updateCompany(companyId,company.getPassword(),company.getEmail());
	}
	
   @GET
	@Path("/companies/{companyId}")
	public Company getCompany(@Context HttpServletRequest request,@PathParam("companyId") long companyId) throws Exception{
		return ((AdminFacade)Login.getFacade(request,this.clientType)).getCompany(companyId);
	}
	@GET
	@Path("/companies")
	public Collection<Company> getAllCompanies(@Context HttpServletRequest request) throws Exception {
		return ((AdminFacade)Login.getFacade(request,this.clientType)).getAllCompanies();
	}
	


}

