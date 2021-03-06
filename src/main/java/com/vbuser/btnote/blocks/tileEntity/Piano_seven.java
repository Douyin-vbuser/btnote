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

public class Piano_seven extends BlockBase {

    public static final PropertyInteger PITCH = PropertyInteger.create("pitch", 1, 7);

    public static final PropertyBool HARD = PropertyBool.create("locked");

    public Piano_seven(String name, Material material, CreativeTabs tab) {
        super(name, material, tab);
        setSoundType(SoundType.WOOD);
        setHardness(4f);
        setResistance(20f);
        setHarvestLevel("axe", 2);
        setLightLevel(15f);
        setCreativeTab(Main.btnotetab);
        setDefaultState(this.blockState.getBaseState().withProperty(HARD, false).withProperty(PITCH, 4));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, HARD, PITCH);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int pitch = state.getValue(PITCH);
        return ((pitch > 3) ? (pitch - 4) : (pitch + 3)) + (state.getValue(HARD) ? 8 : 0);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(PITCH, (meta % 8 < 4) ? ((meta + 4 ) % 8 ) : ((meta - 3 ) % 7) ).withProperty(HARD, meta > 7);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (playerIn.getHeldItemMainhand().getItem() == ModItems.PITCH_TOOLS) {
            int pitch = state.getValue(PITCH);
            pitch = (pitch==7)?1:(pitch+1);
            worldIn.setBlockState(pos, state.withProperty(PITCH,pitch));
        }
        if(playerIn.getHeldItemMainhand().getItem() == ModItems.NOTE_TOOLS){
            if(state.getValue(HARD)) {
                worldIn.setBlockState(pos, state.withProperty(HARD, false));
            }
            else {
                worldIn.setBlockState(pos, state.withProperty(HARD, true));
            }
        }
        if(playerIn.getHeldItemMainhand().getItem() == Item.getItemFromBlock(Blocks.NOTEBLOCK)){
            int pitch = (state.getValue(PITCH)<2)?1:(state.getValue(PITCH)>6)?5:(state.getValue(PITCH)-1);
            worldIn.setBlockState(pos, ModBlocks.NOTE_SEVEN.getBlockState().getBaseState().withProperty(Note_seven.PITCH, pitch).withProperty(Note_seven.LONE,false), 2);
        }
        return true;
    }

    @Override
    public TileEntity createTileEntity(World worldIn, IBlockState state)
    {
        return new TileEntityPianoSeven();
    }

    @Override
    public boolean hasTileEntity(IBlockState state){
        return true;
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
        boolean flag = worldIn.isBlockPowered(pos);

        TileEntity tileentity = worldIn.getTileEntity(pos);

        if (tileentity instanceof TileEntityPianoSeven) {
            TileEntityPianoSeven tileEntityPianoSeven = (TileEntityPianoSeven) tileentity;

            if (tileEntityPianoSeven.previousRedstoneState != flag) {
                if (flag) {
                    if(state.getValue(HARD)) {
                        if (state.getValue(PITCH) == 1) {
                            worldIn.playSound(null, pos, SoundsHandler.BLOCK_PIANO_SEVEN_1, SoundCategory.BLOCKS, 10.0F, 1.0F);
                        }
                        if (state.getValue(PITCH) == 2) {
                            worldIn.playSound(null, pos, SoundsHandler.BLOCK_PIANO_SEVEN_2, SoundCategory.BLOCKS, 10.0F, 1.0F);
                        }
                        if (state.getValue(PITCH) == 3) {
                            worldIn.playSound(null, pos, SoundsHandler.BLOCK_PIANO_SEVEN_3, SoundCategory.BLOCKS, 10.0F, 1.0F);
                        }
                        if (state.getValue(PITCH) == 4) {
                            worldIn.playSound(null, pos, SoundsHandler.BLOCK_PIANO_SEVEN_4, SoundCategory.BLOCKS, 10.0F, 1.0F);
                        }
                        if (state.getValue(PITCH) == 5) {
                            worldIn.playSound(null, pos, SoundsHandler.BLOCK_PIANO_SEVEN_5, SoundCategory.BLOCKS, 10.0F, 1.0F);
                        }
                        if (state.getValue(PITCH) == 6) {
                            worldIn.playSound(null, pos, SoundsHandler.BLOCK_PIANO_SEVEN_6, SoundCategory.BLOCKS, 10.0F, 1.0F);
                        }
                        if (state.getValue(PITCH) == 7) {
                            worldIn.playSound(null, pos, SoundsHandler.BLOCK_PIANO_SEVEN_7, SoundCategory.BLOCKS, 10.0F, 1.0F);
                        }
                    }
                    else{
                        if (state.getValue(PITCH) == 1) {
                            worldIn.playSound(null, pos, SoundsHandler.BLOCK_PIANO_SEVEN_1, SoundCategory.BLOCKS, 1.0F, 1.0F);
                        }
                        if (state.getValue(PITCH) == 2) {
                            worldIn.playSound(null, pos, SoundsHandler.BLOCK_PIANO_SEVEN_2, SoundCategory.BLOCKS, 1.0F, 1.0F);
                        }
                        if (state.getValue(PITCH) == 3) {
                            worldIn.playSound(null, pos, SoundsHandler.BLOCK_PIANO_SEVEN_3, SoundCategory.BLOCKS, 1.0F, 1.0F);
                        }
                        if (state.getValue(PITCH) == 4) {
                            worldIn.playSound(null, pos, SoundsHandler.BLOCK_PIANO_SEVEN_4, SoundCategory.BLOCKS, 1.0F, 1.0F);
                        }
                        if (state.getValue(PITCH) == 5) {
                            worldIn.playSound(null, pos, SoundsHandler.BLOCK_PIANO_SEVEN_5, SoundCategory.BLOCKS, 1.0F, 1.0F);
                        }
                        if (state.getValue(PITCH) == 6) {
                            worldIn.playSound(null, pos, SoundsHandler.BLOCK_PIANO_SEVEN_6, SoundCategory.BLOCKS, 1.0F, 1.0F);
                        }
                        if (state.getValue(PITCH) == 7) {
                            worldIn.playSound(null, pos, SoundsHandler.BLOCK_PIANO_SEVEN_7, SoundCategory.BLOCKS, 1.0F, 1.0F);
                        }
                    }
                }
                tileEntityPianoSeven.previousRedstoneState = flag;
            }
        }
    }
}
