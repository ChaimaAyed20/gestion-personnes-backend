package com.poly;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonServiceImpl implements PersonService {

	@Override
	public List<Person> getAllPersons() {
	    List<Person> list = new ArrayList<>();
	    Connection con = DBConnection.getConnection();
	    if (con == null) {
	        System.out.println("Database connection failed!");
	        return list;  // Return empty list instead of crashing
	    }
	    String sql = "SELECT * FROM person";
	    try (Statement st = con.createStatement();
	         ResultSet rs = st.executeQuery(sql)) {
	        while (rs.next()) {
	            Person p = new Person();
	            p.setId(rs.getLong("id"));
	            p.setNom(rs.getString("nom"));
	            p.setAge(rs.getInt("age"));
	            list.add(p);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return list;
	}

    @Override
    public boolean addPerson(Person p) {
        String sql = "INSERT INTO person (nom, age) VALUES (?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getNom());
            ps.setInt(2, p.getAge());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deletePerson(long id) {
        String sql = "DELETE FROM person WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Person getPerson(long id) {
        String sql = "SELECT * FROM person WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Person p = new Person();
                    p.setId(rs.getLong("id"));
                    p.setNom(rs.getString("nom"));
                    p.setAge(rs.getInt("age"));
                    return p;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updatePerson(Person p) {
        String sql = "UPDATE person SET nom = ?, age = ? WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getNom());
            ps.setInt(2, p.getAge());
            ps.setLong(3, p.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Person getPersonByName(String nom) {
        String sql = "SELECT * FROM person WHERE nom = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nom);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Person p = new Person();
                    p.setId(rs.getLong("id"));
                    p.setNom(rs.getString("nom"));
                    p.setAge(rs.getInt("age"));
                    return p;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}