package com.example.demo.util;


import org.apache.commons.lang3.StringUtils;


public final class StringUtility
{
    public static String requireNotBlank(final String toValidate)
    {
        if (StringUtils.isBlank(toValidate))
        {
            throw new IllegalArgumentException("String parameter must not be blank!");
        }
        return toValidate;
    }


    private StringUtility()
    {
        throw new UnsupportedOperationException("Creating instances is not supported!");
    }
}
