package br.com.carStore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.carStore.model.User;

public class UserDao {

    public boolean verifyCredentials(User user) {
        String SQL = "SELECT * FROM USR WHERE USERNAME = ?";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, user.getUsername());
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Sucesso em logar");

            while(resultSet.next()) {
                String password = resultSet.getString("password");

                if(password.equals(user.getPassword())) {
                    return true;
                }
            }
            connection.close();
            return false;

        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());

            return false;
        }
    }
}
