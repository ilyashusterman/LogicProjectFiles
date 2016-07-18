package service;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import servicebeans.Coupon;
import servicebeans.CouponType;
import facade.ClientType;
import facade.CustomerFacade;

@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerService {
	private final ClientType clientType=ClientType.CUSTOMER;

	@GET
	@Path("/buy")
	public Collection<Coupon> showAllCoupons(@Context HttpServletRequest request) throws Exception {
		return ((CustomerFacade)Login.getFacade(request,this.clientType)).showAllCoupons();
	}

	@GET
	@Path("/coupons/{couponId}")
	public void purchaseCoupon(@Context HttpServletRequest request, @PathParam("couponId") long couponId) throws Exception {
		((CustomerFacade)Login.getFacade(request,this.clientType)).purchaseCoupon(couponId);
	}

	@GET
	@Path("/coupons")
	public Collection<Coupon> getAllPurchasedCoupons(@Context HttpServletRequest request) throws Exception{
		return ((CustomerFacade)Login.getFacade(request,this.clientType)).getAllPurchasedCoupons();
	}

	@GET
	@Path("/coupons/price/{price}")
	public Collection<Coupon> getAllPurchasedCouponsByPrice(@Context HttpServletRequest request,@PathParam("price")double price) throws Exception{
		return ((CustomerFacade)Login.getFacade(request,this.clientType)).getAllPurchasedCouponsByPrice(price);
	}

	@GET
	@Path("/coupons/type/{type}")
	public Collection<Coupon> getAllPurchasedCouponsByType(@Context HttpServletRequest request,@PathParam("couponType")CouponType couponType) throws Exception{
		return ((CustomerFacade)Login.getFacade(request,this.clientType)).getAllPurchasedCouponsByType(couponType);
	}

}

