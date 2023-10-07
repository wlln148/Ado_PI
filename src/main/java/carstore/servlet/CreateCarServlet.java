package carstore.servlet;

import carstore.dao.CarDao;
import carstore.model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-car")
public class CreateCarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String carName = request.getParameter("car-name");

        System.out.println(carName);

        CarDao dao = new CarDao();
        Car carro = new Car(carName);


        dao.createCar(carro);

        response.sendRedirect("/find-all-cars");
    }
}
