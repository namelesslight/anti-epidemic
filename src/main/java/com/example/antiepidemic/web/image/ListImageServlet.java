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
import java.util.List;
import java.util.Map;

@WebServlet(name = "ListImageServlet", value = "/listImage")
public class ListImageServlet extends HttpServlet {

    ImageService imageService = new ImageServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/plain;charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        List<Image> result = imageService.listAllImage();
        mapper.writeValue(response.getWriter(),new Result("200",result,"/listImage"));
    }
}
