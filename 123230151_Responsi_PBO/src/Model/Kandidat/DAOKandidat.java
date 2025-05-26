/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Kandidat;

import Model.Connector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ASUS
 */
public class DAOKandidat implements InterfaceDAOKandidat {
    
    @Override
    public void insert(ModelKandidat kandidat) {
        try {
            String query = "INSERT INTO recruit (nama, path, writing, coding, interview, score, status) VALUES (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, kandidat.getName());
            statement.setString(2, kandidat.getPath());
            statement.setString(3, kandidat.getWriting().toString());
            statement.setString(4, kandidat.getCoding().toString());
            statement.setString(5, kandidat.getInterview().toString());
            statement.setString(6, Double.toString(kandidat.getScore()));
            statement.setString(7, kandidat.getStatus());
            
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e){
            System.out.println("Input Failed: " +  e.getLocalizedMessage());
        }
    }
    
    @Override
    public void update(ModelKandidat kandidat) {
        try {
            String query = "UPDATE kandidat SET nama=?, path=?, writing=?, coding=?, interview=?, score=?, status=? WHERE id=?;";
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, kandidat.getName());
            statement.setString(2, kandidat.getPath());
            statement.setString(3, kandidat.getWriting().toString());
            statement.setString(4, kandidat.getCoding().toString());
            statement.setString(5, kandidat.getInterview().toString());
            statement.setString(6, Double.toString(kandidat.getScore()));
            statement.setString(7, kandidat.getStatus());
            statement.setInt(8, kandidat.getId());
            
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e){
            System.out.println("Input Failed: " +  e.getLocalizedMessage());
        }
    }
    
    @Override
    public void delete(int id) {
        try {
            String query = "DELETE FROM kandidat WHERE id=?;";
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setInt(1, id);
            
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e){
            System.out.println("Input Failed: " +  e.getLocalizedMessage());
        }
    }
    
    public List<ModelKandidat> getAll() {
        List<ModelKandidat> listKandidat = null;
        
        try {
            listKandidat = new ArrayList<>();
            Statement statement = Connector.Connect().createStatement();
            String query = "SELECT * FROM recruit";
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()) {
                ModelKandidat kand = new ModelKandidat();
                
                kand.setId(resultSet.getInt("id"));
                kand.setName(resultSet.getString("nama"));
                kand.setPath(resultSet.getString("path"));
                kand.setWriting(resultSet.getInt("writing"));
                kand.setCoding(resultSet.getInt("coding"));
                kand.setInterview(resultSet.getInt("interview"));
                kand.setScore(resultSet.getDouble("score"));
                kand.setStatus(resultSet.getString("status"));

                listKandidat.add(kand);
            }
            
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listKandidat;
    }
}
