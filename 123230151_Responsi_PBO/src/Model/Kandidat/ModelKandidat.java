/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Kandidat;

/**
 *
 * @author ASUS
 */
public class ModelKandidat {
    private Integer id, writing, coding, interview;
    private double score;
    private String name, path, status;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    
    public Integer getWriting() {
        return writing;
    }
    public void setWriting(Integer writing) {
        this.writing = writing;
    }
    
    public Integer getCoding() {
        return coding;
    }
    public void setCoding(Integer coding) {
        this.coding = coding;
    }
    
    public Integer getInterview() {
        return interview;
    }
    public void setInterview(Integer interview) {
        this.interview = interview;
    }
    
    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }
    
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
