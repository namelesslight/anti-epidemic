package com.example.antiepidemic.web.image;

import com.example.antiepidemic.domain.Image;
import com.example.antiepidemic.result.Result;
import com.example.antiepidemic.service.ImageService;
import com.example.antiepidemic.service.impl.ImageServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "QueryImageServlet", value = "/queryImage")
public class QueryImageServlet extends HttpServlet {

    private ImageService imageService = new ImageServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/plain;charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        String id = (String) request.getParameter("id");
        Image result = imageService.queryOneImage(Long.valueOf(id));
        mapper.writeValue(response.getWriter(),new Result("200",result,"/queryImage"));
    }
}
