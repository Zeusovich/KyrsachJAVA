public class Procent {
    static double P,A;
    static double sum;
    static double bankrate;
    static double months;
    static double monpay;
    static double creditsum;
    static double overpay;
    public String str1;
    public String str2;
    public String str3;

        public String[] getStrings(){
            String[] strings = {str1,  str2,  str3};
            return strings;
        }

        public void setSum(double n){
            this.sum = n;
            System.out.println(this.sum);
        }
        public void setBankrate(double n){
            this.bankrate = n;
            System.out.println(this.bankrate);
        }
        public void setMonths(double n){
            this.months = n;
            System.out.println(this.months);
        }

        public String getstr1(){
            str1 = Double.toString(monpay);
            System.out.println(str1);
            return str1;
        }
        public String getstr2(){
            str2 = Double.toString(creditsum);
            System.out.println(str2);
            return str2;
        }
         public String getstr3(){
            str3 = Double.toString(overpay);
            System.out.println(str3);
             return str3;
        }


        public static void setProcent(double a, double b, double c){
            P = (0.01 * b)/c;
            A =  (P * Math.pow((1 + P),c)) / (Math.pow((1 + P),c) - 1);
            monpay = a * A;
            //str1 = Double.toString(monpay);
            //this.str1 = monpay;

            creditsum = c * monpay;
            //str2 = Double.toString();

            overpay = creditsum - a;
            //str3 = Double.toString(overpay);

            //System.out.println(monpay);
            //System.out.println(creditsum);
            //System.out.println(overpay);
            //return str;
        }

       /* double procentmonpay(this.sum, this.bankrate, double months){
        P = (0.01 * bankrate)/months;
        A =  (P * Math.pow((1 + P),months)) / (Math.pow((1 + P),months) - 1);
         //->text4
        monpay = sum * A;
        //->text5
        creditsum = months * monpay;
        //->text6
        overpay = creditsum - sum;
        return monpay;
        return creditsum;
        return overpay;
        }

        double procentcreditsum(this.sum, this.bankrate, double months){
            P = (0.01 * bankrate)/months;
            A =  (P * Math.pow((1 + P),months)) / (Math.pow((1 + P),months) - 1);
            //->text4
            monpay = sum * A;
            return creditsum;
        }

        double procentoverpay(this.sum, this.bankrate, double months){

            return overpay;
        }
        // sum = text1
        // bankrate = text2
        // month = text3
        public void setSum(double n){
            this.sum =n;
        }*/
}