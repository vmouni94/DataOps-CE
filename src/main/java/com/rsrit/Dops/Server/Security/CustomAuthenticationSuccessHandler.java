package com.rsrit.Dops.Server.Security;

/**
 * @author gn.teja created on 02/23/2017
 *
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;

import com.rsrit.Dops.Server.Model.UserModel.DataOps_User;

public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	
	private RequestCache requestCache = new HttpSessionRequestCache();
	 
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, 
      Authentication authentication) throws ServletException, IOException {
  
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        System.out.println(requestCache +" success authentication->request Cache");
        System.out.println("auth successfully done!");
        
        
 
        if (savedRequest == null) {
            clearAuthenticationAttributes(request);
            return;
        }
        
        String targetUrlParam = getTargetUrlParameter();
        
        if (isAlwaysUseDefaultTargetUrl()
          || (targetUrlParam != null && StringUtils.hasText(request.getParameter(targetUrlParam)))) {
            requestCache.removeRequest(request, response);
            clearAuthenticationAttributes(request);
            return;
        }
        clearAuthenticationAttributes(request);
    }
 
    public void setRequestCache(RequestCache requestCache) {
        this.requestCache = requestCache;
    }

}
