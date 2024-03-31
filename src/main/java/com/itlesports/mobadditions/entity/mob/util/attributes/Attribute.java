package com.itlesports.mobadditions.entity.mob.util.attributes;

public interface Attribute
{
    String getAttributeUnlocalizedName();

    double clampValue(double var1);

    double getDefaultValue();

    boolean getShouldWatch();
}
