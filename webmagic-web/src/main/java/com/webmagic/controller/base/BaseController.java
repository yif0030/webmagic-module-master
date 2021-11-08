package com.webmagic.controller.base;

import com.dfgg.util.Constants;
import com.webmagic.model.User;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract class BaseController {

    protected static final String RESULT = "result";
    protected static final String SUCCESS = "success";
    protected static final String FAILED = "failed";
    protected static final String ENTITY = "entity";
    protected static final String LIST = "list";

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;

    @ModelAttribute
    private void setRequestAndResponse(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.session = request.getSession();
    }

    protected HttpSession getSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return session;
    }

    protected User getSessionUser() {
        Object session = request.getSession().getAttribute(Constants.SESSION_USER_ID);
        return session == null ? null : (User) session;
    }
}
