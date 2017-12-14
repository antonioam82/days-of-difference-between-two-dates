import java.util.*;

public class Main {

    public static boolean esBisiesto(int year) {
        return (year % 4 == 0 & year % 100 != 0 | year % 400 == 0);}

    public static boolean diaEsIncorrecto(int day, int month, int year) {
        int[] cant_de_dias = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (esBisiesto(year) & month == 2 & day > 29)
            return true;
        else if (esBisiesto(year) & month != 2 & day > cant_de_dias[month])
            return true;
        else if (!esBisiesto(year) & day > cant_de_dias[month])
            return true;
        else
            return false;}

    public static boolean validacionFecha(int day, int month, int year) {
        if (day < 1 | day > 31)
            return false;
        else if (month > 12 | month < 1)
            return false;
        else if (year < 1)
            return false;
        else if (diaEsIncorrecto(day, month, year))
            return false;
        else
            return true;}

    public static void diferenciaDias(int day1, int month1, int year1, int day2, int month2, int year2) {
        int diferencia = 0;
        int[] cant_de_dias = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if(year1==year2){ // SI LOS DOS AÑOS SON IGUALES
            if(month1==month2)
               diferencia+=day2-day1;
            else{
                diferencia+=cant_de_dias[month1]-day1
                if(esBisiesto(year1)){
                    cant_de_dias[2]=29;
                    for(int i=month1+1 ; i<=month2 ; i++){
                        if(i!=month2)
                           diferencia+=cant_de_dias[i];
                        else
                           diferencia+=day2;}}
                else{
                    for(int i=month1+1 ; i<=month2 ; i++){
                        if(i!=month2)
                           diferencia+=cant_de_dias[i];
                        else
                           diferencia+=day2;}}}}
        else{ // AHORA SI LOS DOS AÑOS SON DIFERENTES
            /*
            Antes del for situado mas abajo(el de iterador "b") es necesario calcular la diferencia en dias
            desde fecha1 hasta el primero de enero del año siguiente.
            */
            if(esBisiesto(year1))
                int diferencia=366;
            else
                int diferencia=365;
            for(int q=1; q<=month1 ; q++){ //Calculamos cantidad de dias de year1
                if(q!=month2 ; )           //para lograr que diferencia sea la cantidad
                    diferencia-=cant_de_dias[q];
                else                       //de dias desde fecha1 hasta el prox año nuevo.
                    diferencia-=day1;}

            for(int b=year1+1 ; b<=year2 ; b++){
                if(b!=year2){
                    if(esBisiesto(b))
                        diferencia+=366;
                    else
                        diferencia+=365;}
                else{
                    if(esBisiesto(b)){
                        cant_de_dias[2]=29;
                        for(int m=1 ; m<=month2 ; m++){
                            if(m!=month2)
                                diferencia+=cant_de_dias[m];
                            else
                                diferencia+=day2;}}
                    else{
                        for(int m=1 ; m<=month2 ; m++){
                            if(m!=month2)
                                diferencia+=cant_de_dias[m];
                            else
                                diferencia+=day2;}}}}}
        System.out.print(diferencia);}

    public static boolean fechaUnoMasAntigua(int day1, int month1, int year1, int day2, int month2, int year2){
        if(year2>=year1)
            if(year2>year1)
                return true;
            else //Si ambos años son iguales...
                if(month2>month1)
                    return true;
                else if(month2==month1 & day2>day1)
                    return true;
                else
                    return false;
        else
            return false;}

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        int dia1, mes1, año1, dia2, mes2, año2;

        while (true) {
            System.out.println("\n-----------------\n");
            System.out.print("Ingrese dia1: ");
            dia1 = leer.nextInt();
            System.out.print("Ingrese mes1: ");
            mes1 = leer.nextInt();
            System.out.print("Ingrese año1: ");
            año1 = leer.nextInt();

            System.out.print("Ingrese dia2: ");
            dia2 = leer.nextInt();
            System.out.print("Ingrese mes2: ");
            mes2 = leer.nextInt();
            System.out.print("Ingrese año2: ");
            año2 = leer.nextInt();

            boolean v_fecha1 = validacionFecha(dia1, mes1, año1), v_fecha2 = validacionFecha(dia2, mes2, año2);

            if (dia1 == dia2 & mes1 == mes2 & año1 == año2 & v_fecha1 & v_fecha2)
                System.out.println("Las fechas son iguales.");
            else if (v_fecha1 & v_fecha2) {
                System.out.print("La cantidad de dias de diferencia entre ambas fechas es ");
                if (fechaUnoMasAntigua(dia1, mes1, año1, dia2, mes2, año2))
                    diferenciaDias(dia1, mes1, año1, dia2, mes2, año2);
                else
                    diferenciaDias(dia2, mes2, año2, dia1, mes1, año1);}
            else
                System.out.println("Al menos una de las fechas es incorrecta.");}}
}//fin de la clase Main
