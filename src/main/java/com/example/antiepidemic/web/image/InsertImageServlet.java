package com.example.antiepidemic.web.image;

import com.example.antiepidemic.result.Result;
import com.example.antiepidemic.service.ImageService;
import com.example.antiepidemic.service.impl.ImageServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "InsertImageServlet", value = "/insertImage")
public class InsertImageServlet extends HttpServlet {

    private ImageService imageService = new ImageServiceImpl();

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/plain;charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> read = mapper.readValue(request.getReader(), Map.class);
        String name = (String)read.get("name");
        String path = (String) read.get("path");
        Integer inputer = (Integer) read.get("inputer");
        Boolean result = imageService.insertImage(name, path, Long.valueOf(inputer));
        mapper.writeValue(response.getWriter(),new Result("200",result,"/insertImage"));
    }
}
