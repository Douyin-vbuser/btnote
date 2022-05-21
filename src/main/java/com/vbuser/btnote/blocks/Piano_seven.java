package com.vbuser.btnote.blocks;

import com.vbuser.btnote.Main;
import com.vbuser.btnote.init.ModBlocks;
import com.vbuser.btnote.init.ModItems;
import com.vbuser.btnote.util.handlers.SoundsHandler;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@SuppressWarnings("ALL")
public class Piano_seven extends BlockBase {

    public static final PropertyInteger PITCH = PropertyInteger.create("pitch", 1, 7);

    public static final PropertyBool LOCKED = PropertyBool.create("locked");

    public Piano_seven(String name, Material material, CreativeTabs tab) {
        super(name, material, tab);
        setSoundType(SoundType.WOOD);
        setHardness(4f);
        setResistance(20f);
        setHarvestLevel("axe", 2);
        setLightLevel(15f);
        setCreativeTab(Main.btnotetab);
        setDefaultState(this.blockState.getBaseState().withProperty(LOCKED, false).withProperty(PITCH, 4));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, LOCKED, PITCH);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int pitch = state.getValue(PITCH);
        return ((pitch > 3) ? (pitch - 4) : (pitch + 3)) + (state.getValue(LOCKED) ? 8 : 0);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(PITCH, (meta % 8 < 4) ? ((meta + 4 ) % 8 ) : ((meta - 3 ) % 7) ).withProperty(LOCKED, meta > 7);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (playerIn.getHeldItemMainhand().getItem() == ModItems.PITCH_TOOLS) {
            if (state.getValue(LOCKED)) {
                playerIn.sendMessage(new net.minecraft.util.text.TextComponentString("The block is already locked"));
            } else {
                if (state.getValue(PITCH) == 7) {
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
        if(playerIn.getHeldItemMainhand().getItem() == Item.getItemFromBlock(Blocks.NOTEBLOCK)){
            if (state.getValue(LOCKED)) {
                playerIn.sendMessage(new net.minecraft.util.text.TextComponentString("The block is locked"));
            } else {
                int pitch = (state.getValue(PITCH)<2)?1:(state.getValue(PITCH)>6)?5:(state.getValue(PITCH)-1);
                worldIn.setBlockState(pos, ModBlocks.NOTE_SEVEN.getBlockState().getBaseState().withProperty(Note_seven.PITCH, pitch).withProperty(LOCKED,false), 2);
            }
        }
        return true;
    }
    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
        boolean flag = worldIn.isBlockPowered(pos);
        if(flag){
            if(state.getValue(PITCH) == 1){
                worldIn.playSound(null,pos, SoundsHandler.BLOCK_PIANO_SEVEN_1, SoundCategory.BLOCKS, 3.0F, 1.0F);
            }
            if(state.getValue(PITCH) == 2){
                worldIn.playSound(null,pos,SoundsHandler.BLOCK_PIANO_SEVEN_2,SoundCategory.BLOCKS,3.0F,1.0F);
            }
            if(state.getValue(PITCH) == 3){
                worldIn.playSound(null,pos,SoundsHandler.BLOCK_PIANO_SEVEN_3,SoundCategory.BLOCKS,3.0F,1.0F);
            }
            if(state.getValue(PITCH) == 4){
                worldIn.playSound(null,pos,SoundsHandler.BLOCK_PIANO_SEVEN_4,SoundCategory.BLOCKS,3.0F,1.0F);
            }
            if(state.getValue(PITCH) == 5){
                worldIn.playSound(null,pos,SoundsHandler.BLOCK_PIANO_SEVEN_5,SoundCategory.BLOCKS,3.0F,1.0F);
            }
            if(state.getValue(PITCH) == 6){
                worldIn.playSound(null,pos,SoundsHandler.BLOCK_PIANO_SEVEN_6,SoundCategory.BLOCKS,3.0F,1.0F);
            }
            if(state.getValue(PITCH) == 7){
                worldIn.playSound(null,pos,SoundsHandler.BLOCK_PIANO_SEVEN_7,SoundCategory.BLOCKS,3.0F,1.0F);
            }
        }
    }
}
