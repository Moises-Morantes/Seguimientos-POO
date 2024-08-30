package Figuras;
 
public class FiguraGeometrica {
private double volumen; 
private double superficie;  
public void setVolumen(double volumen) {
this.volumen = volumen;
}
498 Ejercicios de programación orientada a objetos con Java y UML
/**
* Método para establecer la superficie de una figura geométrica
* @param superficie Parámetro que define la superficie de una 
* figura geométrica
*/
public void setSuperficie(double superficie) {
this.superficie = superficie;
}
/**
* Método para obtener el volumen de una figura geométrica
* @return El volumen de una figura geométrica
*/
public double getVolumen() {
return this.volumen;
}
/**
* Método para obtener la superficie de una figura geométrica
* @return La superficie de una figura geométrica
*/
public double getSuperficie() {
return this.superficie;
}
}