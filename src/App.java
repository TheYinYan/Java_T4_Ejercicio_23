public class App {
    public static void main(String[] args) throws Exception {
        System.out.print("Introduzca la base imponible: ");
        double precio = Integer.parseInt(System.console().readLine());

        System.out.print("Introduzca el tipo de IVA (general, reducido o superreducido): ");
        String stringiva = System.console().readLine().toLowerCase();

        double iva = 0;
        switch (stringiva) {
            case "general" -> iva = 0.21;
            case "reducido" -> iva = 0.10;
            case "superreducido" -> iva = 0.04;
            default -> iva = -1;
        }
        if (iva == -1) {
            System.out.println("Introduzca un IVA exixtente");
            return;
        }

        System.out.print("Introduzca código promocional (nopro, mitad, menos5 o 5proc): ");
        String codpromo = System.console().readLine();

        double precioIva = precio * iva;
        double precioConIva = precioIva+precio;

        double precioPromo = 0;
        switch (codpromo) {
            case "nopro" -> precioPromo = 0;
            case "mitad" -> precioPromo = precioConIva / 2;
            case "menos5" -> precioPromo = 5;
            case "5proc" -> precioPromo = precioConIva * 0.5;
            default -> precioPromo = -1;
        }
        if (precioPromo == -1) {
            System.out.println("Introduzca un código promocional exixtente");
            return;
        }
       
        double ivaEn = iva * 100;
        double total = precioConIva-precioPromo;

        System.out.printf("""
                %-20s%5.2f
                %-20s%5.2f
                %-20s%5.2f
                %-20s%5.2f
                %-20s%5.2f
                ""","Base imponible ", precio,
                            "IVA(" + (int) ivaEn + "%) ", precioIva,
                            "Precio con IVA ",precioConIva,
                            "Promo ("+codpromo+") - ",precioPromo,
                            "Total ",total);
    }
}
