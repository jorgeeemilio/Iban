package es.studium.Iban;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Modelo
{
	boolean CuentaCorrecta(Cuenta posibleCuenta)
	{
		boolean resultado=false;
		String cuenta = posibleCuenta.Entidad+posibleCuenta.Sucursal+posibleCuenta.Dc+posibleCuenta.NCuenta;
		Pattern cuentaPattern = Pattern.compile("\\d{20}");
		Matcher m = cuentaPattern.matcher(cuenta);
		if(m.matches())
		{
			String banco = "00"+cuenta.substring(0,8);
			int suma = Integer.parseInt(banco.substring(0,1))*1+
					Integer.parseInt(banco.substring(1,2))*2+
					Integer.parseInt(banco.substring(2,3))*4+
					Integer.parseInt(banco.substring(3,4))*8+
					Integer.parseInt(banco.substring(4,5))*5+
					Integer.parseInt(banco.substring(5,6))*10+
					Integer.parseInt(banco.substring(6,7))*9+
					Integer.parseInt(banco.substring(7,8))*7+
					Integer.parseInt(banco.substring(8,9))*3+
					Integer.parseInt(banco.substring(9,10))*6;

			int control= 11 - (suma%11);
			if (control==10)
			{control=1;}
			else if (control==11)
			{control=0;}

			int controlBanco = Integer.parseInt(cuenta.substring(8,9));
			if (controlBanco!=control)
			{return false;}

			suma = Integer.parseInt(cuenta.substring(10,11))*1+
					Integer.parseInt(cuenta.substring(11,12))*2+
					Integer.parseInt(cuenta.substring(12,13))*4+
					Integer.parseInt(cuenta.substring(13,14))*8+
					Integer.parseInt(cuenta.substring(14,15))*5+
					Integer.parseInt(cuenta.substring(15,16))*10+
					Integer.parseInt(cuenta.substring(16,17))*9+
					Integer.parseInt(cuenta.substring(17,18))*7+
					Integer.parseInt(cuenta.substring(18,19))*3+
					Integer.parseInt(cuenta.substring(19,20))*6;
			control= 11 - (suma%11);
			if (control==10)
			{
				control=1;
			}
			else if (control==11)
			{
				control=0;
			}

			int controlcuenta = Integer.parseInt(cuenta.substring(9,10));
			if (controlcuenta!=control)
			{
				resultado = false;
			}
			else
			{
				resultado = true;
			}
		}
		else
		{
			resultado = false;
		}
		return resultado;
	}
	
	String CalcularIban(Cuenta cuenta)
	{
		// Se suma al número de cuenta el código del país según la tabla
		// A=10 B=11 C=12 D=13 E=14
		// F=15 G=16 H=17 I=18 J=19
		// K=20 L=21 M=22 N=23 O=24
		// P=25 Q=26 R=27 S=28 T=29
		// U=30 V=31 W=32 X=33 Y=34
		// Z=35
		// Para España seré el ES00 y sustituyendo E por 14 y S por 28
		// tendríamos el iban original
		// Se concatena por detrás al número de cuenta
		String iban = "";
		String
		iban0 = cuenta.Entidad+cuenta.Sucursal+cuenta.Dc+cuenta.NCuenta+"142800";
		BigInteger iban1 = new BigInteger(iban0);
		// Calculamos su módulo 97
		int iban2 = Integer.parseInt((iban1.mod(new
				BigInteger("97")).toString()));
		int iban3 = 98 - iban2;
		if(iban3<10)
		{
			iban =
					"ES0"+String.valueOf(iban3)+cuenta.Entidad+cuenta.Sucursal+cuenta.Dc+cuenta.NCuenta;
		}
		else
		{
			iban =
					"ES"+String.valueOf(iban3)+cuenta.Entidad+cuenta.Sucursal+cuenta.Dc+cuenta.NCuenta;
		}
		return iban;
	}
}
