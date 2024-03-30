package com.itlesports.mobadditions.block.onesix;

import btw.client.render.util.RenderUtils;
import btw.item.items.HoeItem;
import com.itlesports.mobadditions.block.ModBlocks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.src.*;
public class HayBlock extends BlockRotatedPillar
{
    public HayBlock(int blockID)
    {
        super(blockID, Material.grass);
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
        this.field_111051_a = par1IconRegister.registerIcon("hay_block_top");
        this.blockIcon = par1IconRegister.registerIcon("hay_block_side");
    }
    public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6)
    {
        if (!par1World.isRemote && par2EntityPlayer.getCurrentEquippedItem() != null && par2EntityPlayer.getCurrentEquippedItem().getItem() instanceof HoeItem)
        {
            par2EntityPlayer.addStat(StatList.mineBlockStatArray[this.blockID], 1);
            this.dropBlockAsItem_do(par1World, par3, par4, par5, new ItemStack(ModBlocks.hayBlock, 1, par6));
        }
        else
        {
            super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
        }
    }
}
