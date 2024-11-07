import java.text.DecimalFormat;

public class CurrencyConverter {

    double pound;
    double dollar;
    double euro;
    double amount;
    String currency;

    public CurrencyConverter(double pound, double dollar, double euro, double amount, String currency) {
        this.pound = pound;
        this.dollar = dollar;
        this.euro = euro;
        this.amount = amount;
        this.currency = currency;
    }

    public double dollarToPound(double amount){
        return amount * 0.74;
    }
    public double dollarToEuro(double amount){
        return amount * 0.88;
    }
    public double poundToDollar(double amount){
        return amount + 1.36;
    }
    public double poundToEuro(double amount){
        return amount * 1.19;
    }
    public double euroToDollar(double amount){
        return amount * 1.31;
    }
    public double euroToPound(double amount){
        return amount * 0.84;
    }
    public static boolean isNumber(String string) {
        try {
            int num = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static boolean input(String amount, String currency) {
        currency = currency.toLowerCase(); // Normalize currency to lowercase
        if (amount.isEmpty() || currency.isEmpty()) {
            return false;
        } else if (isNumber(amount) &&
                (currency.equals("dollars") || currency.equals("pounds") || currency.equals("euros"))) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        CurrencyConverter currencyConverter;
        currencyConverter = new CurrencyConverter(0,0,0, 0, "");

        double amount, dollar, pound, code, euro;

        DecimalFormat f = new DecimalFormat("##.##");

        String inputTestAmount = args[0];
        String currencyTest = args[1];

        boolean input = input(inputTestAmount, currencyTest);
        if (input == true) {
            amount = Integer.parseInt(args[0]);
            String currency = args[1].toLowerCase();


            // For amounts Conversion
            switch (currency) {
                case "dollars":
                    // For Dollar Conversion
                    pound = currencyConverter.dollarToPound(amount);
                    System.out.println(amount + " Dollars = " + f.format(pound) + " Pounds");
                    euro = currencyConverter.dollarToEuro(amount);
                    System.out.println(amount + " Dollars = " + f.format(euro) + " Euros");
                    break;
                case "pounds":
                    // For Pound Conversion
                    dollar = currencyConverter.poundToDollar(amount);
                    System.out.println(amount + " Pounds = " + f.format(dollar) + " Dollars");
                    euro = currencyConverter.poundToEuro(amount);
                    System.out.println(amount + " Pound = " + f.format(euro) + " Euros");
                    break;
                case "euros":
                    // For Euro Conversion
                    dollar = currencyConverter.euroToDollar(amount);
                    System.out.println(amount + " Euros = " + f.format(dollar) + " Dollars");
                    pound = currencyConverter.euroToPound(amount);
                    System.out.println(amount + " Euros = " + f.format(pound) + " Pounds");
                    break;
            }
        } else {System.out.println("invalid input");}
        System.out.println("Thank you for using the converter.");
    }

}

