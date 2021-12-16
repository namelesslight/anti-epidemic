package com.example.antiepidemic.web.city;

import com.example.antiepidemic.domain.Image;
import com.example.antiepidemic.result.Result;
import com.example.antiepidemic.service.CityService;
import com.example.antiepidemic.service.impl.CityServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "InsertCityServlet", value = "/insertCity")
public class InsertCityServlet extends HttpServlet {

    private CityService cityService = new CityServiceImpl();

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/plain;charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> read = mapper.readValue(req.getReader(),Map.class);
        String name = (String)read.get("name");
        String story = (String) read.get("story");
        Integer  image = (Integer) read.get("image");
        Integer inputer = (Integer) read.get("inputer");
        Boolean result = cityService.insertCity(name, story, Long.valueOf(image),Long.valueOf(inputer));
        mapper.writeValue(resp.getWriter(),new Result("200",result,"/insertCity"));
    }
}
