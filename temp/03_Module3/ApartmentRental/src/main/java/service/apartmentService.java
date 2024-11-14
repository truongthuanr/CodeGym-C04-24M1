package service;

import configuration.ConnectDatabase;
import entity.Apartments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class apartmentService implements IService<Apartments> {

    private Connection connection = ConnectDatabase.getConnection();;

    private List<Apartments> apartments;


//    public void apartmentService() {
//        this.connection =
//
//    }

    private HashMap<Integer, String> getPaytypebyidtable(){
        String query = "SELECT * FROM paytype";
        HashMap<Integer, String> paytypebyid = new HashMap<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                paytypebyid.put(resultSet.getInt("id"),
                                resultSet.getString("des"));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return paytypebyid;
    }

    private HashMap<String, Integer> getIdbypaytypetable(){
        String query = "SELECT * FROM paytype";
        HashMap<String, Integer> table = new HashMap<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                table.put(resultSet.getString("des"),
                        resultSet.getInt("id"));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return table;
    }

    @Override
    public List<Apartments> getAll() {
        List<Apartments> apartments = new ArrayList<>();
        String query = "SELECT * FROM apartment;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String tel = resultSet.getString("tel");
                Date startdate = resultSet.getDate("startdate");
                String paytype = resultSet.getString("paytype");
                String note = resultSet.getString("note");
                Apartments apartment = new Apartments(id,name,tel,startdate,paytype,note);
                apartments.add(apartment);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return apartments;
    }

    @Override

    public void add(Apartments apartment) {
        String query = "insert INTO apartment (name, tel, startdate, paytype, note) values(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, apartment.getName());
            preparedStatement.setString(2, apartment.getTel());
            preparedStatement.setDate(3, new java.sql.Date(apartment.getStartdate().getTime()));
//            int paytype = Integer.parseInt(getIdbypaytypetable().get(apartment.getPaytype()));
//            System.out.println(apartment.getPaytype());
//            System.out.println(getIdbypaytypetable().get(apartment.getPaytype()));
            preparedStatement.setInt(4, getIdbypaytypetable().get(apartment.getPaytype()));
            preparedStatement.setString(5, apartment.getNote());

            preparedStatement.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void update(int id, Apartments apartment) {

    }

    @Override
    public void delete(Apartments apartment) {

    }

    @Override
    public Apartments getById(int id) {
        return null;
    }

    @Override
    public int findIndexById(int id) {
        return 0;
    }
}
