package modelo;

public class Categoria {
    private int id;
    private String name;
    
    public Categoria(String name){
        this.name = name;
    }
    public Categoria(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String toString(){
        return this.name;
    }
}
