package tema5.ejemplos;

/** Clase fracción que incluye excepciones en los métodos con imposibles matemáticos
 * @author andoni.eguiluz @ ingenieria.deusto.es
 */
public class Fraccion implements Comparable<Fraccion> {
	protected int num;
	protected int den;
	
	/** Crea una nueva fracción
	 * @param num	Numerador
	 * @param den	Denominador
	 * @throws ArithmeticException	Si el denominador es cero (valor no permitido)
	 */
	public Fraccion(int num, int den) throws ArithmeticException {
		super();
		this.num = num;
		this.den = den;
		if (den==0) {
			throw new ArithmeticException( "Fracción con denominador cero" );
		}
	}

	public int getNum() {
		return num;
	}

	public int getDen() {
		return den;
	}

	/** Calcula el valor real correspondiente a la fracción
	 * @return	Número real resultado de dividir numerador entre denominador
	 */
	public double calcular() {
		return 1.0*num/den;
	}

	/** Simplifica la fracción si procede (si no, la deja igual)
	 * dividiendo numerador y denominador por su MCD, y dejando el signo (si lo hubiera) en el numerador
	 * @return	Modifica la fracción simplificándola y la devuelve
	 */
	public Fraccion simplifica() {
		if (num==0 && den!=0) { den = 1; return this; }  // Caso especial 0/n es = a 0/m. La más simple: 0/1
		int mcd = mcd( num, den );
		if (mcd > 1) {
			num /= mcd;
			den /= mcd;
		}
		if (den<0) {
			den = -den;
			num = -num;
		}
		return this;
	}
		// Devuelve el Máximo Común Divisor de dos números
		private static int mcd( int a, int b ) {
			a = Math.abs(a); b = Math.abs(b);
			int mcd = Math.min(a, b);
			while ((a%mcd!=0 || b%mcd!=0) && mcd>1)
				mcd--;
			return mcd;
		}
	
	/** Suma dos fracciones y devuelve nueva fracción resultado
	 * @param f1	Operando 1
	 * @param f2	Operando 2
	 * @return	Fracción resultado f1+f2
	 * @throws NullPointerException	Si alguna de las fracciones es null
	 */
	public static Fraccion suma( Fraccion f1, Fraccion f2 ) throws NullPointerException {
		if (f1==null || f2 == null) {
			// return null;
			throw new NullPointerException();
		}
		return new Fraccion( f1.num*f2.den + f2.num*f1.den, f1.den*f2.den );
	}
	
	/** Resta dos fracciones y devuelve nueva fracción resultado
	 * @param f1	Operando 1
	 * @param f2	Operando 2
	 * @return	Fracción resultado f1-f2
	 * @throws NullPointerException	Si alguna de las fracciones es null
	 */
	public static Fraccion resta( Fraccion f1, Fraccion f2 ) throws NullPointerException {
		return new Fraccion( f1.num*f2.den - f2.num*f1.den, f1.den*f2.den );
	}
	
	/** Multiplica dos fracciones y devuelve nueva fracción resultado
	 * @param f1	Operando 1
	 * @param f2	Operando 2
	 * @return	Fracción resultado f1*f2
	 * @throws NullPointerException	Si alguna de las fracciones es null
	 */
	public static Fraccion multiplica( Fraccion f1, Fraccion f2 ) throws NullPointerException {
		return new Fraccion( f1.num*f2.num, f1.den*f2.den );
	}
	
	/** Divide dos fracciones y devuelve nueva fracción resultado
	 * @param f1	Operando 1
	 * @param f2	Operando 2
	 * @return	Fracción resultado f1/f2
	 * @throws NullPointerException	Si alguna de las fracciones es null
	 * @throws ArithmeticException	Si la fracción 2 es cero (operación no permitida)
	 */
	public static Fraccion divide( Fraccion f1, Fraccion f2 ) throws NullPointerException, ArithmeticException {
		return new Fraccion( f1.num*f2.den, f1.den*f2.num );
	}
	
	@Override
	public String toString() {
		return num + "/" + den;
	}
	
	public String toStringConValor() {
		return num + "/" + den + " = " + calcular();
	}

	@Override
	public int hashCode() {
		return den+num;
	}

	// Igualdad funcione de acuerdo a la equivalencia de fracciones (ej 1/2 == 2/4)
	/** Compara dos fracciones de acuerdo a su equivalencia numérica. Se devuelve true
	 * si las fracciones this y obj simplificadas son la misma
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Fraccion) {
			Fraccion f2 = (Fraccion) obj;
			Fraccion f1simp = this.simplifica();
			Fraccion f2simp = f2.simplifica();
			return f1simp.num==f2simp.num && f1simp.den==f2simp.den;
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(Fraccion o) {
		double yo = this.calcular();
		double el = o.calcular();
		if (yo>el) { 
			return +1; 
		} else if (yo==el) { 
			return 0; 
		} else { 
			return -1; 
		}
	}

}
