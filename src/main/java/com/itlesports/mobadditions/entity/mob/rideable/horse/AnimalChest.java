package com.itlesports.mobadditions.entity.mob.rideable.horse;

import net.minecraft.src.*;

import java.util.ArrayList;
import java.util.List;

public class AnimalChest extends InventoryBasic
{
    private List field_70480_d;
    private String inventoryTitle;
    private boolean field_94051_e;
    public AnimalChest(String par1Str, int par2)
    {
        super(par1Str, false, par2);
    }

    public AnimalChest(String par1Str, boolean par2, int par3)
    {
        super(par1Str, par2, par3);
        this.field_94051_e = par2;
        this.inventoryTitle = par1Str;
    }
    public void func_110133_a(String par1Str)
    {
        this.field_94051_e = true;
        this.inventoryTitle = par1Str;
    }
    public void func_110132_b(IInvBasic par1IInvBasic)
    {
        this.field_70480_d.remove(par1IInvBasic);
    }
    public void func_110134_a(IInvBasic par1IInvBasic)
    {
        if (this.field_70480_d == null)
        {
            this.field_70480_d = new ArrayList();
        }

        this.field_70480_d.add(par1IInvBasic);
    }

}
