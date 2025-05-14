public class ConversorNumeros {
    public static int stringToInt(String numero) {
        return Integer.parseInt(numero);
    }

    public static double stringToDouble(String numero) {
        numero = numero.replace(',', '.');
        return Double.parseDouble(numero);
    }

    public static String doubleToString(double numero) {
        return String.format("%.2f", numero);
    }
}
