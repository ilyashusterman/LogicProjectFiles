package tests;

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
import exceptions.DAOException;
import service.Login;
import servicebeans.Company;
import servicebeans.Coupon;
import servicebeans.Customer;

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TestJson{
	
	@GET
	@Path("/companies")
	public Collection<Company>getAllCompanies(@Context HttpServletRequest req) throws Exception{
	return Login.couponSys.companyDAO.getAllCompanies();
	}

	@POST
	@Path("/customers")
	public void creatCustomer(Customer customer) throws DAOException {
		Login.couponSys.customerDAO.creatCustomer(customer);
	}

	@DELETE
	@Path("/customers/{customerId}")
	public void removeCustomer(@PathParam("customerId")long customerId) throws DAOException {
		Login.couponSys.customerDAO.removeCustomer(customerId);
	}

	@PUT
	@Path("/customers/{customerId}/{password}")
	public void updateCustomer(long customerId, String password) throws DAOException {
		Login.couponSys.customerDAO.updateCustomer(customerId, password);
	}
	
	@PUT
	@Path("/customers/{customerId}")
	public Customer updateCustomer(Customer customer) throws Exception {
		Login.couponSys.customerDAO.updateCustomer(customer.getId(), customer.getPassword());
		return Login.couponSys.customerDAO.getCustomer(customer.getId());
	}

	@GET
	@Path("/customers/{customerId}")
	public Customer getCustomer(@PathParam("customerId")long customerId) throws DAOException {
		 return Login.couponSys.customerDAO.getCustomer(customerId);
	}

	@GET
	@Path("/customers/{name}/{password}")
	public Customer getCustomerByNamePassword(@PathParam("name")String name,@PathParam("password") String password) throws DAOException {
		 return Login.couponSys.customerDAO.getCustomerByNamePassword(name, password);
	}

	@GET
	@Path("/customers")
	public Collection<Customer> getAllCustomers() throws DAOException {
		return Login.couponSys.customerDAO.getAllCustomers();
	}

	@GET
	@Path("/coupons/{couponId}")
	public Coupon getCoupon(@PathParam("couponId")long id) throws DAOException {
		return Login.couponSys.couponDAO.getCoupon(id);
	}

	@GET
	@Path("/coupons")
	public Collection<Coupon> getAllCoupon() throws DAOException {
		return Login.couponSys.couponDAO.getAllCoupon();
	}

	@POST
	@Path("/companies")
	public void creatCompany(Company company) throws DAOException {
		Login.couponSys.companyDAO.creatCompany(company);
	}
	
	@POST
	@Path("/coupons")
	public void creatCoupon(Coupon coupon) throws DAOException {
		Login.couponSys.couponDAO.creatCoupon(coupon);;
	}

	@DELETE
	@Path("/companies/{companyId}")
	public void removeCompany(@PathParam("companyId")long companyId) throws DAOException {
		Login.couponSys.companyDAO.removeCompany(companyId);
	}

	@PUT
	@Path("/companies")
	public void updateCompany(Company company) throws DAOException {
		Login.couponSys.companyDAO.updateCompany(company.getId(), company.getPassword(), company.getEmail());;
	}

	@GET
	@Path("/companies/{companyId}")
	public Company getCompany(@PathParam("companyId")long companyId) throws DAOException {

		return Login.couponSys.companyDAO.getCompany(companyId);
	}


}