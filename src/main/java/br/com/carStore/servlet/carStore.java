package br.com.carStore.servlet;

import br.com.carStore.dao.CarDao;
import br.com.carStore.model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-car")
public class carStore extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String carName = request.getParameter("car-name");

        System.out.println(carName);

        CarDao dao = new CarDao();
        Car carro = new Car();

        carro.setName(carName);
        dao.createCar(carro);



        request.getRequestDispatcher("index.html").forward(request, response);

    }

}