/**
 * класс Procent для расчета процентов со свойствами P,A,sum,bankrate,
 * months,monpay,creditsum,overpay,str1,str2,str3;
 *
 * @author Ермаков Даниил
 * @version 1.0
 */
public class Procent {
    /** <b>Поле процентная ставка</b> */
    static double P;
    /** <b>Поле коэффициент аннуитета</b> */
    static double A;
    /** <b>Поле сумма кредита</b> */
    static double sum;
    /** <b>Поле годовая процентная ставка банка</b> */
    static double bankrate;
    /** <b>Поле кол-во месяцев</b> */
    static double months;
    /** <b>Поле ежемесячный платеж</b> */
    static double monpay;
    /** <b>Поле общая сумма по кредиту</b> */
    static double creditsum;
    /** <b>Поле сумма переплат по кредиту</b> */
    static double overpay;
    /** <b>строка 1</b> */
    public String str1;
    /** <b>строка 2</b> */
    public String str2;
    /** <b>строка 3</b> */
    public String str3;

    /**
     * <i>метод позволяет рассчитать процентную ставку,коэффициент аннуитета,ежемесячный платеж,
     * общую сумму по кредиту,сумму переплат по кредиту</i>
     *
     * @param a сумма кредита
     * @param b годовая процентная ставка банка
     * @param c количество месяцев
     */
         public static void setProcent(double a, double b, double c){
             P = (0.01 * b)/c;
             A =  (P * Math.pow((1 + P),c)) / (Math.pow((1 + P),c) - 1);
             monpay = a * A;
             creditsum = c * monpay;
             overpay = creditsum - a;

        }

    /**
     * <i>метод,преобразовывающий поля monpay,creditsum и overpay из типа double в тип string.
     * Также данный метод инициализирует массив strings типа String</i>
     *
     * @return массив строк
     */
        public String[] getStrings(){
            str1 = Double.toString(monpay);
            str2 = Double.toString(creditsum);
            str3 = Double.toString(overpay);
            String[] strings = {str1,  str2,  str3};
            return strings;
        }
}