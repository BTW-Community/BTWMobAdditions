package com.itlesports.mobadditions.block.onesix;

import net.minecraft.src.*;
public class HayBlock extends BlockRotatedPillar
{
    public HayBlock(int par1)
    {
        super(par1, Material.grass);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    @Override
    public String getItemIconName()
    {
        return "hay_block";
    }


    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 31;
    }

    /**
     * The icon for the side of the block.
     */
    protected Icon getSideIcon(int par1)
    {
        return this.blockIcon;
    }

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.field_111051_a = par1IconRegister.registerIcon(this.getItemIconName() + "_top");
        this.blockIcon = par1IconRegister.registerIcon(this.getItemIconName() + "_side");
    }
}
