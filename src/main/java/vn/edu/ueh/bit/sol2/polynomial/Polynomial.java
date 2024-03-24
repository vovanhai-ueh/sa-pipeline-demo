package vn.edu.ueh.bit.sol2.polynomial;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Polynomial {
    private final HashSet<Element> elements;

    public Polynomial() {
        elements = new LinkedHashSet<>();
    }

    public Polynomial(String polinomialString) {
        elements = new LinkedHashSet<>();
        polinomialString = polinomialString.toLowerCase().trim().replace("-", "+-").replace(" ", "");
        String[] eles = polinomialString.split("\\+");
        for (String ele : eles) {
            Element element = parseEle(ele);
            add(element);
        }
    }

    private Element parseEle(String str) {
        str = str.toLowerCase().trim();
        String sign = (str.charAt(0) + "").equals("-") ? "-" : "+";
        double coef = 0f;
        if (str.contains("x"))
            coef = Double.parseDouble(str.substring(0, str.indexOf("x")));
        else
            coef = Double.parseDouble(str);
        int exp = 0;
        if (str.contains("^"))
            exp = Integer.parseInt("0" + str.substring(str.indexOf("^") + 1));

        return new Element(sign, coef, exp);
    }

    public static void main(String[] args) {
        String dathuc = "5x^3 - 9x^6 + 3x - 63x^2+3";
        Polynomial polynomial = new Polynomial(dathuc);
        System.out.println(polynomial);
    }

    public boolean add(Element element) {
        if (elements.contains(element))
            element.setCoefficient(element.getCoefficient() * 2);//double coefficient
        else
            elements.add(element);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        /*Iterator<Element> col = elements.stream().iterator();
        while (col.hasNext()) {
            Element ele = col.next();
            ret.append(ret
                    .append(ele.getCoefficient())
                    .append("x^")
                    .append(ele.getExponent())
            );
        }*/
        return ret.toString();
    }

}
