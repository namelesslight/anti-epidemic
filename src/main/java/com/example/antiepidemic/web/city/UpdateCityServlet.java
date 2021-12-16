package com.example.antiepidemic.web.city;

import com.example.antiepidemic.result.Result;
import com.example.antiepidemic.service.CityService;
import com.example.antiepidemic.service.impl.CityServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "UpdateCityServlet", value = "/updateCity")
public class UpdateCityServlet extends HttpServlet {

    private CityService cityService = new CityServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/plain;charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> read = mapper.readValue(request.getReader(),Map.class);
        Integer id = (Integer) read.get("id");
        String name = (String)read.get("name");
        String story = (String) read.get("story");
        Integer image = (Integer) read.get("image");
        Boolean result = cityService.updateCity(Long.valueOf(id),name,story,Long.valueOf(image));
        mapper.writeValue(response.getWriter(),new Result("200",result,"/updateCity"));
    }
}
