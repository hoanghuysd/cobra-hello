package org.cobra.web.error.exceptionresolve;

import org.cobra.web.error.exception.CbIOFileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Hoang Huy on 11/5/2017.
 */
//@Component
public class RestResponseStatusExceptionResolver/* extends AbstractHandlerExceptionResolver */{
    private static final Logger LOGGER = LoggerFactory.getLogger(RestResponseStatusExceptionResolver.class);
   // @Override
    protected ModelAndView doResolveException
            (HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        try {
            if (ex instanceof CbIOFileException) {
                return handleIllegalArgument(request, response, handler, (CbIOFileException) ex);
            }
        } catch (Exception handlerException) {
            return null;
        }
        return new ModelAndView();
    }

    private ModelAndView handleIllegalArgument
            (HttpServletRequest request, HttpServletResponse response, Object handler, CbIOFileException ex) throws IOException {
        response.sendError(HttpServletResponse.SC_CONFLICT);
        String accept = request.getHeader(HttpHeaders.ACCEPT);
        return new ModelAndView();
    }
}
