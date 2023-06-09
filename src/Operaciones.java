//Eduardo Morales Calvo
public class Operaciones{
    float saldo; // Declaración de la variable saldo
    
    // Método para crear una cuenta con saldo inicial de 0
	public float CreacionCuenta (){
		saldo = 0;
		return saldo;  // Devuelve el saldo inicial 
	}
	
    // Método para crear una cuenta con saldo inicial dado
	public float CreacionCuenta (float saldoInicial){
		saldo = saldoInicial;
		return saldo; // Devuelve el saldo inicial proporcionado

	}
	
    // Método para ingresar dinero a la cuenta
	public float ingresar(float ingreso) {
		saldo += ingreso;// Aumenta el saldo con la cantidad de ingreso
		return saldo; // Devuelve el nuevo saldo de la cuenta
	}
	
    // Método para retirar dinero de la cuenta
	public float retirar(float retiro) {
		saldo -= retiro;// Reduce el saldo con la cantidad de retiro
		return saldo;// Devuelve el nuevo saldo de la cuenta
	}
	
}
