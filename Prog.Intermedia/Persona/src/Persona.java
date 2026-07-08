
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;

public Persona(){
    this (null,null,0);
}
public Persona(String nombre, String apellido, int edad){
    this.nombre = nombre;
    this.apellido = apellido ;
    this.edad = edad;
}
public String getNombre(){
    return this.nombre;
}
public void setNombre(String nombre){
    this.nombre = nombre;
}
public String getApellido(){
    return this.apellido;
}
public void setApellido(String apellido){
    this.apellido = apellido;
}
public int getEdad(){
    return this.edad;
}
public void setEdad(int edad){
    if (edad > 0){
        this.edad = edad;
    }else{
        System.out.println("ingrese una edad mayor a 0");
    }

   }
   public String MostrarInfo(){
    String mensaje = ("la persona se llama "+this.nombre+"\nSe apellida "+this.apellido+"\nY la edad es "+this.edad);
    return mensaje;
   }
}


