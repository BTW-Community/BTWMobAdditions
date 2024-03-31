package com.itlesports.mobadditions.entity.mob.util;

public class ResourceLocation implements Comparable<ResourceLocation>
{
    private final String resourcePath;

    public ResourceLocation(String par1Str, String par2Str)
    {
        this.resourcePath = par2Str;
    }

    public ResourceLocation(String par1Str)
    {
        String var3 = par1Str;
        int var4 = par1Str.indexOf(58);

        if (var4 >= 0)
        {
            var3 = par1Str.substring(var4 + 1, par1Str.length());

        }
        this.resourcePath = var3;
    }

    public String getResourcePath()
    {
        return this.resourcePath;
    }

    public String toString()
    {
        return this.resourcePath;
    }

    public boolean equals(Object par1Obj)
    {
        if (this == par1Obj)
        {
            return true;
        }
        else if (!(par1Obj instanceof ResourceLocation))
        {
            return false;
        }
        else
        {
            ResourceLocation var2 = (ResourceLocation)par1Obj;
            return this.resourcePath.equals(var2.resourcePath);
        }
    }
    public int hashCode()
    {
        return 31 * this.resourcePath.hashCode();
    }
    @Override
    public int compareTo(ResourceLocation that) {
        int i = this.resourcePath.compareTo(that.resourcePath);
        if (i != 0) return i;
        return this.resourcePath.compareTo(that.resourcePath);
    }
}
