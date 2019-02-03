package com.roman.otherProjects;

public class xsdSimpleType {
    private String type;
    private int length;
    private int maxLength;
    private int minLength;
    private int minOccurs;
    private int maxOccurs;
    private double minInclusive;
    private double maxInclusive;
    private double minExclusive;
    private double maxExclusive;
    private int totalDigits;
    private String pattern;

    public xsdSimpleType(final String type) {
        this.type = type;
    }

    public xsdSimpleType(final String type, final int length, final int maxLength, final int minLength, final int minOccurs, final int maxOccurs,
            final double minInclusive, final double maxInclusive,
            final double minExclusive, final double maxExclusive, final int totalDigits, final String pattern) {
        this.type = type;
        this.length = length;
        this.maxLength = maxLength;
        this.minLength = minLength;
        this.minOccurs = minOccurs;
        this.maxOccurs = maxOccurs;
        this.minInclusive = minInclusive;
        this.maxInclusive = maxInclusive;
        this.minExclusive = minExclusive;
        this.maxExclusive = maxExclusive;
        this.totalDigits = totalDigits;
        this.pattern = pattern;
    }
}
