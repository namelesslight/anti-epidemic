package com.example.antiepidemic.web.city;

import com.example.antiepidemic.domain.City;
import com.example.antiepidemic.result.Result;
import com.example.antiepidemic.service.CityService;
import com.example.antiepidemic.service.impl.CityServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "QueryOneCityServlet", value = "/queryOneCity")
public class QueryOneCityServlet extends HttpServlet {

    private CityService cityService = new CityServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/plain;charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        String id = (String) request.getParameter("id");
        City result = cityService.queryOneCity(Long.valueOf(id));
        mapper.writeValue(response.getWriter(),new Result("200",result,"/queryOneCity"));
    }
}
