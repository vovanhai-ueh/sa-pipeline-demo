package vn.edu.ueh.bit.sol2.polynomial;


import java.util.Objects;

public class Element {
    private String sign;
    private double coefficient;
    private int exponent;

    public Element(String sign, double coefficient, int exponent) {
        this.sign = sign;
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Element element)) return false;
        return sign == element.sign && Double.compare(coefficient, element.coefficient) == 0 && exponent == element.exponent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sign, coefficient, exponent);
    }

    @Override
    public String toString() {
        return sign + coefficient + "^" + exponent;
    }

    public double evaluate(double x) {
        return (this.sign.equals("+") ? 1 : -1) * (this.coefficient * Math.pow(x, this.exponent));
    }
}
