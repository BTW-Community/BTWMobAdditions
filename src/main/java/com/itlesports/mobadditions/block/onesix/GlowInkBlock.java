package com.itlesports.mobadditions.block.onesix;
import net.minecraft.src.*;
public class GlowInkBlock extends BlockGlowStone
{
    public GlowInkBlock(int iBlockID )
    {
        super( iBlockID, Material.rock );

        setHardness( 0.6F );
        setResistance( 0.5F ); // preserve vanilla resistance

        setPicksEffectiveOn();

        setLightValue( 1F );

        setStepSound( soundStoneFootstep );

        setUnlocalizedName( "lightgem" );
    }

    @Override
    public boolean hasLargeCenterHardPointToFacing(IBlockAccess blockAccess, int i, int j, int k, int iFacing, boolean bIgnoreTransparency )
    {
        return bIgnoreTransparency;
    }
}
