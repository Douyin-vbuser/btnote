package com.vbuser.btnote.blocks;

import com.vbuser.btnote.Main;
import com.vbuser.btnote.init.ModItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@SuppressWarnings("ALL")
public class Note_x extends BlockBase{

    public static final PropertyBool LOCKED = PropertyBool.create("locked");

    public static final PropertyInteger PITCH = PropertyInteger.create("pitch",1,5);

    public Note_x(String name, Material material, CreativeTabs tab){
        super(name, material,tab);
        setSoundType(SoundType.WOOD);
        setHardness(4f);
        setResistance(20f);
        setHarvestLevel("axe",2);
        setLightLevel(15f);
        setCreativeTab(Main.btnotetab);
        setDefaultState(this.blockState.getBaseState().withProperty(LOCKED,false));
        setDefaultState(this.blockState.getBaseState().withProperty(PITCH,3));
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (playerIn.getHeldItemMainhand().getItem() == ModItems.PITCH_TOOLS) {
            if (state.getValue(LOCKED)) {
                playerIn.sendMessage(new net.minecraft.util.text.TextComponentString("The block is already locked"));
            } else {
                if (state.getValue(PITCH) == 5) {
                    worldIn.setBlockState(pos, state.withProperty(PITCH, 1));
                } else {
                    int pitch = state.getValue(PITCH);
                    pitch = pitch + 1;
                    worldIn.setBlockState(pos, state.withProperty(PITCH, pitch));
                }
            }
        }
        if(playerIn.getHeldItemMainhand().getItem() == ModItems.NOTE_TOOLS){
            if(state.getValue(LOCKED)) {
                worldIn.setBlockState(pos, state.withProperty(LOCKED, false));
                setHardness(4f);
            }
            else {
                worldIn.setBlockState(pos, state.withProperty(LOCKED, true));
                setHardness(-1f);
            }
        }
        return true;
    }

    @Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this,LOCKED,PITCH);
    }

    @Override
    public int getMetaFromState(IBlockState state){
        return state.getValue(LOCKED) ? 1 : 0;
    }

    @Override
    public IBlockState getStateFromMeta(int meta){
        return getDefaultState().withProperty(LOCKED,meta==1);
    }
}
