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
import java.util.List;

@WebServlet(name = "ListCityServlet", value = "/listCity")
public class ListCityServlet extends HttpServlet {

    private CityService cityService = new CityServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/plain;charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        List<City> cityList = cityService.listCities();
        mapper.writeValue(response.getWriter(),new Result("200",cityList,"/listCity"));
    }
}
