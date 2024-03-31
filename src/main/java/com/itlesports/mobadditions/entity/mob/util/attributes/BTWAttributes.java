package com.itlesports.mobadditions.entity.mob.util.attributes;

public abstract class BTWAttributes {
    public static final Attribute armor = new RangedAttribute("generic.armor", 0.0D, 0.0D, Double.MAX_VALUE).func_111117_a("Armor").setShouldWatch(true);
    public static final Attribute armorWeight = new RangedAttribute("generic.armorWeight", 0.0D, 0.0D, Double.MAX_VALUE).func_111117_a("Armor Weight").setShouldWatch(true);
    public static final Attribute hungerCost = new RangedAttribute("generic.hungerCost", 1.0D, 0.0D, Double.MAX_VALUE).func_111117_a("Hunger Cost").setShouldWatch(true);
}