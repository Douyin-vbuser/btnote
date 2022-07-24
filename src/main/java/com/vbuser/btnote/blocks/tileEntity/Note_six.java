package com.vbuser.btnote.blocks.tileEntity;

import com.vbuser.btnote.Main;
import com.vbuser.btnote.blocks.BlockBase;
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
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@SuppressWarnings("ALL")
public class Note_six extends BlockBase {

    public static final PropertyBool LONE = PropertyBool.create("locked");

    public static final PropertyInteger PITCH = PropertyInteger.create("pitch",1,5);

    //private static final List<SoundEvent> INSTRUMENTS = Lists.newArrayList(SoundsHandler.BLOCK_NOTE_SIX_PIANO_1,SoundsHandler.BLOCK_NOTE_SIX_PIANO_2,SoundsHandler.BLOCK_NOTE_SIX_PIANO_3,SoundsHandler.BLOCK_NOTE_SIX_PIANO_4,SoundsHandler.BLOCK_NOTE_SIX_PIANO_5,SoundsHandler.BLOCK_NOTE_SIX_ELECTRIC_1,SoundsHandler.BLOCK_NOTE_SIX_ELECTRIC_2,SoundsHandler.BLOCK_NOTE_SIX_ELECTRIC_3,SoundsHandler.BLOCK_NOTE_SIX_ELECTRIC_4,SoundsHandler.BLOCK_NOTE_SIX_ELECTRIC_5,SoundsHandler.BLOCK_NOTE_SIX_STRINGS_1,SoundsHandler.BLOCK_NOTE_SIX_STRINGS_2,SoundsHandler.BLOCK_NOTE_SIX_STRINGS_3,SoundsHandler.BLOCK_NOTE_SIX_STRINGS_4,SoundsHandler.BLOCK_NOTE_SIX_STRINGS_5,SoundsHandler.BLOCK_NOTE_SIX_GUITAR_1,SoundsHandler.BLOCK_NOTE_SIX_GUITAR_2,SoundsHandler.BLOCK_NOTE_SIX_GUITAR_3,SoundsHandler.BLOCK_NOTE_SIX_GUITAR_4,SoundsHandler.BLOCK_NOTE_SIX_GUITAR_5);

    public Note_six(String name, Material material, CreativeTabs tab){
        super(name, material,tab);
        setSoundType(SoundType.WOOD);
        setHardness(4f);
        setResistance(20f);
        setHarvestLevel("axe",3);
        setLightLevel(15f);
        setCreativeTab(Main.btnotetab);
        setDefaultState(this.blockState.getBaseState().withProperty(LONE,false));
        setDefaultState(this.blockState.getBaseState().withProperty(PITCH,3));
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        if(playerIn.getHeldItemMainhand().getItem() == ModItems.PITCH_TOOLS) {
            {
                int pitch = state.getValue(PITCH);
                pitch = (pitch==5)?1:(pitch+1);
                worldIn.setBlockState(pos, state.withProperty(PITCH,pitch));
            }
        }
        if(playerIn.getHeldItemMainhand().getItem() == ModItems.NOTE_TOOLS){
            if(state.getValue(LONE)){
                worldIn.setBlockState(pos, state.withProperty(LONE, false));
            }
            else{
                worldIn.setBlockState(pos,state.withProperty(LONE,true));
            }
        }

        if(playerIn.getHeldItemMainhand().getItem() == Item.getItemFromBlock(Blocks.DIRT)){
            worldIn.setBlockState(pos, ModBlocks.PIANO_SIX.getBlockState().getBaseState().withProperty(Piano_six.PITCH,(state.getValue(PITCH)+1)).withProperty(Piano_six.HARD,false), 2);

        }
        return true;

    }

    @Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this,LONE,PITCH);
    }

    @Override
    public int getMetaFromState(IBlockState state){
        int pitch = state.getValue(PITCH);
        return ((pitch > 2) ? (pitch -3) : (pitch +2)) + (state.getValue(LONE) ? 0 : 6);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(PITCH,(meta%6<3)?((meta+3)%6):((meta-2)%6)).withProperty(LONE,meta>5);
    }

    @Override
    public TileEntity createTileEntity(World worldIn, IBlockState state)
    {
        return new TileEntityBtnoteSix();
    }

    @Override
    public boolean hasTileEntity(IBlockState state){
        return true;
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
        boolean flag = worldIn.isBlockPowered(pos);

        TileEntity tileentity = worldIn.getTileEntity(pos);

        if (tileentity instanceof TileEntityBtnoteSix)
        {
            TileEntityBtnoteSix tileEntityBtnoteSix = (TileEntityBtnoteSix)tileentity;

            if (tileEntityBtnoteSix.previousRedstoneState != flag)
            {
                if (flag)
                {
                    IBlockState iblockstate = worldIn.getBlockState(pos.down());
                    Block block = iblockstate.getBlock();
                        if (state.getValue(PITCH) == 3) {
                            if (block == Blocks.DIRT) {
                                worldIn.playSound(null, pos, SoundsHandler.BLOCK_NOTE_SIX_PIANO_3, SoundCategory.BLOCKS, 3.0F, 1.0F);
                            }
                            if (block == Blocks.GLOWSTONE){
                                worldIn.playSound(null,pos,SoundsHandler.BLOCK_NOTE_SIX_ELECTRIC_3,SoundCategory.BLOCKS,3.0F,1.0F);
                            }
                            if (block == Blocks.OBSIDIAN){
                                if(state.getValue(LONE)){worldIn.playSound(null,pos,SoundsHandler.BLOCK_NOTE_SIX_STRINGS_3,SoundCategory.BLOCKS,3.0F,1.0F);}
                                else{worldIn.playSound(null,pos,SoundsHandler.BLOCK_NOTE_SIX_STRINGS_3_SHORT,SoundCategory.BLOCKS,3.0F,1.0F);}
                            }
                            if (block == Blocks.PLANKS){
                                worldIn.playSound(null,pos,SoundsHandler.BLOCK_NOTE_SIX_GUITAR_3,SoundCategory.BLOCKS,3.0F,1.0F);
                            }
                            if(block == Blocks.LOG){
                                worldIn.playSound(null,pos,SoundsHandler.BLOCK_NOTE_SIX_VIOLIN_3,SoundCategory.BLOCKS,3.0F,1.0F);
                            }
                            if(block == Blocks.SANDSTONE){
                                worldIn.playSound(null,pos,SoundsHandler.BLOCK_NOTE_SIX_BRASS_3,SoundCategory.BLOCKS,3.0F,1.0F);
                            }
                            if(block == Blocks.LEAVES){
                                worldIn.playSound(null,pos,SoundsHandler.BLOCK_NOTE_SIX_WOODWIND_3,SoundCategory.BLOCKS,3.0F,1.0F);
                            }
                        }
                        if (state.getValue(PITCH) == 2) {
                            if (block == Blocks.DIRT) {
                                worldIn.playSound(null, pos, SoundsHandler.BLOCK_NOTE_SIX_PIANO_2, SoundCategory.BLOCKS, 3.0F, 1.0F);
                            }
                            if (block == Blocks.GLOWSTONE){
                                worldIn.playSound(null,pos,SoundsHandler.BLOCK_NOTE_SIX_ELECTRIC_2,SoundCategory.BLOCKS,3.0F,1.0F);
                            }
                            if (block == Blocks.OBSIDIAN){
                                if(state.getValue(LONE)){worldIn.playSound(null,pos,SoundsHandler.BLOCK_NOTE_SIX_STRINGS_2,SoundCategory.BLOCKS,3.0F,1.0F);}
                                else{worldIn.playSound(null,pos,SoundsHandler.BLOCK_NOTE_SIX_STRINGS_2_SHORT,SoundCategory.BLOCKS,3.0F,1.0F);}
                            }
                            if (block == Blocks.PLANKS){
                                worldIn.playSound(null,pos,SoundsHandler.BLOCK_NOTE_SIX_GUITAR_2,SoundCategory.BLOCKS,3.0F,1.0F);
                            }
                            if(block == Blocks.LOG){
                                worldIn.playSound(null,pos,SoundsHandler.BLOCK_NOTE_SIX_VIOLIN_2,SoundCategory.BLOCKS,3.0F,1.0F);
                            }
                            if(block == Blocks.SANDSTONE){
                                worldIn.playSound(null,pos,SoundsHandler.BLOCK_NOTE_SIX_BRASS_2,SoundCategory.BLOCKS,3.0F,1.0F);
                            }
                            if(block == Blocks.LEAVES){
                                worldIn.playSound(null,pos,SoundsHandler.BLOCK_NOTE_SIX_WOODWIND_2,SoundCategory.BLOCKS,3.0F,1.0F);
                            }
                        }

                        if (state.getValue(PITCH) == 1) {
                            if (block == Blocks.DIRT) {
                                worldIn.playSound(null, pos, SoundsHandler.BLOCK_NOTE_SIX_PIANO_1, SoundCategory.BLOCKS, 3.0F, 1.0F);
                            }
                            if (block == Blocks.GLOWSTONE){
                                worldIn.playSound(null,pos,SoundsHandler.BLOCK_NOTE_SIX_ELECTRIC_1,SoundCategory.BLOCKS,3.0F,1.0F);
                            }
                            if (block == Blocks.OBSIDIAN){
                                if(state.getValue(LONE)){worldIn.playSound(null,pos,SoundsHandler.BLOCK_NOTE_SIX_STRINGS_1,SoundCategory.BLOCKS,3.0F,1.0F);}
                                else{worldIn.playSound(null,pos,SoundsHandler.BLOCK_NOTE_SIX_STRINGS_1_SHORT,SoundCategory.BLOCKS,3.0F,1.0F);}
                            }
                            if (block == Blocks.PLANKS){
                                worldIn.playSound(null,pos,SoundsHandler.BLOCK_NOTE_SIX_GUITAR_1,SoundCategory.BLOCKS,3.0F,1.0F);
                            }
                            if(block == Blocks.LOG){
                                worldIn.playSound(null,pos,SoundsHandler.BLOCK_NOTE_SIX_VIOLIN_1,SoundCategory.BLOCKS,3.0F,1.0F);
                            }
                            if(block == Blocks.SANDSTONE){
                                worldIn.playSound(null,pos,SoundsHandler.BLOCK_NOTE_SIX_BRASS_1,SoundCategory.BLOCKS,3.0F,1.0F);
                            }
                            if(block == Blocks.LEAVES){
                                worldIn.playSound(null,pos,SoundsHandler.BLOCK_NOTE_SIX_WOODWIND_1,SoundCategory.BLOCKS,3.0F,1.0F);
                            }
                        }
                        if (state.getValue(PITCH) == 4) {
                            if (block == Blocks.DIRT) {
                                worldIn.playSound(null, pos, SoundsHandler.BLOCK_NOTE_SIX_PIANO_4, SoundCategory.BLOCKS, 3.0F, 1.0F);
                            }
                            if (block == Blocks.GLOWSTONE){
                                worldIn.playSound(null,pos,SoundsHandler.BLOCK_NOTE_SIX_ELECTRIC_4,SoundCategory.BLOCKS,3.0F,1.0F);
                            }
                            if (block == Blocks.OBSIDIAN){
                                if(state.getValue(LONE)){worldIn.playSound(null,pos,SoundsHandler.BLOCK_NOTE_SIX_STRINGS_4,SoundCategory.BLOCKS,3.0F,1.0F);}
                                else{worldIn.playSound(null,pos,SoundsHandler.BLOCK_NOTE_SIX_STRINGS_4_SHORT,SoundCategory.BLOCKS,3.0F,1.0F);}
                            }
                            if (block == Blocks.PLANKS){
                                worldIn.playSound(null,pos,SoundsHandler.BLOCK_NOTE_SIX_GUITAR_4,SoundCategory.BLOCKS,3.0F,1.0F);
                            }
                            if(block == Blocks.LOG){
                                worldIn.playSound(null,pos,SoundsHandler.BLOCK_NOTE_SIX_VIOLIN_4,SoundCategory.BLOCKS,3.0F,1.0F);
                            }
                            if(block == Blocks.SANDSTONE){
                                worldIn.playSound(null,pos,SoundsHandler.BLOCK_NOTE_SIX_BRASS_4,SoundCategory.BLOCKS,3.0F,1.0F);
                            }
                            if(block == Blocks.LEAVES){
                                worldIn.playSound(null,pos,SoundsHandler.BLOCK_NOTE_SIX_WOODWIND_4,SoundCategory.BLOCKS,3.0F,1.0F);
                            }
                        }
                        if (state.getValue(PITCH) == 5) {
                            if (block == Blocks.DIRT) {
                                worldIn.playSound(null, pos, SoundsHandler.BLOCK_NOTE_SIX_PIANO_5, SoundCategory.BLOCKS, 3.0F, 1.0F);
                            }
                            if (block == Blocks.GLOWSTONE){
                                worldIn.playSound(null,pos,SoundsHandler.BLOCK_NOTE_SIX_ELECTRIC_5,SoundCategory.BLOCKS,3.0F,1.0F);
                            }
                            if (block == Blocks.OBSIDIAN){
                                if(state.getValue(LONE)){worldIn.playSound(null,pos,SoundsHandler.BLOCK_NOTE_SIX_STRINGS_5,SoundCategory.BLOCKS,3.0F,1.0F);}
                                else{worldIn.playSound(null,pos,SoundsHandler.BLOCK_NOTE_SIX_STRINGS_5_SHORT,SoundCategory.BLOCKS,3.0F,1.0F);}
                            }
                            if (block == Blocks.PLANKS){
                                worldIn.playSound(null,pos,SoundsHandler.BLOCK_NOTE_SIX_GUITAR_5,SoundCategory.BLOCKS,3.0F,1.0F);
                            }
                            if(block == Blocks.LOG){
                                worldIn.playSound(null,pos,SoundsHandler.BLOCK_NOTE_SIX_VIOLIN_5,SoundCategory.BLOCKS,3.0F,1.0F);
                            }
                            if(block == Blocks.SANDSTONE){
                                worldIn.playSound(null,pos,SoundsHandler.BLOCK_NOTE_SIX_BRASS_5,SoundCategory.BLOCKS,3.0F,1.0F);
                            }
                            if(block == Blocks.LEAVES){
                                worldIn.playSound(null,pos,SoundsHandler.BLOCK_NOTE_SIX_WOODWIND_5,SoundCategory.BLOCKS,3.0F,1.0F);
                            }
                        }

                }

                tileEntityBtnoteSix.previousRedstoneState = flag;
            }
        }

    }

}
